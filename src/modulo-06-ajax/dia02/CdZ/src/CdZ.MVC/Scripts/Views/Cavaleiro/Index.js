'use strict';

var ultimoId;
var $cavaleiros = $('#cavaleiros');

function carregarCavaleirosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .done(
        function onSuccess(res) {

            ultimoId = res.data[res.data.length - 1].Id;

            res.data.forEach(function (cava) {
                criarHtmlCavaleiro(cava);
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    );
};

carregarCavaleirosNaPagina();

$('#btnCriar').click(function (e) {
    $('#frmNovoCavaleiro').fadeIn(3000);

    e.preventDefault();
});

function appendarNovos() {
    $.ajax({
        url: urlCavaleiroGet,
        type: 'GET'
    }).done(function (res) {
        var contadorNovosCavaleiros = 0;

        res.data.forEach(function (cava) {
            if (cava.Id > ultimoId) {
               criarHtmlCavaleiro(cava);
               contadorNovosCavaleiros++;
               ultimoId = cava.Id;
            }
        });
        if (contadorNovosCavaleiros > 0) adicionarNotificação(contadorNovosCavaleiros);
    });
};

var recarregarLista = setInterval(appendarNovos, 5000);

function adicionarNotificação(numeroCavasAdicionados) {
    Notification
    .requestPermission()
    .then(function (result) {
        if (result === 'granted') {
            var frasePronta = numeroCavasAdicionados === 1 ?
                numeroCavasAdicionados + ' cavaleiro foi adicionado!' : numeroCavasAdicionados + ' cavaleiros foram adicionados!';

            var options = {

                body: frasePronta,
                icon: 'http://bit.ly/1TmHq3E'
            }
            new Notification('', options);
        }
    }
    )
};

//-------------------------------Criar html que appendará para cada cavaleiro---------------------------------------

function criarHtmlCavaleiro(cava) {
    var url = getThumb(cava);
    return $cavaleiros.append($('<li>')
        .append(cava.Nome)
        .append(
            $('<button>')
            .attr('data-cavaleiro-id',cava.Id)
            .attr('id','btnExcluir')
            .text('Excluir'))
        .append(
            $('<button>')
            .attr('data-cavaleiro-id', cava.Id)
            .attr('id', 'btnEditar')
            .text('Editar'))
        .append(
            $('<img>')
            .attr('src', url)
            .attr('class','imgThumb')));
        
}

//------------------------------------------------------------------------------------------------------------------

function excluirCavaleiroNoServidor() {
    alert('Excluído com sucesso!');
    var cavaleiroId = parseInt($(this).attr('data-cavaleiro-id'));

    $.ajax({
        url: '/Cavaleiro/Delete',
        type: 'DELETE',
        data: { id: cavaleiroId }
    });


}


$('#txtDtNascimento').datepicker({
    dateFormat: 'dd/MM/yy'
});

var $formCadastro = $('#frmNovoCavaleiro');

$formCadastro.submit(function (e) {
    e.preventDefault();

    var values =
        {
            Nome: $('#txtNomeCavaleiro').val(),
            AlturaCm: $('#nbAlturaMetros').val() * 100,
            PesoLb: $('#nbPesoKilos').val() * 2.20462,
            DataNascimento: $('#txtDtNascimento').datepicker('getDate').toISOString(),
            Signo: $('#slSigno').find(':selected').val(),
            TipoSanguineo: $('#slTipoSanguineo').find(':selected').val(),
            LocalNascimento: { Texto: $('#txtLocalNascimento').val() },
            LocalTreinamento: { Texto: $('#txtLocalTreinamento').val() },
            Golpes: buscarGolpes(),
            Imagens: buscarImagens()
        }

    $.post('/Cavaleiro/Post/', values);

    alert('Cavaleiro cadastrado!');
});

// Adicionar inputs de golpes e imagens ------------------------------------------------------------------------
$('#btnAdicionarGolpe').click(function () {
    $('#novosGolpes')
    .append($('<li>')
    .append(
    $('<input>')
    .attr('placeholder', 'Ex. Kamehameha')
    .attr('class', 'form-control')
    .attr('name', 'inputGolpe')));
});

$('#btnAdicionarImg').click(function () {
    $('#novasImagens')
    .append(
        $('<li>').append(
            $('<input>')
            .attr('placeholder', 'Ex. bit.ly/jon_snow.jpeg')
            .attr('class', 'form-control')
            .attr('name', 'inputImg')
        )
        .append(
            $('<label>')
            .attr('for', 'checkboxThumb')
            .text('É thumbnail?')
        )
        .append(
            $('<input>')
            .attr('type', 'checkbox')
            .attr('name', 'checkboxThumb')
        )
    );
});
//---------------------------------------------------------------------------------------------------------------

// Pegar valores dos inputs de golpes e imagens -----------------------------------------------------------------
function buscarGolpes() {
    var listaGolpes = [];

    $('#novosGolpes li').each(function () {

        listaGolpes.push(
            {
                Nome: $(this).find('input[name="inputGolpe"]').val()
            }
            );
    });

    return listaGolpes;
};

function buscarImagens() {
    var listaImagens = [];

    $('#novasImagens li').each(function () {
        listaImagens.push(
            {
                Url: $(this).find('input[name=inputImg]').val(),
                IsThumb: $(this).find('input[name="checkboxThumb"]').is(':checked')
            }
        );
    });
    return listaImagens;
}
//-------------------------------------------------------------------------

//Checar se há imagem com IsThumb, se não, retorna a url padrão -----------------------------------

function getThumb(cava) {
  
    var imgIsThumb = cava.Imagens.filter(function (i) {
        return i.IsThumb;
    });
    if (imgIsThumb != null || imgIsThumb != undefined) {
        return imgIsThumb[0].Url;

    } else {
        return 'http://bit.ly/1WL3Dca';
    }

}
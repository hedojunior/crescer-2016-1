'use strict';

var ultimoId;

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            ultimoId = res.data[res.data.length - 1].Id;
            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
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
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};
carregarDadosNaPagina();

function appendarNovos() {
    $.ajax({
        url: urlCavaleiroGet, type: 'GET'
    })
    .done(function (res) {
        res.data.forEach(function (cava) {
            if (cava.Id > ultimoId) {
                $('#cavaleiros').append(
                    $('<li>').append(cava.Nome)

                );
            }
        });
    });
};
 
setTimeout(appendarNovos, 5000);

function criarHtmlCavaleiro(cava) {
    return $('<li>')
        .append(cava.Nome)
        .append(
            $('<button>')
                .attr('data-cavaleiro-id', cava.Id)
                .click(excluirCavaleiroNoServidor)
                .text('Excluir')
        );
}

function excluirCavaleiroNoServidor() {
    alert('Excluído com sucesso!');
    var cavaleiroId = parseInt($(this).attr('data-cavaleiro-id'));

    $.ajax({
        url: '/Cavaleiro/Delete' + $.param({ id: cavaleiroId }),
        type:'DELETE'
    });
      
        
}

function registrarEventoDoBotao() {
    $('#btnCriar').click(function () {

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: 'Xiru ' + new Date().getTime(),
                AlturaCm: 187,
                Signo: 7,
                TipoSanguineo: 1,
                DataNascimento: new Date(),
                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                LocalNascimento: {
                    Texto: 'Beijing'
                },
                LocalTreinamento: {
                    Texto: '5 picos de rosan'
                },
                Imagens: [{
                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                    IsThumb: true
                }, {
                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                    IsThumb: false
                }]
            }
        });

    });
};
registrarEventoDoBotao();



/*.done(function (res) {
    console.log(res.data);
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            $cavaleiros.append(
                $('<li>').append(cava.Nome)
            );
        });
})
.fail(function (res) {
    console.error(':(');
    console.error(res);

    var criarSpanComErro = function (msg) {
        return $('<span>').text(msg).addClass('erro');
    };

    $('#feedback')
    .append(criarSpanComErro(res.status))
    .append($('<br>'))
    .append(criarSpanComErro(res.statusText));
});*/
'use strict';

var ultimoId;
var $cavaleiros = $('#cavaleiros');

function carregarCavaleirosNaPagina () {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .done(
        function onSuccess(res) {

            ultimoId = res.data[res.data.length - 1].Id;

            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                    .append($('<button>')
                    .attr('data-cavaleiro-id', cava.Id)
                    .click(excluirCavaleiroNoServidor)
                    .text('Excluir'))
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

carregarCavaleirosNaPagina();

function appendarNovos() {
    $.ajax({
        url: urlCavaleiroGet,
        type: 'GET'
    }).done(function (res) {
        console.log('batata 46');
        var contadorNovosCavaleiros = 0;
            
        res.data.forEach(function (cava) {
            if (cava.Id > ultimoId) {
                $cavaleiros
                .append($('<li>')
                        .append(cava.Nome)
                            .append($('<button>')
                                        .attr('data-cavaleiro-id', cava.Id)
                                        .click(excluirCavaleiroNoServidor)
                                        .text('Excluir'))
                );
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
        .then(function(result) {
            if(result === 'granted'){
                var frasePronta = numeroCavasAdicionados === 1 ? 
                    numeroCavasAdicionados + ' cavaleiro foi adicionado!' : numeroCavasAdicionados + ' cavaleiros foram adicionados!';

                var options = {
                    
                    body: frasePronta,
                    icon: 'http://bit.ly/1TmHq3E'
                }
                new Notification('',options);
            }    
        }
        )};

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
            url: '/Cavaleiro/Delete',
            type: 'DELETE',
            data: { id: cavaleiroId }
        });


    }

    //function registrarEventoDoBotao() {
    //    $('#btnCriar').click(function () {

    //        $.ajax({
    //            url: urlCavaleiroPost,
    //            type: 'POST',
    //            data: {
    //                Nome: 'Xiru ' + new Date().getTime(),
    //                AlturaCm: 187,
    //                Signo: 7,
    //                TipoSanguineo: 1,
    //                DataNascimento: new Date(),
    //                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
    //                LocalNascimento: {
    //                    Texto: 'Beijing'
    //                },
    //                LocalTreinamento: {
    //                    Texto: '5 picos de rosan'
    //                },
    //                Imagens: [{
    //                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
    //                    IsThumb: true
    //                }, {
    //                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
    //                    IsThumb: false
    //                }]
    //            }
    //        });

    //    });
    //};
    //registrarEventoDoBotao();

    var $formCadastro = $('#frmNovoCavaleiro');

$formCadastro.submit(function (e) {
    e.preventDefault();
    console.log('batata151');
    var novosGolpes = [{ Nome: null }];
    $('#novosGolpes li').each(function (i) {
        novosGolpes.push({ Nome: $(this).find('input[name=inputGolpe]').val() });
    });

    if (novosGolpes.length >= 2) {
        novosGolpes.shift();
    };

    var temThumb = false;
    var novasImagens = [{ url: 'https://i.ytimg.com/vi/trKzSiBOqt4/hqdefault.jpg', isThumb: true }];
    $('#novasImagens li').each(function () {
        var imagem = {
            url: $(this).find('input[name=inputImg]').val(),
            isThumb: $(this).find('input[name=checkboxThumb]').is(':checked')
        };

        novasImagens.push(imagem);
        if (imagem.isThumb) {
            temThumb = true;
        }
    });

    if (novasImagens.length >= 2 && temThumb) {
        novasImagens.shift();
    };
   
    var values =
        {
            Nome: $('#txtNomeCavaleiro').val(),
            AlturaCm: $('#nbAlturaMetros').val() * 100,
            PesoLb: $('#nbPesoKilos').val() * 0.4536,
            DataNascimento: new Date($('#txtDtNascimento').val()).toISOString(),
            Signo: $('#slSigno').find(':selected').val(),
            TipoSanguineo: $('#slTipoSanguineo').find(':selected').val(),
            LocalNascimento: { Texto: $('#txtLocalNascimento').val() },
            LocalTreinamento: { Texto: $('#txtLocalTreinamento').val() },
            Golpes: novosGolpes,
            Imagens: novasImagens
        }
        
    $.post('/Cavaleiro/Post/', values);

    alert('Cavaleiro cadastrado!');
});

 // Adicionar inputs de golpes e imagens ------------------------------------------------------------------------
    $('#btnAdicionarGolpe').click(function () {
        $('#novosGolpes')
        .append('<li>')
        .append($('<input placeholder="Ex. Atirar Gelo Negro" class="form-control inputsGolpes" name="inputGolpe" />'));
    });

    $('#btnAdicionarImg').click(function () {
        $('#novasImagens')
        .append('<li>')
        .append($('<input placeholder="Ex. bit.ly/jon_snow.jpeg" class="form-control inputImg" name="inputImg" />'))
        .append($('<label for="checkboxThumb">').text('É thumbnail?'))
        .append($('<input type="checkbox" id="checkboxThumb" name="checkboxThumb" />'));
    });
//---------------------------------------------------------------------------------------------------------------

// Pegar valores dos inputs de golpes e imagens -----------------------------------------------------------------
    function buscarGolpes() {
        var listaGolpes = [];
        var id = 0;
        $('#novosGolpes li input').each(function () {
            listaGolpes.push(
                {
                    Id: id, 
                    Nome: $(this).val()
                }
                );
            id++;
        });

        return listaGolpes;
    };

    function buscarImagens() {
        var listaImagens = [];
        var id = 0;
        $('#novasImagens li').each(function () {
            listaImagens.push(
                {
                    Id: id,
                    Url: $(this).find('.inputImg').val(),
                    IsThumb: $(this).find('#checkboxThumb').is(':checked')
                }
            );
            id++;
        });
        return listaImagens;
    }
//-------------------------------------------------------------------------
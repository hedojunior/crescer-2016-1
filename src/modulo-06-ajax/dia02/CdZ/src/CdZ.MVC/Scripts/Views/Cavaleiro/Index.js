'use strict';

var ultimoId;
var $cavaleiros = $('#cavaleiros');
function carregarCavaleirosNaPagina () {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .done(
        function onSuccess(res) {
            console.log(res.data);
            console.log('potatO');
            ultimoId = res.data[res.data.length - 1].Id;
            console.log(ultimoId);
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

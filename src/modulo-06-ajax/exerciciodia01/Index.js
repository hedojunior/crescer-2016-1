'use strict';

$('#carregarImagens').click(function carregarIronMaiden() {

  $.ajax({ url: urlSpotifyGet, type: 'GET' })
  .then(
    function onSuccess(res) {
      var $lista = $('#lista')
      apendarImagens(res, $lista);
    }
  );
});
//------------------

$('#pesquisaEcletica').click(function(e){

  var valorPesquisa = $('#TermoPesquisa').val();

  var chance = Math.random();
  var trocarUrl = true;
  if(chance <= 0.20) trocarUrl = false;

  var urlValorPesquisa = 'https://api.spotify.com/v1/search?q=' + valorPesquisa +'&type=artist';

  $.get({
    url: urlValorPesquisa,
    success: function(res){
      var id = res.artists.items[0].id;
      var urlArtistaPorId = checarSeEhJustinBieber(trocarUrl, valorPesquisa, id);
      $.get({
        url: urlArtistaPorId,
        success: function(res) {
          var $lista = $('#lista');
          apendarImagens(res, $lista);
        },

        error: function(xhr, err){
          if (xhr.status === 400)
          alert('Caro usuário, devido a um erro ' + xhr.status + ', não foi possível pesquisar por ' + valorPesquisa);
        }
      });
    }
  });
});

//uteis

function checarSeEhJustinBieber(trocarUrl, valorPesquisa, id) {
  if (trocarUrl === true && valorPesquisa === "Justin Bieber")
  return 'https://api.spotify.com/v1/artists/douchebag/albums?limit=50';
  else
  return 'https://api.spotify.com/v1/artists/' + id + '/albums?limit=50';
}
//---------------
function apendarImagens(res, $lista) {
  $lista.empty();
  res.items.forEach(function(cover){
    $lista
    .append($('<li>')
    .append($('<img>').attr('src',cover.images[1].url))).hide().fadeIn(1000);
  });
}

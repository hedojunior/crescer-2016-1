//declarar variável e passar a ela um valor
var goku = 'Goku';

//identificar tipo do valor na variável
typeof goku //retorna string

//Variáveis podem ser funções as well
goku = function() { console.log('Goku'); }

//retorna 'function'
typeof goku;

//declarando parâmetros no método dentro de goku
goku = function(numero) { console.log(numero); };

//Objeto
goku = { nome: 'Goku', idade: 30 };

// pegar o nome do goku
goku.nome
//setar o nome do goku
goku.nome = 'Son Goku';

//adicionar variaveis a um Objeto
goku.filhos = [ 'Gohan', 'Goten'];

//descobre o tipo real de filhos, vendo a função com qual foi criado (Array)
goku.filhos.constructor == Array

//divisão por false
10 / false// retorna Infinity

//verificar se é um número
isNaN(10/'two');

// verificar se uma variável é indefinida
if (typeof goku !== 'undefined') { console.log('Ta definido'); } else { console.log('Nao'); };


function somar(a,b) { return a + b; };
var sub = function() {
var a = arguments[0];


   fn(a - b); };

var funcoes = [somar(1,1), sub ];
var imprimirResultado = function(res) {
  console.log('O resultado é: ', res);
}
funcoes[1](3,2, imprimirResultado);

//----- Define uma função que imprime o valor (e) e o índice (index). Então, chama o for each que, para cada posição em goku.filhos,
// imprime o valor (e) que seria o nome, e imprime o índice.
var imprimeFilho = function(e, index) { console.log(e, index);};
goku.filhos.forEach(imprimeFilho);

'use strict';
//ex1
function daisyGame(num) {
    console.log(num % 2 !== 0 ? 'Love me':'Love me not');
}
//ex2
function maiorTexto(arr) {
  for (var i = 0, len = arr.length; i < len; i++){
    maior = arr[0];
    if(i!== 0 && arr[i].length > arr[i - 1].length) maior = arr[i];
  }
  return console.log(maior);
}
//ex3
function imprime(arr,fn) {
  if (typeof fn !== 'function') {
    console.log('O segundo argumento deve ser uma função!');
  }
  else {
    arr.forEach(fn);
  }
}
//ex4
function adicionar(a) {
  return function add(b) {
    return a + b;
  }
}
//ex5
function fiboSum(num){
var atual = 0, anterior = 0, fibo = 0;
  for (var i = 1; i <= num; i++) {
    if (i == 1) {
      atual = 1;
      fibo = 1;
      anterior = 0;
    }
    else {
      atual += anterior;
      anterior = atual - anterior;
      fibo += atual;
    }
  }
  return fibo;
}
//ex6
function queroCafe(val,arr){
  var stringRetorno = " ";
  order(arr);
  for(var i = 0; i < arr.length;i ++){
    if (arr[i] <= val){
      if(arr[i + 1] > val){
        stringRetorno += arr[i];
      }
      else {
        stringRetorno += arr[i] + ",";
      }
    }
  }
 return console.log(stringRetorno);
}
//Bubble sort
function order(arr){
  var aux;
  for (var i = 0; i < arr.length; i++) {
    for(var j = 0; j < arr.length - 1; j++) {
      if(arr[j] > arr[j+1]){
        aux = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = aux;
      }
    }
  }
}
//ex7
function contarPorTipo(obj,str){
  var contadorTipo = contarPorConstrutor(obj,str);
  return console.log(contadorTipo);
}

function contarPorConstrutor(obj, str) {
var contador = 0;
  for (e in obj) {
    if (typeof obj[e] === str){
      contador++;
    }
  }
  return contador;
}
//ex8
var gohan = 'gohan', goku = 'Goku';
// as variáveis são declaradas e lhes é dado valor FORA do método, no escopo global da classe
console.log(gohan);
// se rodarmos esse console, ele imprime gohan normalmente, pois está fora do método, no escopo global, e está usando
// o valor passado pela variável declarada acima.
function revelarSaiyaman() {
  //inicia a função, a partir de agora as variáveis são de escopo local e qualquer variável criada aqui vai subs-
  //tituir o valor que foi passado na parte global.
  console.log(gohan);
  //imprime undefined
  console.log(goku);
  //imprime goku
  goku = 'Son Goku';
  var gohan = 'Son ' + gohan;
  return gohan;
}
/* Explicação: Quando o método inicia, o escopo passa a ser local. ou seja, qualquer variável que for DECLARADA dentro desse método  vai ser
de uso somente dele, substituindo o valor que vem do escopo global. Por esse motivo que ao dar console no gohan é impresso undefined e ao dar
console no goku é impresso Goku. Note que a única variável que é declarada novamente é gohan, que então substitui o valor passado pela vari-
ável global. Goku imprime normalmente pois não é declarado novamente no método. Porém, se botarmos 'var goku = 'Son' +goku;', vamos ter outro
Son undefined, pelo mesmo motivo do gohan. após a mudança, o método retorna a variável local, que sobreescreve a global e por isso aparece Son
undefined. Goku, por sua vez, sofre a alteração dentro do método e continua com as alterações, pois a variável não foi sobrescrita dentro do
método.
*/
console.log(revelarSaiyaman());
console.log(goku);

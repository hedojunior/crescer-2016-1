//ex1
function daisyGame(num) {
    console.log(num % 2 !== 0 ? 'Love me':'Love me not');
}
//ex2
function maiorTexto(arr){
  arr.forEach(verificaTexto);
}

function verificaTexto(arr) {
  for (var i = 0, len = arr.length; i < len; i++){
    maior = arr[0];
    if(i!= 0 && arr[i].length > arr[i - 1].length) maior = arr[i];
    return console.log(maior);
  }
}

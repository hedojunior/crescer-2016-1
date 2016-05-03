'use strict';

describe('Ex 1. Doadores Sanguíneos', function() {
  it('quando roda, retorna um array com os cavaleiros com sangue tipo \'O\'', function() {
    var possiveis = JSON.parse('[{"id":5,"nome":"Aiolia","dataNascimento":"1967-08-16T03:00:00.000Z","alturaCm":185,"pesoLb":187.392923,"signo":"Leão","tipoSanguineo":"O","localNascimento":"Grécia","localTreinamento":"Santuário, Grécia","golpes":["Cápsula do Poder","Pata do Leão","Relâmpago de Plasma"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14900613/c4ba42f0-0d67-11e6-9c0e-e79c2278ab0b.png","isThumb":true}]},{"id":9,"nome":"Aiolos","dataNascimento":"1960-11-30T03:00:00.000Z","alturaCm":187,"pesoLb":187.392923,"signo":"Sagitário","tipoSanguineo":"O","localNascimento":"Grécia","localTreinamento":"Santuário, Grécia","golpes":["Trovão Atômico","Flecha da Justiça"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14901061/e5fe3b90-0d69-11e6-9a78-2449055be1fa.png","isThumb":true}]},{"id":12,"nome":"Afrodite","dataNascimento":"1965-03-10T03:00:00.000Z","alturaCm":183,"pesoLb":158.732829,"signo":"Peixes","tipoSanguineo":"O","localNascimento":"Suécia","localTreinamento":"Groelândia","golpes":["Rosas Diabólicas Reais","Rosas Piranhas","Rosa Branca"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14901259/f4a0b3ca-0d6a-11e6-89b1-59855cabc43d.png","isThumb":true}]}]');
    expect(obterDoadores()).toEqual(possiveis);
  });
});

describe('Ex 2. Canivete Suiço', function() {
   it('Retorna o cdz com o maior número de golpes', function() {
     var esperado = JSON.parse('{"id":6,"nome":"Shaka","dataNascimento":"1967-09-19T03:00:00.000Z","alturaCm":182,"pesoLb":149.914338,"signo":"Virgem","tipoSanguineo":"AB","localNascimento":"\u00cdndia","localTreinamento":"Ganges, \u00cdndia","golpes":["Rendi\u00e7\u00e3o Divina","Ciclo das 6 Exist\u00eancias","Tesouro do C\u00e9u","Invoca\u00e7\u00e3o dos Esp\u00edritos","Ohm!","Kahn!"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900695\/4a5675dc-0d68-11e6-8396-2a775a2b0c39.png","isThumb":true}]}');
     expect(obterCavaleiroComMaisGolpes()).toEqual(esperado);
   });
//   it('quando informa array com apenas um elemento retorna o mesmo', function() {
//     expect(maiorTexto([ 'único' ])).toBe('único');
//   });
//   it('quando informa array com duas strings de mesmo tamanho retorna o primeiro', function() {
//     // Arrange
//     var arrayComDoisElementos = [ 'm3sm0', 'mesmo' ];
//     var esperado = 'm3sm0';
//     // Act
//     var obtido = maiorTexto(arrayComDoisElementos);
//     // Assert
//     expect(obtido).toBe(esperado);
//   í
//   it('quando informa array com duas strings diferentes', function() {
//     expect(maiorTexto([ 'm3sm0', 'maior!!' ])).toBe('maior!!');
//   });
//   it('quando informa array com várias strings diferentes', function() {
//     expect(maiorTexto([ 'm3sm0', 'abacate', 'goku', 'yajirobe', 'freeza', 'kuririn' ])).toBe('yajirobe');
//   });
});

// describe('Ex 3. Instrutor querido', function() {
//   window.imprimeNoConsole = function(instrutor) {
//    console.log('olá querido instrutor:', instrutor)
//   }
//
//   beforeEach(function() {
//     spyOn(window, 'imprimeNoConsole');
//   });
//
//   it('quando informa função imprimir no console para todos instrutores', function() {
//     // Arrange
//     var instrutores = [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ];
//     // Act
//     imprime(instrutores, imprimeNoConsole);
//     // Assert
//     expect(imprimeNoConsole.calls.count()).toBe(5);
//     instrutores.forEach(function(i) {
//       expect(imprimeNoConsole).toHaveBeenCalledWith(i);
//     });
//   });
//
//   it('quando informa função imprimir no console para array vazio', function() {
//     // Arrange
//     var instrutores = [];
//     // Act
//     imprime(instrutores, imprimeNoConsole);
//     // Assert
//     expect(imprimeNoConsole.calls.count()).toBe(0);
//   });
//
//   it('quando informa função imprimir no console para um instrutor', function() {
//     // Arrange
//     var instrutores = [ 'bernardo' ];
//     // Act
//     imprime(instrutores, imprimeNoConsole);
//     // Assert
//     expect(imprimeNoConsole.calls.count()).toBe(1);
//     expect(imprimeNoConsole).toHaveBeenCalledWith(instrutores[0]);
//   });
//
//   it('quando informa algo que não é função', function() {
//     imprime([ 'bernardo' ], 3.14);
//     expect(imprimeNoConsole.calls.count()).toBe(0);
//   });
//
// });

// describe('Ex 4. Soma diferentona', function() {
//   it('quando informa 3 e 4', function() {
//     expect(adicionar(3)(4)).toBe(7);
//   });
//   it('quando informa 5642 e 8749', function() {
//     expect(adicionar(5642)(8749)).toBe(14391);
//   });
//   it('quando informa 0 e 0', function() {
//     expect(adicionar(0)(0)).toBe(0);
//   });
//   it('quando não informa parcela alguma', function() {
//     expect(adicionar()()).toBeNaN();
//   });
//   it('quando não informa primeira parcela', function() {
//     expect(adicionar()(1)).toBeNaN();
//   });
//   it('quando não informa segunda parcela', function() {
//     expect(adicionar(1)()).toBeNaN();
//   });
//   it('quando informa -3 e 2.5', function() {
//     expect(adicionar(-3)(2.5)).toBe(-0.5);
//   });
// });

// describe('Ex 5. Fibona', function() {
//   it('quando informa 1 = 1', function() {
//     expect(fiboSum(1)).toBe(1);
//   });
//   it('quando informa 2 = 1+1', function() {
//     expect(fiboSum(2)).toBe(2);
//   });
//   it('quando informa 3 = 1+1+2', function() {
//     expect(fiboSum(3)).toBe(4);
//   });
//   it('quando informa 4 = 1+1+2+3', function() {
//     expect(fiboSum(4)).toBe(7);
//   });
//   it('quando informa 5 = 1+1+2+3+5', function() {
//     expect(fiboSum(5)).toBe(12);
//   });
//   it('quando informa 6 = 1+1+2+3+5+8', function() {
//     expect(fiboSum(6)).toBe(20);
//   });
//   it('quando informa 7 = 1+1+2+3+5+8+13', function() {
//     expect(fiboSum(7)).toBe(33);
//   });
// });

// describe('Ex 6. Quero café', function() {
//   it('quando informa vários números', function() {
//     expect(queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ])).toBe('1.15,2.12,3.11');
//   });
//   it('quando informa vários números e todos menores', function() {
//     expect(queroCafe(300, [ 5.16, 2.12, 1.15, 3.11, 17.5 ])).toBe('1.15,2.12,3.11,5.16,17.5');
//   });
//   it('quando informa vários números e nenhum menor', function() {
//     expect(queroCafe(0.3, [ 5.16, 2.12, 1.15, 3.11, 17.5 ])).toBe('');
//   });
//   it('quando informa array vazio', function() {
//     expect(queroCafe(0.3, [])).toBe('');
//   });
//   it('quando informa array com um elemento', function() {
//     expect(queroCafe(0.3, [ 0.3 ])).toBe('0.3');
//   });
// });

// describe('Ex 7. Vários tipos', function() {
//   it('quando informa string', function() {
//     var goku = { nome: 'Goku', classe: 'Saiyajin', humano: false, saiyajin: true };
//     expect(contarPorTipo(goku, 'string')).toBe(2);
//   });
//   it('quando informa number', function() {
//     var goku = { nome: 'Goku', classe: 'Saiyajin', ki: 999500, humano: false, saiyajin: true };
//     expect(contarPorTipo(goku, 'number')).toBe(1);
//   });
//   it('quando informa boolean', function() {
//     var goku = { nome: 'Goku', classe: 'Saiyajin', humano: false, saiyajin: true };
//     expect(contarPorTipo(goku, 'boolean')).toBe(2);
//   });
//   it('quando informa object', function() {
//     var goku = { nome: 'Goku', classe: { descricao: 'Saiyajin' }, anoNascimento: new Date(1987, 1, 1), humano: false, filhos: [ 'Gohan', 'Goten' ], golpes: [ 'Kamehameha', 'Genki-dama' ] };
//     expect(contarPorTipo(goku, 'object')).toBe(2);
//   });
//   it('quando informa undefined', function() {
//     var goku = { nome: 'Goku', classe: undefined, anoNascimento: undefined, humano: undefined };
//     expect(contarPorTipo(goku, 'undefined')).toBe(3);
//   });
//   it('quando informa null', function() {
//     var goku = { nome: 'Goku', classe: null, anoNascimento: new Date(1987, 1, 1), humano: undefined };
//     expect(contarPorTipo(goku, 'null')).toBe(1);
//   });
//   it('quando informa function', function() {
//     var goku = { nome: 'Goku', classe: null, anoNascimento: undefined, kamehameha: function() {} };
//     expect(contarPorTipo(goku, 'function')).toBe(1);
//   });
//   it('quando informa array', function() {
//     var goku = { nome: 'Goku', kaioken: undefined, classe: null, anoNascimento: new Date(1987, 1, 1), kamehameha: function() {}, filhos: [ 'Gohan', 'Goten' ], golpes: [ 'Kamehameha', 'Genki-dama' ] };
//     expect(contarPorTipo(goku, 'array')).toBe(2);
//   });
// });

/*
Faça um bloco PL/SQL que receba UM parâmetro (em tempo de execução apenas): IDCliente
, e então pesquise nome do cliente e cidade (caso tenha), e outras informações referente
a pedidos: 
  Data da primeira compra (pedido) realizado; 
  Data da última compra realizada. 
  Valor total dos pedidos, quantidade de pedidos e média de valor dos pedidos. 
*/

DECLARE

vNomeCliente VARCHAR2(100);
vNomeCidade VARCHAR2(100);
vDataPrimeiraCompra DATE;
vDataUltimaCompra DATE;
vValorTotalPedidos NUMBER(20,2);
vQuantidadePedidos NUMBER(20,2);
vMediaValorPedidos NUMBER(20,2);

BEGIN

SELECT 
  cli.Nome, 
    cid.Nome, 
      MIN(ped.DataPedido),
        MAX(ped.DataPedido),
          SUM(ped.ValorPedido),
            SUM(pi.Quantidade),
              AVG(ped.ValorPedido)
INTO 
  vNomeCliente,
    vNomeCidade,
      vDataPrimeiraCompra,
        vDataUltimaCompra,
          vValorTotalPedidos,
            vQuantidadePedidos,
              vMediaValorPedidos
FROM 
Cliente cli 
  JOIN Cidade cid 
    on cli.IDCidade = cid.IDCidade
  JOIN Pedido ped 
    on cli.IDCliente = ped.IDCliente
  JOIN PedidoItem pi 
    on ped.IDPedido = pi.IdPedido
  WHERE 
    cli.IDCliente = &pIDCliente
  GROUP BY cli.Nome,cid.NOME;

DBMS_OUTPUT.PUT_LINE
  ('Nome do Cliente: ' || vNomeCliente || CHR(13) || 
    ' Cidade do Cliente: ' || vNomeCidade || CHR(13) ||
    ' Data primeira compra: ' || vDataPrimeiraCompra || CHR(13) ||
    ' Data ultima compra: ' || vDataUltimaCompra || CHR(13) ||
    ' Valor total dos pedidos: ' || vValorTotalPedidos || CHR(13) ||
    ' Quantidade de pedidos: ' || vQuantidadePedidos || CHR(13) ||
    ' Media de valor dos pedidos: ' || vMediaValorPedidos);

END;

/*
Faça um bloco PL/SQL que receba DOIS parâmetros (em tempo de execução apenas): nome e uf,
verifique se já existe um registro em Cidade para a combinação, caso não exista faça um INSERT na tabela de Cidade.
o Utilize uma SEQUENCE para gerar o próximo ID válido; o Ignore o case sensitive na validação.  
o Se já existir a cidade+uf deve imprimir uma mensagem informando. 
*/

DECLARE
vExisteCidade Integer;
vParamNomeCidade VARCHAR2(100) := '&NomeCidade';
vParamUFCidade VARCHAR2(2) := '&UFCidade';

BEGIN

SELECT Count(1) 
INTO vExisteCidade
from Cidade where lower(Nome) = lower(vParamNomeCidade) and lower(UF) = lower(vParamUFCidade);

if (vExisteCidade = 0) then
INSERT INTO Cidade(Nome,UF) Values (vParamNomeCidade, vParamUFCidade);
else
DBMS_OUTPUT.PUT_LINE('A cidade já existe!');
end if;

end;


/*Crie um procedimento que receba por parâmetro o IDPedido e atualize o valor do pedido conforme seus itens.
? Valor unitário * Quantidade */

CREATE PROCEDURE 
  CalculoValorPedido (pIDPedido In Number) as 
BEGIN 
  Update PEDIDO 
    set VALORPEDIDO = 
      (select (PRECOUNITARIO * QUANTIDADE) from PEDIDOITEM WHERE PEDIDOITEM.IDPEDIDO = pIDPedido and rownum = 1) 
    WHERE IDPEDIDO = pIDPedido; 
END;

DECLARE
  vIDPedido NUMBER := '&Informe_IDPedido';
BEGIN
  CalculoValorPedido(vIDPedido);
END;

/*Crie uma função que receba por parâmetro o IDCliente e retorne a data do último pedido realizado pelo cliente.*/

CREATE OR REPLACE 
FUNCTION BUSCA_DATA_ULTIMO_PEDIDO
(pIDCliente in Number) RETURN DATE as vDataUltimoPedido PEDIDO.DATAPEDIDO%type;
BEGIN
  SELECT max(ped.DATAPEDIDO)
  INTO vDataUltimoPedido
  FROM Pedido ped
  JOIN Cliente cli
  on ped.IDCLIENTE = cli.IDCLIENTE
  WHERE cli.IDCLIENTE = pIDCliente;
  
  RETURN vDataUltimoPedido;
  
EXCEPTION
  When no_data_found Then
    Return 'Produto não encontrado!';
END;

select Nome, BUSCA_DATA_ULTIMO_PEDIDO(&IDCliente) as Data_Ultimo_Pedido
from Cliente where IDCliente = &IDCliente;

/*Crie uma função que receba por parâmetro o IDProduto e o período (mês e ano) e retorne a quantidade (total)
desde produtos vendidos no período (considere todos os dias do mês).*/

CREATE OR REPLACE
FUNCTION Quantidade_vendida_periodo (vIDProduto IN Number, vPeriodo IN DATE)
RETURN NUMBER AS vQuantidade PEDIDOITEM.QUANTIDADE%type;  
BEGIN
SELECT SUM(pi.QUANTIDADE)
INTO vQuantidade
FROM PedidoItem pi
JOIN Pedido ped
ON pi.IDPedido = ped.IDPedido
JOIN Produto prod
ON pi.IDProduto = prod.IDProduto
WHERE prod.IDProduto = vIDProduto
AND ped.DATAPEDIDO BETWEEN FIRST_DAY(EXTRACT(MONTHFROMDATE vPeriodo)) AND LAST_DAY(EXTRACT(MONTHFROMDATE vPeriodo)))
AND EXTRACT(YEARFROMDATE ped.DATAPEDIDO) = EXTRACT(YEARFROMDATE vPeriodo)
AND EXTRACT(MONTHFROMDATE ped.DATAPEDIDO) = EXTRACT(MONTHFROMDATE vPeriodo);
RETURN vQuantidade;

END;                 

select Quantidade_Vendida_Periodo(&IDProduto, &Periodo) from DUAL; 

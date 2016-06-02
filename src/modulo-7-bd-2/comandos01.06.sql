/*
Faça um bloco PL/SQL que receba UM parâmetro (em tempo de execução apenas): IDCliente
, e então pesquise nome do cliente e cidade (caso tenha), e outras informações referente
a pedidos: 
o  Data da primeira compra (pedido) realizado; 
o  Data da última compra realizada. 
o  Valor total dos pedidos, quantidade de pedidos e média de valor dos pedidos. 
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
select max(IDCidade) from Cidade;

DECLARE
vExisteCidade Integer;
vParamNomeCidade VARCHAR2(100) := '&NomeCidade';
vParamUFCidade VARCHAR2(2) := '&UFCidade';

BEGIN

SELECT Count(1) 
INTO vExisteCidade
from Cidade where lower(Nome) = lower(vParamNomeCidade) and lower(UF) = lower(vParamUFCidade);

if (vExisteCidade = 0) then
INSERT INTO Cidade(IDCidade,Nome,UF) Values (sqCidade.nextval,vParamNomeCidade, vParamUFCidade);
else
DBMS_OUTPUT.PUT_LINE('A cidade já existe!');
end if;

end;

-- EX 1 PROCEDURE
CREATE PROCEDURE
  CalculoValorPedido (pIdPedido In Number) as
BEGIN
  Update Pedido
    set ValorPedido = 
      (select SUM(PRECOUNITARIO * QUANTIDADE) from PEDIDOITEM WHERE PEDIDOITEM.IDPEDIDO = pIDPedido)
    WHERE IDPEDIDO = pIDPedido;
END;



DECLARE
  vIDPedido NUMBER := '&Informe_IDPedido';
BEGIN
  CalculoValorPedido(vIDPedido);
  END;
  
-- ex 1 funcao

CREATE OR REPLACE
FUNCTION BUSCA_DATA_ULTIMO_PEDIDO
(pIDCliente IN NUMBER) RETURN DATE AS vDataUltimoPedido PEDIDO.DATAPEDIDO%type;

BEGIN
  SELECT MAX(ped.DATAPEDIDO)
  INTO vDataUltimoPedido
  FROM Pedido ped
  JOIN Cliente cli
  on ped.IDCLIENTE = cli.IDCliente
  WHERE cli.IDCliente = pIDCliente;
  
  RETURN vDataUltimoPedido;
  
EXCEPTION
  WHEN no_data_found THEN
    Return ('Produto não encontrado!');
END;

SELECT Nome, BUSCA_DATA_ULTIMO_PEDIDO(&IDCliente) as Data_Ultimo_Pedido
FROM Cliente WHERE IDCliente = &IDCliente;

-- ex 2 func

CREATE OR REPLACE
FUNCTION QUANTIDADE_VENDIDA_PERIODO(vIDProduto IN NUMBER, vPeriodo IN VARCHAR2)
RETURN NUMBER AS vQuantidade PEDIDOITEM.QUANTIDADE%TYPE;

BEGIN
SELECT SUM(PI.QUANTIDADE)
INTO vQuantidade
FROM PEDIDOITEM PI
JOIN PEDIDO PED
ON PI.IDPEDIDO = PED.IDPEDIDO
JOIN PRODUTO PROD
ON PI.IDPRODUTO = PROD.IDPRODUTO
WHERE PROD.IDPRODUTO = vIDProduto
AND ped.DATAPEDIDO BETWEEN to_date('1/'|| vPeriodo,'dd/MM/yyyy') AND LAST_DAY(to_date('1/'||vPeriodo,'dd-MM-yyyy'));

RETURN vQuantidade;

END;

SELECT QUANTIDADE_VENDIDA_PERIODO(4520,'03/2015') FROM DUAL;
/*
Fa�a um bloco PL/SQL que receba UM par�metro (em tempo de execu��o apenas): IDCliente
, e ent�o pesquise nome do cliente e cidade (caso tenha), e outras informa��es referente
a pedidos: 
o  Data da primeira compra (pedido) realizado; 
o  Data da �ltima compra realizada. 
o  Valor total dos pedidos, quantidade de pedidos e m�dia de valor dos pedidos. 
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
Fa�a um bloco PL/SQL que receba DOIS par�metros (em tempo de execu��o apenas): nome e uf,
verifique se j� existe um registro em Cidade para a combina��o, caso n�o exista fa�a um INSERT na tabela de Cidade.
o Utilize uma SEQUENCE para gerar o pr�ximo ID v�lido; o Ignore o case sensitive na valida��o.  
o Se j� existir a cidade+uf deve imprimir uma mensagem informando. 
*/

DECLARE
vExisteCidade Integer;
vParamNomeCidade VARCHAR2(100);
vParamUFCidade VARCHAR2(2);

BEGIN
vParamNomeCidade := &NomeCidade;
vParamUFCidade := &UFCidade;

SELECT Count(1) 
INTO vExisteCidade
from Cidade where lower(Nome) = lower(vParamNomeCidade) and lower(UF) = lower(vParamUFCidade);

if (vExisteCidade = 0) then
INSERT INTO Cidade(Nome,UF) Values (vParamNomeCidade, vParamUFCidade);
else
DBMS_OUTPUT.PUT_LINE('A cidade j� existe!');
end if;

end;
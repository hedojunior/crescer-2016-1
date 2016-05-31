--Liste os clientes e suas respectivas cidades. a. IDCliente, Nome, Nome da Cidade e UF. 
SELECT 
  cli.IDCliente, 
    cli.Nome, 
      cid.Nome as Cidade, 
        cid.UF 
          FROM CLIENTE cli 
            JOIN CIDADE cid 
              ON cli.IDCidade = cid.IDCidade;
              
--  Liste o total de pedidos realizados no m�s de maio de 2016. 
SELECT 
  COUNT(1) TotalPedidos052016 
    FROM PEDIDO 
      WHERE to_char(DATAPEDIDO,'MM/YY') = '05/16';

--Liste todos os clientes que tenham o LTDA no nome ou razao social. 
SELECT * 
  FROM CLIENTE 
    WHERE UPPER(NOME) LIKE '%LTDA%' 
      OR 
        UPPER(RAZAOSOCIAL) LIKE '%LTDA';

--Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es: 
--Nome: Galocha Maragato Pre�o de custo: 35.67 Pre�o de venda: 77.95 Situa��o: A  

CREATE SEQUENCE SQPRODUTO START WITH 8001;

INSERT INTO 
  PRODUTO(IDPRODUTO,NOME,PRECOCUSTO,PRECOVENDA,SITUACAO) 
    VALUES 
      (SQPRODUTO.NEXTVAL,'Galocha Maragato',35.67,77.95,'A');

COMMIT;

/*
Identifique e liste os produtos que n�o tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, pois n�o h� 
relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem). 
Obs.: o produto criado anteriormente dever� ser listado (apenas este) 
*/

SELECT prod.* from PRODUTO prod LEFT JOIN PEDIDOITEM ped ON prod.IDPRODUTO = ped.IDPRODUTO WHERE ped.IDPEDIDOITEM is null; 


select * from PEDIDOITEM WHERE IDPRODUTO = 5934;

SELECT * FROM PEDIDOITEM;
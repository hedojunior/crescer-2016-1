--Liste os clientes e suas respectivas cidades. a. IDCliente, Nome, Nome da Cidade e UF. 
SELECT 
  cli.IDCliente, 
    cli.Nome, 
      cid.Nome as Cidade, 
        cid.UF 
          FROM CLIENTE cli 
            JOIN CIDADE cid 
              ON cli.IDCidade = cid.IDCidade;
              
--  Liste o total de pedidos realizados no m?s de maio de 2016. 
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

--Crie (insira) um novo registro na tabela de Produto, com as seguintes informa??es: 
--Nome: Galocha Maragato Pre?o de custo: 35.67 Pre?o de venda: 77.95 Situa??o: A  

CREATE SEQUENCE SQPRODUTO START WITH 8001;

INSERT INTO 
  PRODUTO(IDPRODUTO,NOME,PRECOCUSTO,PRECOVENDA,SITUACAO) 
    VALUES 
      (SQPRODUTO.NEXTVAL,'Galocha Maragato',35.67,77.95,'A');

COMMIT;

/*
Identifique e liste os produtos que n?o tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, pois n?o h? 
relacionamento direto entre Produto e Pedido (ser? preciso relacionar PedidoItem). 
Obs.: o produto criado anteriormente dever? ser listado (apenas este) 
*/
 
SELECT prod.* 
  FROM PRODUTO prod 
    LEFT JOIN 
      PEDIDOITEM ped 
        ON prod.IDPRODUTO = ped.IDPRODUTO 
          WHERE ped.IDPEDIDOITEM is null; 

/*
Liste todos os pedidos de um determinado cliente, considere que sempre 
que for executar esta consulta será informado o IDCliente como parâmetro. 
Deverão ser listados: Data do Pedido, Produto, Quantide, Valor Unitário, e valor total. 
Exemplo: SELECT Nome FROM Cliente WHERE IDCliente = :pIDCliente 
Neste exemplo será solicitado que informe o parâmetro para execução da consulta.  */
 
SELECT P.DATAPEDIDO, PROD.NOME, PI.QUANTIDADE, PROD.PRECOVENDA, P.VALORPEDIDO VALORTOTAL 
  FROM 
    PEDIDO P 
      JOIN 
    Cliente C 
      ON P.IDCLIENTE = C.IDCLIENTE 
      JOIN 
    PedidoItem PI 
      ON P.IDPEDIDO = PI.IDPEDIDO 
      JOIN 
    Produto prod 
      ON PI.IDPRODUTO = prod.IDPRODUTO 
        WHERE C.IDCliente = :pIDCliente;
 
 /* 
 Faça uma consulta que receba um parâmetro sendo o IDProduto 
 e liste a quantidade de itens na tabela PedidoItem com este
 IDProduto foram vendidos no último ano (desde janeiro/2016).
*/
 
SELECT 
  SUM(PI.QUANTIDADE) 
    FROM 
      PEDIDOITEM PI 
        JOIN 
      PRODUTO P 
        ON PI.IDPRODUTO = P.IDPRODUTO 
        JOIN 
      PEDIDO PED 
        ON PED.IDPEDIDO = PI.IDPEDIDO 
          WHERE PED.DATAPEDIDO 
            BETWEEN 
                TO_DATE('01/01/16','dd/MM/yy') 
              AND 
                CURRENT_TIMESTAMP;

/*
 Utilizando de funções de agrupamento (aggregation function), faça uma consulta
 que liste agrupando por ano e mês a quantidade de pedidos comprados, a quantidade
 de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido,
 o maior valor de um pedido e valor médio de um pedido. 
(Dica: a função TO_CHAR permite converter Dates em String considerando formatos específicos). 
*/

SELECT DISTINCT
  COUNT(1),  
    SUM(PI.QUANTIDADE) AS PRODUTOSDISTINTOS,
      SUM(PED.VALORPEDIDO) AS VALORTOTAL, 
        MIN(PED.VALORPEDIDO) AS VALORMINIMO, 
          MAX(PED.VALORPEDIDO) AS VALORMAXIMO, 
            AVG(PED.VALORPEDIDO) AS MEDIA
            FROM PEDIDO PED 
                JOIN 
            PEDIDOITEM PI 
                ON PED.IDPEDIDO = PI.IDPEDIDO 
                JOIN 
            PRODUTO prod 
                ON PI.IDPRODUTO = prod.IDPRODUTO
                  GROUP BY TO_CHAR(PED.DATAPEDIDO,'MM-YY'); 
            
            
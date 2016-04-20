-- Exercícios dia 20/04/2016
--1 - Faça uma consulta que retorne o nome dos empregados exibindo em ordem de admissão.
SELECT NomeEmpregado AS Nome FROM Empregado ORDER BY dataAdmissao ASC;

--2 - Faça uma consulta que retorne o nome dos empregados e o salário anual [...]
SELECT NomeEmpregado AS Nome,
	   (Salario*12)  AS 'Salario Anual'
FROM Empregado
WHERE 
Cargo = 'Atendente'
AND
(Salario*12) < 18500;

-- 3 - Retornar o ID da cidade de Uberlândia
SELECT IDCidade, Nome
FROM Cidade
WHERE
Nome = 'Uberlândia';
SELECT * FROM CIDADE;

-- 4 - Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul
SELECT IDcidade,
	   Nome
FROM Cidade
WHERE
UF = 'RS';

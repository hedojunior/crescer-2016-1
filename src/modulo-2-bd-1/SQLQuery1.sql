-- Exerc�cios dia 20/04/2016
--1 - Fa�a uma consulta que retorne o nome dos empregados exibindo em ordem de admiss�o.
SELECT NomeEmpregado AS Nome FROM Empregado ORDER BY dataAdmissao ASC;

--2 - Fa�a uma consulta que retorne o nome dos empregados e o sal�rio anual [...]
SELECT NomeEmpregado AS Nome,
	   (Salario*12)  AS 'Salario Anual'
FROM Empregado
WHERE 
Cargo = 'Atendente'
AND
(Salario*12) < 18500;

-- 3 - Retornar o ID da cidade de Uberl�ndia
SELECT IDCidade, Nome
FROM Cidade
WHERE
Nome = 'Uberl�ndia';
SELECT * FROM CIDADE;

-- 4 - Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul
SELECT IDcidade,
	   Nome
FROM Cidade
WHERE
UF = 'RS';

-- 1) Selecione o nome do empregado e o departamento que cada um est� relacionado

SELECT e.NomeEmpregado,d.NomeDepartamento,d.IDDepartamento, d.Localizacao
FROM Empregado e
INNER JOIN
Departamento d
ON 
e.IDDepartamento = d.IDDepartamento;
-- 2) Exibir o nome do Associado e sua cidade, exibir tamb�m associados sem cidade relacionada.

Select a.Nome, c.Nome
FROM Associado a
LEFT JOIN
Cidade c
ON a.IDCidade = c.IDCidade;

-- 3) Lista os estados (uf) e total de cidades, exibir apenas as cidades que n�o possuem associados
-- relacionados
SELECT c.UF, count(c.IDCidade) as 'Total Cidades' 
from Cidade c
left join
Associado a on
c.IDCidade = a.IDCidade 
WHERE a.IDCidade IS NULL 
group by UF;

-- 4) Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade
-- � da regi�o sul, se for imprimir ***, se n�o imprimir nulo

SELECT a.Nome, c.Nome,
Case
when c.UF in('RS','SC','PR') then '***'
else null
END 'Pertence_Regi�o_Sul'
FROM Associado a
INNER JOIN
Cidade c
ON a.IDCidade = c.IDCidade;

--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
SELECT e.NomeEmpregado as 'NomeEmpregado',
g.NomeEmpregado as 'NomeGerente',
e.IDDepartamento as 'DeptoEmpregado',
g.IDDepartamento as 'DeptoGerente'
FROM Empregado e
INNER JOIN
Empregado g
ON e.IDGerente = g.IDEmpregado

-- 6) Fa�a uma c�pia da table empregado e altere o sal�rio de todos os empregados (Empregado) que o departa
-- mento fique na localidade de SAO PAULO, fa�a um reajuste de 14,5%;
Select * into EmpregadoAux from Empregado;

UPDATE EmpregadoAux
set salario = salario + (salario * 0.145)
from EmpregadoAux e INNER JOIN Departamento d 
ON e.IDDepartamento = d.IDDepartamento and 
d.Localizacao = 'SAO PAULO';

-- 7) Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio do sal�rio de
-- todos os empregados
SELECT Sum(salario) as 'Total sal�rios',
 Sum(salario * 0.145) as 'Diferen�a',
 (Sum(salario) + Sum(salario*0.145)) as 'Total salarios + diferen�a'
from EmpregadoAux e INNER JOIN Departamento d 
ON e.IDDepartamento = d.IDDepartamento and 
d.Localizacao = 'SAO PAULO';

-- 8)Liste o departamento com o empregado de maior sal�rio
Select d.IDDepartamento, d.NomeDepartamento, d.Localizacao
FROM Departamento d
LEFT JOIN
Empregado e
on d.IDDepartamento = e.IDDepartamento
WHERE
e.salario = (Select max(salario) from Empregado);

-- 9) Fa�a uma consulta para exibir o nome de cada associado e sua cidade juntamente com os empregados
-- (nome) e a cidade(localidade) do seu departamento, isto deve ser exibido em uma consulta.
SELECT a.Nome as 'NomeAssociado', c.Nome as 'NomeCidade' 
from Associado a
INNER JOIN 
Cidade c
on a.IDCidade = c.IDCidade
UNION 
SELECT e.NomeEmpregado as 'NomeEmpregado', d.Localizacao as 'LocalidadeDepto'
FROM Empregado e
INNER JOIN
Departamento d
on e.IDDepartamento = d.IDDepartamento

--10) Lista as cidades que tenham associado relacionados. Exibir: Nome e UF apenas.
SELECT c.Nome, c.UF
from Cidade c
inner join
Associado a
on c.IDCidade = a.IDCidade;

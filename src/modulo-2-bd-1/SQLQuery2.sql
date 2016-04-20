-- 1 Faça uma consulta(query) que retorne apenas o primeiro nome do Associado (tabela associado)
Select Left(Nome,Charindex(' ',Nome)) as 'Primeiro Nome' From Associado;

-- 2 Faça uma consulta que retorne o nome dos associados e a idade de cada um (em anos)
Select Nome, Datediff(Year,DataNascimento,getdate()) as Idade From Associado;

-- 3 Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. Exibir também o total
-- de meses de trabalho até a data de 31/12/2000
Select NomeEmpregado as Nome,
Datediff(Month,DataAdmissao,Convert(datetime,'31/12/2000',103)) as 'Meses de trabalho'
From Empregado
Where
DataAdmissao between Convert(datetime,'01/05/1980',103) and Convert(datetime,'20/01/1982',103);

--4 Qual o cargo (tabela empregado) que possui mais empregados?
Select Top(1) Cargo From Empregado Group By Cargo Order By count(IDEmpregado) desc;

--6 Faça uma consulta que retorne o nome do associado e a data de quando cada completará (ou completou) 
-- 50 anos, liste também o dia da semana.
Select Nome,
	   Datename(weekday,Dateadd(Year,50,DataNascimento)) as 'Dia dos 50 anos'
From Associado;

--7 Liste a quantidade de cidades agrupando por UF - quantas cidades cada estado possui?
Select Count(IDCidade) as 'Quantidade de Cidades',
UF as 'Estado'
 From Cidade Group by UF;

--8 Liste as cidades que possuem o mesmo nome e UF
Select Nome From Cidade Group by Nome
Having Count(Nome) > 1 ;
 
--9 Identifique qual deve ser o próximo ID para a criação de um novo registro na table associado (maior + 1)
SELECT MAX(IDAssociado)
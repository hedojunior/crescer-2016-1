-- 1 Faça uma consulta(query) que retorne apenas o primeiro nome do Associado (tabela associado)
Select Left(Nome,Charindex(' ',Nome)) as 'Primeiro Nome' From Associado;
/* Correção:
SELECT IDAssociado,
	   Nome,
	   SUBSTRING(Nome,1, CHARINDEX(' ', Nome)) primeiro_nome
FROM Associado
*/

-- 2 Faça uma consulta que retorne o nome dos associados e a idade de cada um (em anos)
Select Nome, Datediff(Year,DataNascimento,getdate()) as Idade From Associado;
/* Correção
SELECT IDAssociado,
	   Nome,
	   DataNascimento,
	   DATEDIFF(YEAR, DataNascimento, getdate()) Idade
FROM Associado
*/

-- 3 Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. Exibir também o total
-- de meses de trabalho até a data de 31/12/2000
Select NomeEmpregado as Nome,
Datediff(Month,DataAdmissao,Convert(datetime,'31/12/2000',103)) as 'Meses de trabalho'
From Empregado
Where
DataAdmissao between Convert(datetime,'01/05/1980',103) and Convert(datetime,'20/01/1982',103);

--4 Qual o cargo (tabela empregado) que possui mais empregados?
Select Top(1) with ties Cargo From Empregado Group By Cargo Order By count(IDEmpregado) desc;

--6 Faça uma consulta que retorne o nome do associado e a data de quando cada completará (ou completou) 
-- 50 anos, liste também o dia da semana.
Select Nome,
	   Dateadd(Year,50,DataNascimento) as 'Dia dos 50 anos',
	   Datename(weekday,Dateadd(Year,50,DataNascimento)) as 'Dia da Semana'
From Associado;

--7 Liste a quantidade de cidades agrupando por UF - quantas cidades cada estado possui?
Select Count(IDCidade) as 'Quantidade de Cidades', 
UF as 'Estado'
 From Cidade Group by UF;

--8 Liste as cidades que possuem o mesmo nome e UF
Select Nome from Cidade group by  Nome
Having count(Nome) > 1 ;

--9 Identifique qual deve ser o próximo ID para a criação de um novo registro na table associado (maior + 1)
Select top(1) max(IDAssociado) + 1 as 'Próximo ID de Associado' from Associado;

--10 Limpe a tabela CidadeAux, e insira somente as cidades com nome e UF's distintos, considere somente o menor
-- código ID das cidades duplicadas
Truncate table CidadeAux;
Insert into CidadeAux (IDCidade, Nome, UF) Select min(IDCidade), Nome, UF from cidade group by Nome, UF; 
/* Correção
	Insert into CidadeAux(IDCidade, Nome, UF)
	SELECT MIN(IDCidade) as MenorIDCidade,
	Nome,
	UF
FROM Cidade
GROUP BY Nome, UF
*/
-- 11 Altere todas as cidades duplicadas (nome e uf iguais), acrescente no início do nome um asterisco
Update Cidade
	set Nome = '*' + Nome
	where Nome in
	(Select Nome from Cidade group by Nome having count(Nome) > 1)

-- 12 Faça uma consulta que liste o nome do associado e a descrição da coluna sexo, informando:
-- Masculino ou feminino
Select Nome, 
case when
	 sexo = 'F' then 'Feminino'
	 when
	 sexo = 'M' then 'Masculino' 
	 end Sexo 
from Associado;

-- 13 Faça uma consulta que mostre o nome do empregado, o Salario e o percentual a ser descontado do 
-- imposto de renda, considerando a table abaixo:
-- Até R$ 1.164,00 = 0%
-- De R$ 1.164,00 até R$2.326,00 = 15%
-- Acima de R$ 2.326,00 = 27,5%;

Select NomeEmpregado as Nome,
	   Salario,
	   case 
	   when Salario < 1164 then '0%'
	   when Salario between 1164 and 2326 then '15%'
	   when Salario > 2326 then '27,5%'
	   end 'Percentual descontado'
from Empregado;

-- 14 Elimine as cidades duplicadas mantendo um registro pra cada - com menor IDCidade
Delete from Cidade
where		 
IDCidade IN 
(select max(IDCidade) from Cidade group by Nome having count(Nome) > 1);

-- 15 Adicione uma regra que impeça que exista mais de uma cidade com o mesmo nome no mesmo estado
Alter table Cidade
add 
constraint UK_Cidade unique (Nome, UF);

Select * from Cidade;
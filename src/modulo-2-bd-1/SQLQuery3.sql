INSERT INTO Associado(IDAssociado,Nome,DataNascimento,CPF,Sexo)
	VALUES
	(1,'Julio de Castilhos',convert(datetime,'14/12/1947',103),21234567895,'M'),
	(2,'Antonio Augusto Borges de Medeiros',convert(datetime,'19/03/1942',103),81234567891,'M'),
	(3,'Osvaldo Aranha',convert(datetime,'08/02/1958',103),01234567893,'M');

SELECT * INTO CidadeAux FROM Cidade;


TRUNCATE TABLE CidadeAux;


INSERT INTO CidadeAux SELECT * FROM Cidade;

CREATE TABLE Produto
(	IDProduto		INT			 NOT NULL,
	NomeCurto		VARCHAR(20)  NOT NULL,
	NomeDescritivo  VARCHAR(150) NOT NULL,
	DataDeCriacao   DATETIME     NOT NULL,
	LocalNoEstoque  VARCHAR(255) NOT NULL,
	Quantidade      INT          NOT NULL,
	Preço			SMALLMONEY   NOT NULL,
	CONSTRAINT PK_Produto PRIMARY KEY (IDProduto)
 );

INSERT INTO Produto(IDProduto,NomeCurto,NomeDescritivo,DataDeCriacao,LocalNoEstoque,Quantidade,Preço)
	VALUES
(1,'Maçã Verde','Maçã Verde GrünAppel',convert(datetime,'19/04/2016',103),'HortiFruti',200,0.60),
(2,'Maçã Vermelha','Maçã Vermelha RougePomme',convert(datetime,'19/04/2016',103),'HortiFruti',400,0.40);

SELECT * FROM Produto;

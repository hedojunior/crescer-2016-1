CREATE TABLE Permissao
   (
    PermissaoId int IDENTITY NOT NULL PRIMARY KEY,
    Permissao varchar(50) NOT NULL,
    CONSTRAINT CHK_Permissao CHECK (Permissao = 'COMUM' OR Permissao = 'ADMIN')
   );

CREATE TABLE Usuario
   (
    UsuarioId int IDENTITY NOT NULL PRIMARY KEY,
    Nome varchar(255) NOT NULL,
    Email varchar(255) UNIQUE NOT NULL,
    Senha varchar(255) NOT NULL
   );

CREATE TABLE UsuarioPermissao
   (
    UsuarioPermissaoId int IDENTITY NOT NULL PRIMARY KEY,
    UsuarioId int,
    PermissaoId int,
    CONSTRAINT FK_UsuarioId FOREIGN KEY (UsuarioId) REFERENCES Usuario(UsuarioId),
    CONSTRAINT FK_PermissaoId FOREIGN KEY (PermissaoId) REFERENCES Permissao(PermissaoId)
   );

   INSERT INTO
		Usuario(Nome,Email,Senha)
   VALUES	
		('Hedo','hedojunior@gmail.com','992a6259a63370bb98014aef8f9cefc0'), --hedo
		('admin','admin@admin.com','21232f297a57a5a743894a0e4a801fc3'), --admin
		('dave','dave@grohl.com','e8b5d682452313a6142c10b045a9a135') --foofighters

   INSERT INTO
		Permissao(Permissao)
   VALUES
		('COMUM'),
		('ADMIN')	

  INSERT INTO
		UsuarioPermissao(UsuarioId,PermissaoId)
  VALUES
		(1,1),
		(1,2),
		(2,1),
		(2,2),
		(3,1),
		(3,2)

		
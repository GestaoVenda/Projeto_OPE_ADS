USE ope;

CREATE TABLE Cliente (
  idCliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dtCriacao DATETIME DEFAULT CURRENT_TIMESTAMP(),
  inativo BIT NOT NULL DEFAULT 0,
  PRIMARY KEY(idCliente)
);

CREATE TABLE Contato (
  IdContato INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCliente INTEGER UNSIGNED NOT NULL,
  telefone VARCHAR(12) NULL,
  celular VARCHAR(13) NULL,
  email VARCHAR(50) NULL,
  decricao VARCHAR(100) NULL,
  PRIMARY KEY(IdContato),
  FOREIGN KEY(idCliente)
    REFERENCES Cliente(idCliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE Endereco (
  IdEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCliente INTEGER UNSIGNED NOT NULL,
  logradouro VARCHAR(100) NULL,
  numero INTEGER NULL,
  bairro VARCHAR(100) NULL,
  cidade VARCHAR(100) NULL,
  estado VARCHAR(100) NULL,
  cep VARCHAR(8) NULL,
  complemento VARCHAR(100) NULL,
  tipo VARCHAR(100) NULL,
  principal BIT NULL DEFAULT 0,
  PRIMARY KEY(IdEndereco),
  FOREIGN KEY(idCliente)
    REFERENCES Cliente(idCliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE ClientePF (
  idCliente INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  PRIMARY KEY(idCliente),
  FOREIGN KEY(idCliente)
    REFERENCES Cliente(idCliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE ClientePJ (
  idCliente INTEGER UNSIGNED NOT NULL,
  razao VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  insc VARCHAR(14) NOT NULL,
  PRIMARY KEY(idCliente),
  FOREIGN KEY(idCliente)
    REFERENCES Cliente(idCliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

INSERT cliente VALUES ();
INSERT clientepj VALUES (1,'Cliente Teste','22549365000102','952812013738');
INSERT contato (idCliente, telefone, celular, email, decricao) VALUES (1,'1139564532','11999999999','teste@teste.com','Teste');
INSERT endereco (idCliente, logradouro, numero, bairro, cidade, estado, cep, complemento, tipo, principal)
    VALUES (1,'Rua Manuel do Teste',333,'Boa Vista','São Paulo','SP','09956020','','Casa',1);
	
USE ope;

CREATE TABLE cliente (
  id_cliente BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP(),
  inativo BIT NOT NULL DEFAULT 0,
  PRIMARY KEY(id_cliente)
);

CREATE TABLE contato (
  id_contato BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_cliente BIGINT UNSIGNED NOT NULL,
  telefone VARCHAR(12) NULL,
  celular VARCHAR(13) NULL,
  email VARCHAR(50) NULL,
  descricao VARCHAR(100) NULL,
  PRIMARY KEY(id_contato),
  FOREIGN KEY(id_cliente)
    REFERENCES cliente(id_cliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE endereco (
  id_endereco BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_cliente BIGINT UNSIGNED NOT NULL,
  logradouro VARCHAR(100) NULL,
  numero INTEGER NULL,
  bairro VARCHAR(100) NULL,
  cidade VARCHAR(100) NULL,
  estado VARCHAR(100) NULL,
  cep VARCHAR(8) NULL,
  complemento VARCHAR(100) NULL,
  tipo VARCHAR(100) NULL,
  principal BIT NULL DEFAULT 0,
  PRIMARY KEY(id_endereco),
  FOREIGN KEY(id_cliente)
    REFERENCES cliente(id_cliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE cliente_pf (
  id_cliente BIGINT UNSIGNED NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  PRIMARY KEY(id_cliente),
  FOREIGN KEY(id_cliente)
    REFERENCES cliente(id_cliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE cliente_pj (
  id_cliente BIGINT UNSIGNED NOT NULL,
  razao VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  insc VARCHAR(14) NOT NULL,
  PRIMARY KEY(id_cliente),
  FOREIGN KEY(id_cliente)
    REFERENCES cliente(id_cliente)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

INSERT cliente VALUES ();
INSERT cliente_pj VALUES (1,'Cliente Teste','22549365000102','952812013738');
INSERT contato (id_cliente, telefone, celular, email, descricao) VALUES (1,'1139564532','11999999999','teste@teste.com','Teste');
INSERT endereco (id_cliente, logradouro, numero, bairro, cidade, estado, cep, complemento, tipo, principal)
    VALUES (1,'Rua Manuel do Teste',333,'Boa Vista','São Paulo','SP','09956020','','Casa',1);

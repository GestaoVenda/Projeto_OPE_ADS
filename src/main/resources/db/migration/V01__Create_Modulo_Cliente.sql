USE ope;

CREATE TABLE cliente (
  id_cliente BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  dt_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  inativo BIT DEFAULT 0,
  nome VARCHAR(100) NULL,
  cpf VARCHAR(11) NULL,
  razao VARCHAR(100) NULL,
  cnpj VARCHAR(14) NULL,
  insc VARCHAR(14) NULL,
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
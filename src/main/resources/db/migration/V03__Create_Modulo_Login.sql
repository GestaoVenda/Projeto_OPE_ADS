USE ope;

DROP TABLE perfil_tela_permissao;
DROP TABLE perfil_tela;
DROP TABLE usuario_perfil;
DROP TABLE perfil;
DROP TABLE usuario;
DROP TABLE tela;
DROP TABLE permissao;

CREATE TABLE usuario (
  id_usuario BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL ,
  banco VARCHAR(50) NOT NULL ,
  conta VARCHAR(10) NOT NULL ,
  agencia VARCHAR(10) NOT NULL ,
  login VARCHAR(50) UNIQUE NOT NULL ,
  senha VARCHAR(50) NOT NULL ,
  dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP(),
  email VARCHAR(60) NULL UNIQUE ,
  PRIMARY KEY(id_usuario)
);

CREATE TABLE endereco_usuario (
  id_usuario BIGINT UNSIGNED NOT NULL,
  logradouro VARCHAR(100) NULL,
  numero INTEGER NULL,
  bairro VARCHAR(100) NULL,
  cidade VARCHAR(100) NULL,
  estado VARCHAR(100) NULL,
  cep VARCHAR(8) NULL,
  complemento VARCHAR(100) NULL,
  tipo VARCHAR(100) NULL,
  principal BIT NULL DEFAULT 0,
  PRIMARY KEY(id_usuario),
  FOREIGN KEY(id_usuario)
    REFERENCES usuario(id_usuario)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);
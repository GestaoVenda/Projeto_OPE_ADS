USE ope;

DROP TABLE perfil_tela_permissao;
DROP TABLE perfil_tela;
DROP TABLE usuario_perfil;
DROP TABLE perfil;
DROP TABLE usuario;
DROP TABLE tela;
DROP TABLE permissao;


CREATE TABLE user (
  id_user BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name_user VARCHAR(50) NOT NULL ,
  bank VARCHAR(50) NOT NULL ,
  account VARCHAR(10) NOT NULL ,
  agency VARCHAR(10) NOT NULL ,
  login VARCHAR(50) UNIQUE NOT NULL ,
  password VARCHAR(50) NOT NULL ,
  dt_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  email VARCHAR(60) NULL UNIQUE ,
  PRIMARY KEY(id_user)
);

CREATE TABLE user_address (
  id_address BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user BIGINT UNSIGNED NOT NULL,
  street VARCHAR(100) NULL,
  number INTEGER NULL,
  neighborhood VARCHAR(100) NULL,
  city VARCHAR(100) NULL,
  district VARCHAR(100) NULL,
  zipcode VARCHAR(8) NULL,
  complement VARCHAR(100) NULL,
  `type` VARCHAR(100) NULL,
  main BOOLEAN DEFAULT FALSE,
  PRIMARY KEY(id_address),
  FOREIGN KEY(id_user)
    REFERENCES user(id_user)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);
CREATE TABLE permissao (
  id_permissao BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(50) NOT NULL UNIQUE ,
  PRIMARY KEY(id_permissao)
);

CREATE TABLE tela (
  id_tela BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL UNIQUE ,
  PRIMARY KEY(id_tela)
);

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

CREATE TABLE perfil (
  id_perfil BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(50) NULL UNIQUE ,
  PRIMARY KEY(id_perfil)
);

CREATE TABLE usuario_perfil (
  id_usuario BIGINT UNSIGNED NOT NULL,
  id_perfil BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY(id_usuario, id_perfil),
  FOREIGN KEY(id_usuario)
    REFERENCES usuario(id_usuario)
      ON DELETE CASCADE 
      ON UPDATE CASCADE,
  FOREIGN KEY(id_perfil)
    REFERENCES perfil(id_perfil)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

CREATE TABLE perfil_tela (
  id_perfil BIGINT UNSIGNED NOT NULL,
  id_tela BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY(id_perfil, id_tela),
  FOREIGN KEY(id_perfil)
    REFERENCES perfil(id_perfil)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(id_tela)
    REFERENCES tela(id_tela)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

CREATE TABLE perfil_tela_permissao (
  id_tela BIGINT UNSIGNED NOT NULL,
  id_perfil BIGINT UNSIGNED NOT NULL,
  id_permissao BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY(id_tela, id_perfil, id_permissao),
  FOREIGN KEY(id_perfil, id_tela)
    REFERENCES perfil_tela(id_perfil, id_tela)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(id_permissao)
    REFERENCES permissao(id_permissao)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);
# POPULAR DADOS permissao
INSERT INTO permissao(tipo) VALUES('CREATE');
INSERT INTO permissao(tipo) VALUES('READ');
INSERT INTO permissao(tipo) VALUES('UPDATE');
INSERT INTO permissao(tipo) VALUES('DELETE');
INSERT INTO permissao(tipo) VALUES('DENIED');


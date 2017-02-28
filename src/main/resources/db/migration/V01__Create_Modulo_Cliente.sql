USE ope;

CREATE TABLE client (
  id_client BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  dt_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  inactive BOOLEAN DEFAULT FALSE,
  name_client VARCHAR(100) NULL,
  cpf VARCHAR(11) NULL,
  razao VARCHAR(100) NULL,
  cnpj VARCHAR(14) NULL,
  insc VARCHAR(14) NULL,
  PRIMARY KEY(id_client)
);
 

CREATE TABLE contact (
  id_contact BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_client BIGINT UNSIGNED NOT NULL,
  phone VARCHAR(12) NULL,
  cellphone VARCHAR(13) NULL,
  email VARCHAR(50) NULL,
  description VARCHAR(100) NULL,
  PRIMARY KEY(id_contact),
  FOREIGN KEY(id_client)
    REFERENCES client(id_client)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE address (
  id_address BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_client BIGINT UNSIGNED NOT NULL,
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
  FOREIGN KEY(id_client)
    REFERENCES client(id_client)
     ON DELETE CASCADE
 );
USE ope;

ALTER TABLE Cliente MODIFY idCliente BIGINT UNSIGNED NOT NULL AUTO_INCREMENT;
ALTER TABLE Contato CHANGE IdContato idContato BIGINT UNSIGNED NOT NULL AUTO_INCREMENT;
ALTER TABLE Contato MODIFY idCliente BIGINT UNSIGNED NOT NULL;
ALTER TABLE Endereco CHANGE IdEndereco idEndereco BIGINT UNSIGNED NOT NULL AUTO_INCREMENT;
ALTER TABLE Endereco MODIFY idCliente BIGINT UNSIGNED NOT NULL;
ALTER TABLE ClientePF MODIFY idCliente BIGINT UNSIGNED NOT NULL;
ALTER TABLE ClientePJ MODIFY idCliente BIGINT UNSIGNED NOT NULL;
ALTER TABLE Usuario MODIFY idUsuario BIGINT UNSIGNED NOT NULL AUTO_INCREMENT;
ALTER TABLE EnderecoUsuario MODIFY idUsuario BIGINT UNSIGNED NOT NULL;


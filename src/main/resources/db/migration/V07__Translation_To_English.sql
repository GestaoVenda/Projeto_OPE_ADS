use ope;

############################################################################################
# RENAME CLIENTE TO CLIENT
############################################################################################
RENAME TABLE `cliente` TO `client`;
ALTER TABLE client
change id_cliente `id_client` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
change dt_criacao `dt_creation` TIMESTAMP DEFAULT CURRENT_TIMESTAMP (),
change inativo `inactive` BIT DEFAULT 0,
change nome `name_client` VARCHAR(100) NULL,
change cpf `cpf` VARCHAR(11) NULL,
change razao `razao` VARCHAR(100) NULL,
change cnpj `cnpj` VARCHAR(14) NULL,
change insc `insc` VARCHAR(14) NULL;
############################################################################################
# RENAME ENDEREÇO TO ADDRESS
############################################################################################
RENAME TABLE `endereco` TO `address`;
ALTER TABLE `address`
change id_endereco `id_address` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
change id_cliente `id_client` BIGINT UNSIGNED NOT NULL,
change logradouro `street` VARCHAR(100) NULL,
change numero `number` INTEGER NULL,
change bairro `neighborhood` VARCHAR(100) NULL,
change cidade `city` VARCHAR(100) NULL,
change estado `district` VARCHAR(100) NULL,
change cep `zipcode` VARCHAR(8) NULL,
change complemento `complement` VARCHAR(100) NULL,
change tipo `type` VARCHAR(100) NULL,
change principal `main` BIT NULL DEFAULT 0;
############################################################################################
# RENAME USUARIO TO USER
############################################################################################
RENAME TABLE `usuario` TO `user`;
ALTER TABLE `user`
change id_usuario `id_user` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
change nome `name_user` VARCHAR(50) NOT NULL ,
change banco `bank` VARCHAR(50) NOT NULL ,
change conta `account` VARCHAR(10) NOT NULL ,
change agencia `agency` VARCHAR(10) NOT NULL ,
change senha `password` VARCHAR(50) NOT NULL ,
change dt_criacao `dt_creation` TIMESTAMP DEFAULT CURRENT_TIMESTAMP();
############################################################################################
# RENAME ENDERECO_USUARIO TO USER_ADDRESS
############################################################################################
RENAME TABLE `endereco_usuario` TO `user_address`;
ALTER TABLE `user_address`
change id_endereco `id_address` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
change id_usuario `id_user` BIGINT UNSIGNED NOT NULL,
change logradouro `street` VARCHAR(100) NULL,
change numero `number` INTEGER NULL,
change bairro `neighborhood` VARCHAR(100) NULL,
change cidade `city` VARCHAR(100) NULL,
change estado `district` VARCHAR(100) NULL,
change cep `zipcode` VARCHAR(8) NULL,
change complemento `complement` VARCHAR(100) NULL,
change tipo `type` VARCHAR(100) NULL,
change principal `main` BIT NULL DEFAULT 0;
############################################################################################
# RENAME CATEGORIA TO CATEGORY
############################################################################################
RENAME TABLE `categoria` TO `category`;
ALTER TABLE `category`
change id_categoria `id_category` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
change nome_categoria `name_category` varchar(100) NOT NULL,
change ativo active BIT NOT NULL DEFAULT 1;
############################################################################################
# RENAME MEDIDA TO MEASURE
############################################################################################
RENAME TABLE `medida` TO `measure`;
ALTER TABLE `measure`
change id_medida `id_measure` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
change nome_medida `name_measure` varchar(100) NOT NULL;
############################################################################################
# RENAME PRODUTO TO PRODUCT
############################################################################################
RENAME TABLE `produto` TO `product`;
ALTER TABLE `product`
change id_produto `id_product` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
change nome `name_product` varchar(100),
change descricao `description` varchar(200),
change id_categoria `id_category` BIGINT UNSIGNED NOT NULL,
change id_medida `id_measure` BIGINT UNSIGNED NOT NULL,
change preco_custo `cost_price` Double(10,2) DEFAULT 0,
change preco_venda `sale_price` Double(10,2),
change estoque `stock` INT UNSIGNED NOT NULL DEFAULT 0,
change estoque_min `min_stock` INT UNSIGNED NOT NULL DEFAULT 0,
change estoque_max `max_stock` INT UNSIGNED NULL,
change permite_fracionamento `allows_fractionation` BIT NOT NULL DEFAULT 0,
change item_fracionado `fractionated_item` BIT NOT NULL DEFAULT 0,
change validade `validity` datetime NULL,
change ativo `active` BIT NOT NULL DEFAULT 1;
############################################################################################
# RENAME ITEM_FRACAO TO FRACTIONATED_ITEM
############################################################################################
RENAME TABLE `item_fracao` TO `fractionated_item`;
ALTER TABLE `fractionated_item`
change id_produto `id_product` BIGINT UNSIGNED NOT NULL,
change id_produto_unidade `id_unit_product` BIGINT UNSIGNED NOT NULL;
USE ope;
INSERT INTO `ope`.`client` (`dt_creation`, `inactive`, `name_client`, `cpf`) 
VALUES ('2017-02-25',0, 'Bruno Rafael Campos', '02963611277');

INSERT INTO `ope`.`contact` (`id_client`, `name_contact`) 
VALUES ('1', 'Bruno Rafael Campos');

INSERT INTO `ope`.`phone_contact` (`id_contact`, `ddi`, `ddd`, `phone`) 
VALUES ('1', '55', '61', '26710871');

INSERT INTO `ope`.`cellphone_contact` (`id_contact`, `ddi`, `ddd`, `cellphone`) 
VALUES ('1', '55', '61', '982854011');

INSERT INTO `ope`.`email_contact` (`id_contact`, `email`) 
VALUES ('1', 'bruno.rafael.campos@lifefp.com.br');

INSERT INTO `ope`.`address` (`id_client`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('1', 'Quadra Quadra 17 Conjunto B', '820', 'Paranoá', 'Brasília', 'DF', '71571702', 'casa', 1);

###########################################################################################################################
INSERT INTO `ope`.`user` (`name_user`, `bank`, `account`, `agency`, `login`, `password`, `dt_creation` ,`email`) 
VALUES ('Rodrigo Felipe Gomes', 'Bradesco', '19182959', '0069', 'rodrigo.gomes', '123456', '2017-02-26' ,'rodrigo.gomes@wasan.com');

INSERT INTO `ope`.`user_address` (`id_user`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('1', 'Travessa Margarida Maria Silva Dantas', '936', 'Jabotiana', 'Aracaju', 'SE', '49095640', 'casa', 1);
###################################################################################################################################################
###################################################################################################################################################

INSERT INTO `ope`.`client` (`dt_creation`, `inactive`, `name_client`, `cpf`) 
VALUES ('2017-02-25',0, 'Henry Leonardo Cauê Freitas', '49543058296');

INSERT INTO `ope`.`contact` (`id_client`, `name_contact`) 
VALUES ('2', 'Henry Leonardo Cauê Freitas');

INSERT INTO `ope`.`phone_contact` (`id_contact`, `ddi`, `ddd`, `phone`) 
VALUES ('2', '55', '67', '25697552');

INSERT INTO `ope`.`cellphone_contact` (`id_contact`, `ddi`, `ddd`, `cellphone`) 
VALUES ('2', '55', '67', '983937583');

INSERT INTO `ope`.`email_contact` (`id_contact`, `email`) 
VALUES ('2', 'henry_l_freitas@ig.com.br');

INSERT INTO `ope`.`address` (`id_client`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('2', 'Rua Três Irmãos', '800', 'Loteamento Cristo Redentor', 'Campo Grande', 'MS', '79042764', 'casa', 1);

###########################################################################################################################
INSERT INTO `ope`.`user` (`name_user`, `bank`, `account`, `agency`, `login`, `password`, `dt_creation` ,`email`) 
VALUES ('Francisco Breno Cardoso', 'Bradesco', '10091063', '1897', 'francisco.cardoso', 'fkh3451', '2017-02-26' ,'francisco.cardoso@wasan.com');

INSERT INTO `ope`.`user_address` (`id_user`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('2', 'Avenida Duque de Caxias', '386', 'Primavera', 'Teresina', 'PI', '64002600', 'casa', 1);

###################################################################################################################################################
###################################################################################################################################################

INSERT INTO `ope`.`client` (`dt_creation`, `inactive`,`name_client`, `razao`, `cnpj`, `insc`) 
VALUES ('2017-02-25',0, 'Sara e Raquel Alimentos Ltda', 'MAX - Alimentos Ltda', '33703917000101', '935273181811');

INSERT INTO `ope`.`contact` (`id_client`, `name_contact`) 
VALUES ('3', 'Sara Santos');

INSERT INTO `ope`.`phone_contact` (`id_contact`, `ddi`, `ddd`, `phone`) 
VALUES ('3', '55', '11', '37235177');

INSERT INTO `ope`.`cellphone_contact` (`id_contact`, `ddi`, `ddd`, `cellphone`) 
VALUES ('3', '55', '11', '983967845');

INSERT INTO `ope`.`email_contact` (`id_contact`, `email`) 
VALUES ('3', 'sara_santos@gmail.com');

INSERT INTO `ope`.`address` (`id_client`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('3', 'Rua João Evangelista Fraga', '748', 'Jardim Santa Helena', 'São Paulo', 'SP', '04787060', 'casa', 1);

###########################################################################################################################
INSERT INTO `ope`.`user` (`name_user`, `bank`, `account`, `agency`, `login`, `password`, `dt_creation` ,`email`) 
VALUES ('Ryan Cauã Murilo Martins', 'Bradesco', '08070547', '2948', 'ryan.martins', '55rdfs', '2017-02-26' ,'ryan.martins@wasan.com');

INSERT INTO `ope`.`user_address` (`id_user`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('3', 'Rua Olívio Guelfi', '388', 'Jardim Jaú', 'São Paulo', 'SP', '03710050', 'casa', 1);

###################################################################################################################################################
###################################################################################################################################################

INSERT INTO `ope`.`client` (`dt_creation`, `inactive`,`name_client`, `razao`, `cnpj`, `insc`) 
VALUES ('2017-02-25',0, 'Betina e Breno Restaurante ME', 'ME Restaurante', '16063110000132', '538543414774');

INSERT INTO `ope`.`contact` (`id_client`, `name_contact`) 
VALUES ('4', 'Hugo Gabriel');

INSERT INTO `ope`.`phone_contact` (`id_contact`, `ddi`, `ddd`, `phone`) 
VALUES ('4', '55', '11', '25680609');

INSERT INTO `ope`.`cellphone_contact` (`id_contact`, `ddi`, `ddd`, `cellphone`) 
VALUES ('4', '55', '11', '995636415');

INSERT INTO `ope`.`email_contact` (`id_contact`, `email`) 
VALUES ('4', 'hugo_gabriel@gmail.com');

INSERT INTO `ope`.`address` (`id_client`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('4', 'Praça Braúna', '179', 'Cidade Mãe do Céu', 'São Paulo', 'SP', '03306100', 'casa', 1);

###########################################################################################################################
INSERT INTO `ope`.`user` (`name_user`, `bank`, `account`, `agency`, `login`, `password`, `dt_creation` ,`email`) 
VALUES ('Paulo Eduardo Vinicius Rocha', 'Bradesco', '07627580', '6304', 'paulo.rocha', 'erfs7665', '2017-02-26' ,'paulo.rocha@wasan.com');

INSERT INTO `ope`.`user_address` (`id_user`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`, `type`,`main`) 
VALUES ('4', 'Rua Olívio Guelfi', '388', 'Jardim Jaú', 'São Paulo', 'SP', '03710050', 'casa', 1);


############################################################################################
# INSERT CATEGORY
############################################################################################
insert into category (name_category) values  ('Higiene');
insert into category (name_category) values  ('Limpeza');
insert into category (name_category) values  ('Descartavel');

############################################################################################
# INSERT MEASURE
############################################################################################
insert into measure (name_measure) value ('Unidade');
insert into measure (name_measure) value ('Caixa');
insert into measure (name_measure) value ('Pacote');

############################################################################################
# INSERT PRODUCT
############################################################################################
insert into product (name_product, description, id_category, id_measure,
 cost_price, sale_price, stock, min_stock, max_stock, allows_fractionation,
 fractionated_item, validity, active) values ('Detergente', 'XXX', 2, 1,
 3.00, 6.00, 50, 0, null, 0, 0, null, 1);
 
 insert into product (name_product, description, id_category, id_measure,
 cost_price, sale_price, stock, min_stock, max_stock, allows_fractionation,
 fractionated_item, validity, active) values ('Caixa 6 un Detergente', 'XXX', 2, 2,
 3.00, 6.00, 50, 0, null, 1, 0, null, 1);
 
 insert into product (name_product, description, id_category, id_measure,
 cost_price, sale_price, stock, min_stock, max_stock, allows_fractionation,
 fractionated_item, validity, active) values ('Caixa 6 un Detergente - FRACAO', 'XXX', 2, 1,
 3.00, 6.00, 50, 0, null, 1, 1, null, 1);

############################################################################################
# INSERT FRACTIONATED_ITEM
############################################################################################
insert into fractionated_item (id_product, id_unit_product) values (2,3);
USE ope;
##########################################################################################################################################################
# TYPE_PERSON
##########################################################################################################################################################

INSERT INTO `ope`.`type_person` (`name`) VALUES ('cliente_pf');
INSERT INTO `ope`.`type_person` (`name`) VALUES ('cliente_pj');
INSERT INTO `ope`.`type_person` (`name`) VALUES ('gerente');
INSERT INTO `ope`.`type_person` (`name`) VALUES ('vendedor');

##########################################################################################################################################################
# TYPE_ADDRESS
##########################################################################################################################################################

INSERT INTO `ope`.`type_address` (`name`) VALUES ('comercial');
INSERT INTO `ope`.`type_address` (`name`) VALUES ('residencial');

##########################################################################################################################################################
# TYPE_DOCUMENT
##########################################################################################################################################################

INSERT INTO `ope`.`type_document` (`name`) VALUES ('rg');
INSERT INTO `ope`.`type_document` (`name`) VALUES ('cpf');
INSERT INTO `ope`.`type_document` (`name`) VALUES ('cnpj');
INSERT INTO `ope`.`type_document` (`name`) VALUES ('insc_estadual');
INSERT INTO `ope`.`type_document` (`name`) VALUES ('insc_municipal');

##########################################################################################################################################################
# MENUS
##########################################################################################################################################################

INSERT INTO `ope`.`main_menu` (`name`) VALUES ('Cliente');
INSERT INTO `ope`.`main_menu` (`name`) VALUES ('Pedido');

INSERT INTO `ope`.`sub_menu` (`fk_id_main_menu`, `name`, `state`) VALUES ('1', 'Cadastrar','main.customer.create');
INSERT INTO `ope`.`sub_menu` (`fk_id_main_menu`, `name`, `state`) VALUES ('1', 'Alterar','main.customer.edit');
INSERT INTO `ope`.`sub_menu` (`fk_id_main_menu`, `name`, `state`) VALUES ('1', 'Excluir','main.customer.delete');

INSERT INTO `ope`.`sub_menu` (`fk_id_main_menu`, `name`, `state`) VALUES ('2', 'Cadastrar','main.customer.create');
INSERT INTO `ope`.`sub_menu` (`fk_id_main_menu`, `name`, `state`) VALUES ('2', 'Alterar','main.customer.edit');
INSERT INTO `ope`.`sub_menu` (`fk_id_main_menu`, `name`, `state`) VALUES ('2', 'Excluir','main.customer.delete');

##########################################################################################################################################################
# TYPE_PERSON_MAIN_MENU
##########################################################################################################################################################

INSERT INTO `ope`.`type_person_main_menu` (`fk_id_type_person`, `fk_id_main_menu`) VALUES ('3', '1');
INSERT INTO `ope`.`type_person_main_menu` (`fk_id_type_person`, `fk_id_main_menu`) VALUES ('4', '1');
INSERT INTO `ope`.`type_person_main_menu` (`fk_id_type_person`, `fk_id_main_menu`) VALUES ('3', '2');
INSERT INTO `ope`.`type_person_main_menu` (`fk_id_type_person`, `fk_id_main_menu`) VALUES ('4', '2');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PF
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('1', 'Bruno Rafael Campos');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('1','Bruno Rafael Campos', '6126710871', '61982854011', 'bruno.rafael.campos@lifefp.com.br');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '1', 'Quadra Quadra 17 Conjunto B', '820', 'Paranoá', 'Brasília', 'DF', '71571702',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('1', '1', '151813747');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('1', '2', '17380470833');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PJ
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('2', 'Betina e Breno Restaurante ME');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('2', 'Betina Santos', '1125680609', '11995636415', 'hugo_gabriel@gmail.com');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '2', 'Praça Braúna', '179', 'Cidade Mãe do Céu', 'São Paulo', 'SP', '03306100',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('2', '3', '35301505000170');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('2', '4', '267442577886');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | VENDEDOR
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('4', 'Theo Giovanni dos Santos');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '3', 'Rua Pedro Dias Batista 70', '116', 'Centro', 'Águas de Santa Bárbara', 'SP', '18770970',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('3', '1', '367048553');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('3', '2', '31501402854');

INSERT INTO `ope`.`user_access` (`fk_id_person`, `email`, `password`) VALUES ('3', 'theo.santos@wasan.com', '4r3e2w1q');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | GERENTE
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('3', 'Leonardo Vinicius Yuri Martins');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '4', 'Rua Primo Natal', '242', 'Jardim Maria Lídia', 'São Paulo', 'SP', '18770970',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('4', '1', '171798375');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('4', '2', '18504454860');

INSERT INTO `ope`.`user_access` (`fk_id_person`, `email`, `password`) VALUES ('4', 'leonardo.martins@wasan.com', 'leo12345');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PF
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('1', 'Nathan Iago Diego Dias');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('5', 'Nathan Iago Diego Dias', '1128252606', '11996695355', 'nidias@comercialmendes.net');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '5', 'Rua Nova Timboteua', '820', 'Vila Nova Pauliceia', 'São Paulo', 'SP', '03267110',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('5', '1', '159407151');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('5', '2', '15746751847');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PF
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('1', 'Erick Francisco Antonio Carvalho');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('6', 'Erick Francisco Antonio Carvalho', '1128372756', '11999140659', 'erick_francisco@credendio.com.br');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '6', 'Rua Francisco de Soutomaior', '840', 'Jardim Miriam', 'São Paulo', 'SP', '08141013',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('6', '1', '356300754');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('6', '2', '24312177872');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PF
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('1', 'Nicolas Fernando de Paula');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('7', 'Nicolas Fernando de Paula', '1135425463', '11998160534', 'nicolas.fernando.paula@siexpress.com.br');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '7', 'Rua Henrique Fausto Lancellotti', '210', 'Nova Piraju', 'São Paulo', 'SP', '04625005',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('7', '1', '404086901');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('7', '2', '10335055877');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PJ
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('2', 'Gabrielly e Cauê Gráfica Ltda');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('8', 'Gabrielly Santana', '1139801197', '11992354480', 'compras@gabriellycaue.com.br');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '8', 'Rua Benedito Xavier Pinheiro', '137', 'Santana', 'São Paulo', 'SP', '02018020',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('8', '3', '25521253000131');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('8', '4', '624737133267');

##########################################################################################################################################################
# PERSON - CONTACT - ADDRESS - DOCUMENT | CLIENTE_PJ
##########################################################################################################################################################

INSERT INTO `ope`.`person` (`fk_id_type_person`, `name`) 
VALUES ('2', 'Benício e Kevin Adega Ltda');

INSERT INTO `ope`.`contact` (`fk_id_person`,`name`, `phone`, `cellphone`, `email`) 
VALUES ('9', 'Benício Alga', '1237497840', '12999199484', 'benicio_kevin@adegabk.com.br');

INSERT INTO `ope`.`address` (`fk_id_type_address`, `fk_id_person`, `street`, `number`, `neighborhood`, `city`, `district`, `zipcode`,`main`) 
VALUES ('1', '9', 'Avenida Deputado Tarcílio Bernardo', '412', 'Jardim Continental II', 'São Paulo', 'SP', '12093686',1);

INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('9', '3', '40292840000190');
INSERT INTO `ope`.`document` (`fk_id_person`, `fk_id_type_document`, `value`) VALUES ('9', '4', '528702653408');

##########################################################################################################################################################
# SALESMAN_CLIENT
##########################################################################################################################################################
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '1');
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '2');
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '5');
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '6');
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '7');
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '8');
INSERT INTO `ope`.`salesman_client` (`fk_id_person_salesman`, `fk_id_person_client`) VALUES ('3', '9');
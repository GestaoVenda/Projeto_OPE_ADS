use ope;

INSERT INTO `ope`.`group` (`name_group`) VALUES ('administrador');
INSERT INTO `ope`.`group` (`name_group`) VALUES ('vendedor');
################################################################################################
INSERT INTO `ope`.`permission` (`name_permission`, `state`) VALUES ('home', 'localhost:8080/teste/home');
################################################################################################
--INSERT INTO `ope`.`group_permission` (`fk_id_permission`, `fk_id_group`) VALUES ('1', '1');
--INSERT INTO `ope`.`group_permission` (`fk_id_permission`, `fk_id_group`) VALUES ('1', '2');
################################################################################################
INSERT INTO `ope`.`user_group` (`fk_id_user`, `fk_id_group`) VALUES ('1', '1');
INSERT INTO `ope`.`user_group` (`fk_id_user`, `fk_id_group`) VALUES ('2', '2');
INSERT INTO `ope`.`user_group` (`fk_id_user`, `fk_id_group`) VALUES ('3', '2');
INSERT INTO `ope`.`user_group` (`fk_id_user`, `fk_id_group`) VALUES ('4', '2');

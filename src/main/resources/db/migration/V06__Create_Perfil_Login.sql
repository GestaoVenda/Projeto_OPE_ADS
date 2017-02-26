use ope;

CREATE TABLE menu (
    id_menu BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name_menu VARCHAR(100) NOT NULL,
    url_menu VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_menu)
);

CREATE TABLE `type` (
    id_type BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name_type VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_type)
);

CREATE TABLE type_menu (
    fk_id_menu BIGINT UNSIGNED NOT NULL,
    fk_id_type BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (fk_id_menu)
        REFERENCES menu (id_menu)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (fk_id_type)
        REFERENCES `type` (id_type)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    PRIMARY KEY (fk_id_menu , fk_id_type)
);

CREATE TABLE user_type (
    fk_id_user BIGINT UNSIGNED NOT NULL,
    fk_id_type BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (fk_id_user)
        REFERENCES usuario (id_usuario)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (fk_id_type)
        REFERENCES `type` (id_type)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    PRIMARY KEY (fk_id_user , fk_id_type)
);
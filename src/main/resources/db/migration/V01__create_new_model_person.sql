USE ope;

CREATE TABLE type_person (
    `id_type_person` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id_type_person)
);

CREATE TABLE person (
    `id_person` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `fk_id_type_person` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NULL,
    `active` BOOLEAN DEFAULT 1,
    `dt_creation` TIMESTAMP DEFAULT CURRENT_TIMESTAMP (),
    PRIMARY KEY (id_person),
    FOREIGN KEY (fk_id_type_person)
        REFERENCES type_person (id_type_person)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE type_document (
    `id_type_document` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id_type_document)
);

CREATE TABLE document (
    `fk_id_person` BIGINT UNSIGNED NOT NULL,
    `fk_id_type_document` BIGINT UNSIGNED NOT NULL,
    `value` VARCHAR(100) NOT NULL,
    PRIMARY KEY (fk_id_person , fk_id_type_document),
    FOREIGN KEY (fk_id_person)
        REFERENCES person (id_person)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (fk_id_type_document)
        REFERENCES type_document (id_type_document)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE contact (
    `id_contact` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `fk_id_person` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(10) NULL,
    `cellphone` VARCHAR(11) NULL,
    `email` VARCHAR(100) NULL,
    PRIMARY KEY (id_contact),
    FOREIGN KEY (fk_id_person)
        REFERENCES person (id_person)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE type_address (
    `id_type_address` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id_type_address)
);

CREATE TABLE address (
    `id_address` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `fk_id_type_address` BIGINT UNSIGNED NOT NULL,
    `fk_id_person` BIGINT UNSIGNED NOT NULL,
    `street` VARCHAR(100) NULL,
    `number` INTEGER NULL,
    `neighborhood` VARCHAR(100) NULL,
    `city` VARCHAR(100) NULL,
    `district` VARCHAR(100) NULL,
    `zipcode` VARCHAR(8) NOT NULL,
    `complement` VARCHAR(100) NULL,
    `main` BOOLEAN DEFAULT 0,
    PRIMARY KEY (id_address),
    FOREIGN KEY (fk_id_type_address)
        REFERENCES type_address (id_type_address)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (fk_id_person)
        REFERENCES person (id_person)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE main_menu (
    `id_main_menu` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id_main_menu)
);

CREATE TABLE sub_menu (
    `fk_id_main_menu` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `state` VARCHAR(100) NOT NULL,
    PRIMARY KEY (fk_id_main_menu , name)
);

CREATE TABLE type_person_main_menu (
    `fk_id_type_person` BIGINT UNSIGNED NOT NULL,
    `fk_id_main_menu` BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (fk_id_type_person , fk_id_main_menu),
    FOREIGN KEY (fk_id_type_person)
        REFERENCES type_person (id_type_person)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (fk_id_main_menu)
        REFERENCES main_menu (id_main_menu)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE salesman_client (
    `fk_id_person_salesman` BIGINT UNSIGNED NOT NULL,
    `fk_id_person_client` BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (fk_id_person_salesman , fk_id_person_client),
    FOREIGN KEY (fk_id_person_salesman)
        REFERENCES person (id_person)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (fk_id_person_client)
        REFERENCES person (id_person)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE user_access (
    `fk_id_person` BIGINT UNSIGNED NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (fk_id_person),
    FOREIGN KEY (fk_id_person)
        REFERENCES person (id_person)
        ON DELETE CASCADE ON UPDATE NO ACTION
);
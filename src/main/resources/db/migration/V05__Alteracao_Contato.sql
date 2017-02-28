use ope;

DROP TABLE contact;

CREATE TABLE contact (
    id_contact BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_client BIGINT UNSIGNED NOT NULL,
    name_contact VARCHAR(150),
    FOREIGN KEY (id_client)
        REFERENCES client (id_client)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    PRIMARY KEY (id_contact)
);

CREATE TABLE phone_contact (
    id_phone BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_contact BIGINT UNSIGNED NOT NULL,
    ddi VARCHAR(3) NULL NOT NULL,
    ddd VARCHAR(2) NULL NOT NULL,
    phone VARCHAR(8) NULL NOT NULL,
    FOREIGN KEY (id_contact)
        REFERENCES contact (id_contact)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    PRIMARY KEY (id_phone)
);

CREATE TABLE cellphone_contact (
    id_cellphone BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_contact BIGINT UNSIGNED NOT NULL,
    ddi VARCHAR(3) NULL NOT NULL,
    ddd VARCHAR(2) NULL NOT NULL,
    cellphone VARCHAR(9) NULL NOT NULL,
    FOREIGN KEY (id_contact)
        REFERENCES contact (id_contact)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    PRIMARY KEY (id_cellphone)
);

CREATE TABLE email_contact (
    id_email BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_contact BIGINT UNSIGNED NOT NULL,
    email VARCHAR(100) NULL NOT NULL,
    FOREIGN KEY (id_contact)
        REFERENCES contact (id_contact)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    PRIMARY KEY (id_email)
);


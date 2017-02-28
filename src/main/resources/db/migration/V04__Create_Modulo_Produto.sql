USE ope;
create table category (
	id_category BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name_category varchar(100) NOT NULL,
    active BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(id_category)
);

create table measure (
	id_measure BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_measure varchar(100) NOT NULL,
    PRIMARY KEY(id_measure)
);

create table product (
	id_product BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name_product varchar(100),
    description varchar(200),
    id_category BIGINT UNSIGNED NOT NULL,
    id_measure BIGINT UNSIGNED NOT NULL,
    cost_price Double(10,2) DEFAULT 0,
    sale_price Double(10,2),
    stock INT UNSIGNED NOT NULL DEFAULT 0,
    min_stock INT UNSIGNED NOT NULL DEFAULT 0,
    max_stock INT UNSIGNED NULL,
    allows_fractionation BIT NOT NULL DEFAULT 0,
    fractionated_item BIT NOT NULL DEFAULT 0,
    validity datetime NULL,
    active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id_product),
    FOREIGN KEY(id_category)
		REFERENCES category(id_category)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY(id_measure)
		REFERENCES measure(id_measure)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

create table fractionated_item (
	id_product BIGINT UNSIGNED NOT NULL,
    id_unit_product BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY(id_product),
    FOREIGN KEY(id_product)
		REFERENCES product(id_product),
	FOREIGN KEY(id_unit_product)
		REFERENCES product(id_product)
);

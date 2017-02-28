use ope;

CREATE TABLE `group` (
    id_group BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name_group VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_group)
);

CREATE TABLE `permission` (
    id_permission BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name_permission VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_permission)
);

CREATE TABLE `user_group` (
    fk_id_user BIGINT UNSIGNED NOT NULL,
    fk_id_group BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (fk_id_user, fk_id_group),
    FOREIGN KEY (fk_id_user)
        REFERENCES user (id_user),
    FOREIGN KEY (fk_id_group)
        	REFERENCES `group` (id_group)   
);

CREATE TABLE `group_permission` (
    fk_id_group BIGINT UNSIGNED NOT NULL,
    fk_id_permission BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (fk_id_group, fk_id_permission),
    FOREIGN KEY (fk_id_group)
        REFERENCES `group` (id_group),
    FOREIGN KEY (fk_id_permission)
        	REFERENCES `permission` (id_permission)   
);

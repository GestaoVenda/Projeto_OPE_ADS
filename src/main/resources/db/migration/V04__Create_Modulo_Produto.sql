USE ope;
create table categoria (
	id_categoria BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome_categoria varchar(100) NOT NULL,
    ativo BIT NOT NULL DEFAULT 1,
    PRIMARY KEY(id_categoria)
);

create table medida (
	id_medida BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	nome_medida varchar(100) NOT NULL,
    PRIMARY KEY(id_medida)
);

create table produto (
	id_produto BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome varchar(100),
    descricao varchar(200),
    id_categoria BIGINT UNSIGNED NOT NULL,
    id_medida BIGINT UNSIGNED NOT NULL,
    preco_custo Double(10,2) DEFAULT 0,
    preco_venda Double(10,2),
    estoque INT UNSIGNED NOT NULL DEFAULT 0,
    estoque_min INT UNSIGNED NOT NULL DEFAULT 0,
    estoque_max INT UNSIGNED NULL,
    permite_fracionamento BIT NOT NULL DEFAULT 0,
    item_fracionado BIT NOT NULL DEFAULT 0,
    validade datetime NULL,
    ativo BIT NOT NULL DEFAULT 1,
    PRIMARY KEY(id_produto),
    FOREIGN KEY(id_categoria)
		REFERENCES categoria(id_categoria)
		ON DELETE CASCADE
      	ON UPDATE NO ACTION,
	FOREIGN KEY(id_medida)
		REFERENCES medida(id_medida)
		ON DELETE CASCADE
      	ON UPDATE NO ACTION
);

create table item_fracao (
	id_produto BIGINT UNSIGNED NOT NULL,
    id_produto_unidade BIGINT UNSIGNED NOT NULL,
    
    PRIMARY KEY(id_produto),
    FOREIGN KEY(id_produto)
		REFERENCES produto(id_produto),
	FOREIGN KEY(id_produto_unidade)
		REFERENCES produto(id_produto)
);

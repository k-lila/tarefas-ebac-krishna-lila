create table tb_produtos (
	id bigint not null,	
	codigo bigint not null,
	nome varchar(50) not null,
	preco numeric(10, 2) not null,
	quantidade bigint,
	constraint pk_id_produto primary key (id)
);
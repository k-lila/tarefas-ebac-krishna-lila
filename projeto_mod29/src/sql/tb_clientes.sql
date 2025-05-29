create table tb_clientes (
	id bigint not null,	
	cpf varchar(11) not null,
	nome varchar(50) not null,
	constraint pk_id_clientes primary key (id),
	constraint uq_cpf_clientes unique (cpf)
);
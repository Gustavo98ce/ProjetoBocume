create table usuario (

id bigint auto_increment not null,
nome varchar(10) not null,
sobrenome varchar(30) not null,
endereco varchar(80) not null,
telefone varchar(20) not null,
email varchar(30) not null,
senha varchar(20) not null,
pedido_id bigint not null,

primary key (id)

	);

create table restaurante (

id bigint auto_increment not null,
nome varchar(80) not null,
endereco varchar(200) not null,
comentario varchar(500),
avaliacao int,
menu_id bigint not null,
pedido_id bigint not null,


primary key (id)

	);

create table pedido (

id bigint auto_increment not null,
valorTotal float not null,
localEntrega varchar(100) not null,
usuario_id bigint,
restaurante_id bigint,
item_id bigint,




primary key (id)

	);

create table menu (

id bigint auto_increment not null,
item_id bigint,
restaurante_id bigint,



primary key (id)

	);

	
create table item (

id bigint auto_increment not null,
nome varchar(80) not null,
valor float not null,
imagem varchar(80) not null,
pedido_id bigint,
menu_id bigint,

primary key (id)

	);
	
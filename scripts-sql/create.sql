create database combatecdz;
use combatecdz;
show tables;

create table usuario(
	id int auto_increment primary key,
	cpf varchar(11),
	nome varchar(250),
    senha varchar(20),
	email varchar(250),
    cep varchar(8),
	rua varchar(250),
    cidade varchar(250),
    estado varchar(2),    
	id_end int 
);

create table agente(
	id int auto_increment primary key,
    cpf varchar(11),
	nome varchar(250),
    senha varchar(20),
    email varchar(250),
    contratante varchar(250),
    pis varchar(11),
    regiao varchar(250)
);


create table denuncia(
    id int auto_increment primary key,
    status_den varchar(20) ,
    num_apoio int ,
    data_den varchar(11) ,
    descricao varchar(5000) ,
    resposta varchar(5000) ,
    cep varchar(8),
    rua varchar(250),
    cidade varchar(250),
    estado varchar(2),
    id_cid int ,
    id_ag int 
);


insert into denuncia(estado) values("SP");

insert into denuncia(estado) values("SP");
    
insert into denuncia(estado) values("SP");

insert into denuncia(estado) values("SP");
    

insert into denuncia(estado) values("RO");

insert into denuncia(estado) values("RO");
    
insert into denuncia(estado) values("RO");

insert into denuncia(estado) values("RO");


insert into denuncia(estado) values("MG");

insert into denuncia(estado) values("MG");
    
insert into denuncia(estado) values("MG");

insert into denuncia(estado) values("MG");


insert into denuncia(estado) values("MG");

insert into denuncia(estado) values("MG");
    
insert into denuncia(estado) values("MG");

insert into denuncia(estado) values("MG");



insert into denuncia(estado) values("DF");

insert into denuncia(estado) values("DF");
    
insert into denuncia(estado) values("DF");

insert into denuncia(estado) values("DF");


insert into usuario(cpf, nome,senha, email, id_end) values ('1234589012', 'daniel', '123', 'd@gmail',1 );



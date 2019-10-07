create database loja;

use loja;

create table pagamentos(
cpf varchar2(50) primary key,
curso varchar2(50),
data_insc date
);

create table cliente(
cpf varchar2(15) primary key
nome varchar2(100),
email varchar2(100),
);

create table cursos(
curso varchar2(50) primary key,
nome varchar2(100),
valor number(8,2),
site varchar2(100)
);


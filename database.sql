CREATE DATABASE bd_ds  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use bd_ds;

CREATE TABLE Usuarios(
    id_usuario int auto_increment,
    nombre_usuario varchar(50),
    email varchar(50),
    telefono varchar(50),
    username varchar(50),
    password varchar(50),
    tipo_nivel varchar(50),
    estatus varchar(50),
    registrado_por varchar(50),
    primary key(id_usuario)
);

CREATE TABLE Clientes(
    id_cliente int auto_increment,
    nombre_cliente varchar(50),
    email_cliente varchar(50),
    tel_cliente varchar(50),
    dir_cliente varchar(50),
    ultima_modificacion varchar(50),
    primary key(id_cliente)
);

CREATE TABLE Equipos(
    id_equipo int auto_increment,
    id_cliente int ,
    tipo_equipo varchar(50),
    marca varchar(50),
    modelo varchar(50),
    num_serie varchar(50),
    dia_ingreso varchar(50),
    mes_ingreso varchar(50),
    annio_ingreso varchar(50),
    observaciones varchar(50),
    estatus varchar(50),
    ultima_modificacion varchar(50),
    comentarios_tecnicos longtext,
    revision_tecnica_de varchar(50),
    primary key(id_equipo)
);


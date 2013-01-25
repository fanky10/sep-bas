/**
* localhost configuration for user.
*/
drop database if exists sepbas_web;
create database sepbas_web;
grant all privileges on sepbas_web.* to sepbas_root@'localhost' identified by 'root';
connect sepbas_web;
/**
* reglas de negocio a aplicar en las noticias, la noticia tiene un titulo, una fecha-hora, un cuerpo y (al menos por ahora) una sola imagen.
*/
DROP TABLE IF EXISTS jugador;

CREATE TABLE jugadores(
    jugador_id integer unsigned not null primary key AUTO_INCREMENT,
    jugador_fec_nac timestamp not null,
    jugador_nombre varchar(100) not null,
    jugador_apellido varchar(100) not null
)ENGINE=InnoDB;
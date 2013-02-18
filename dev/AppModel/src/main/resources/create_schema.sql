/**
* localhost configuration for user.
*/
drop database if exists sepbas_web;
create database sepbas_web;
grant all privileges on sepbas_web.* to sepbas_root@'localhost' identified by 'root';
connect sepbas_web;

DROP TABLE IF EXISTS jugadores;

CREATE TABLE jugadores(
    jugador_id integer unsigned not null primary key AUTO_INCREMENT,
    jugador_fec_nac timestamp not null,
    jugador_nombre varchar(100) not null,
    jugador_apellido varchar(100) not null,
    jugador_numero integer unsigned not null,
    jugador_actual_club_id integer unsigned not null,
    jugador_estado TINYINT(1) default 0 
)ENGINE=InnoDB;

DROP TABLE IF EXISTS clubes;

CREATE TABLE clubes(
    club_id integer unsigned not null primary key AUTO_INCREMENT,
    club_nombre varchar(100) not null 
)ENGINE=InnoDB;

DROP TABLE IF EXISTS jugador_club;

CREATE TABLE jugador_club(
    club_id integer unsigned not null,
    jugador_id integer unsigned not null,
    fecha_ingreso_club datetime not null,
    primary key (club_id,jugador_id) 
)ENGINE=InnoDB;

DROP TABLE IF EXISTS partidos;

CREATE TABLE partidos(
    partido_id integer unsigned not null primary key AUTO_INCREMENT,
    partido_fecha date not null,
    partido_resultado_local integer unsigned,
    partido_resultado_visitante integer unsigned
)ENGINE=InnoDB;

DROP TABLE IF EXISTS cuartos;

CREATE TABLE cuartos(
    cuarto_id integer unsigned not null primary key AUTO_INCREMENT,
    cuarto_numero integer unsigned not null,
    cuarto_partido_id integer unsigned not null
)ENGINE=InnoDB;

DROP TABLE IF EXISTS eventos;

CREATE TABLE eventos(
    evento_id integer unsigned not null primary key AUTO_INCREMENT,
    evento_generador_id integer unsigned not null,
	evento_tipo_evento_id integer unsigned not null,
	evento_estado TINYINT(1) default 0,
	evento_cuarto_id integer unsigned not null
)ENGINE=InnoDB;

DROP TABLE IF EXISTS tipos_eventos;

CREATE TABLE tipos_eventos(
    tipo_evento_id integer unsigned not null primary key AUTO_INCREMENT,
    tipo_evento_descripcion varchar(100) not null
)ENGINE=InnoDB;




-- foreign key relationships
ALTER TABLE jugadores ADD CONSTRAINT `FK_jugador_id_1` FOREIGN KEY (`jugador_actual_club_id`) REFERENCES `clubes` (`club_id`);

ALTER TABLE jugador_club ADD CONSTRAINT `FK_jugador_club_id_1` FOREIGN KEY (`club_id`) REFERENCES `clubes` (`club_id`);
ALTER TABLE jugador_club ADD CONSTRAINT `FK_jugador_club_id_2` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`jugador_id`);

ALTER TABLE cuartos ADD CONSTRAINT `FK_cuartos_id_1` FOREIGN KEY (`cuarto_partido_id`) REFERENCES `partidos` (`partido_id`);

ALTER TABLE eventos ADD CONSTRAINT `FK_eventos_id_1` FOREIGN KEY (`evento_tipo_evento_id`) REFERENCES `tipos_eventos` (`tipo_evento_id`);
ALTER TABLE eventos ADD CONSTRAINT `FK_eventos_id_2` FOREIGN KEY (`evento_cuarto_id`) REFERENCES `cuartos` (`cuarto_id`);

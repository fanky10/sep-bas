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
    jugador_estado integer unsigned not null default 0 
)ENGINE=InnoDB;

DROP TABLE IF EXISTS clubes;

CREATE TABLE clubes(
    club_id integer unsigned not null primary key AUTO_INCREMENT,
    club_nombre varchar(100) not null,
    club_localidad varchar(100) not null
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
    partido_visitante_club_id integer unsigned not null,
    partido_local_club_id integer unsigned not null,
    partido_arbitro_id integer unsigned not null,
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
    evento_generador_id integer unsigned null,
    evento_fec_hora timestamp not null default current_timestamp,
    evento_tipo varchar(80) not null,
    evento_estado integer unsigned not null default 0,
    evento_cuarto_id integer unsigned not null,
    evento_jugador_id integer unsigned not null
)ENGINE=InnoDB;

DROP TABLE IF EXISTS arbitros;

CREATE TABLE arbitros(
    arbitro_id integer unsigned not null primary key AUTO_INCREMENT,
    arbitro_nombre varchar(100) not null,
    arbitro_apellido varchar(100) not null,
    arbitro_localidad varchar(100) not null 
)ENGINE=InnoDB;

-- foreign key relationships
ALTER TABLE jugadores ADD CONSTRAINT `FK_jugador_id_1` FOREIGN KEY (`jugador_actual_club_id`) REFERENCES `clubes` (`club_id`);

ALTER TABLE jugador_club ADD CONSTRAINT `FK_jugador_club_id_1` FOREIGN KEY (`club_id`) REFERENCES `clubes` (`club_id`);
ALTER TABLE jugador_club ADD CONSTRAINT `FK_jugador_club_id_2` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`jugador_id`);

ALTER TABLE cuartos ADD CONSTRAINT `FK_cuartos_id_1` FOREIGN KEY (`cuarto_partido_id`) REFERENCES `partidos` (`partido_id`);

ALTER TABLE eventos ADD CONSTRAINT `FK_eventos_id_1` FOREIGN KEY (`evento_cuarto_id`) REFERENCES `cuartos` (`cuarto_id`);
ALTER TABLE eventos ADD CONSTRAINT `FK_eventos_id_2` FOREIGN KEY (`evento_jugador_id`) REFERENCES `jugadores` (`jugador_id`);

-- ValueObject views go here
DROP VIEW IF EXISTS reporte_jugadores;
CREATE VIEW reporte_jugadores AS (
    SELECT evento_jugador_id as jugador_id, evento_cuarto_id as cuarto_id, 
    CASE WHEN evento_tipo = 'LANZAMIENTO_JUGADOR_UN_PUNTO' then 1 ELSE 0 END AS lanzamientosSimples,
    CASE WHEN evento_tipo = 'LANZAMIENTO_JUGADOR_DOS_PUNTOS' then 1 ELSE 0 END AS lanzamientosDobles,
    CASE WHEN evento_tipo = 'LANZAMIENTO_JUGADOR_TRES_PUNTOS' then 1 ELSE 0 END AS lanzamientosTriples,
    CASE WHEN evento_tipo = 'ASISTENCIA_JUGADOR' then 1 ELSE 0 END AS asistencias,
    CASE WHEN evento_tipo = 'FALTA_JUGADOR' then 1 ELSE 0 END AS faltas
    FROM eventos WHERE evento_estado = 1
);

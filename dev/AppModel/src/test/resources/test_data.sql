--
-- Test data for table `arbitros`
--

INSERT INTO `arbitros` (`arbitro_id`, `arbitro_nombre`, `arbitro_apellido`, `arbitro_localidad`) 
VALUES (1,'Leonardo',' Zalazar','Villa GG');

--
-- Test data for table `clubes`
--

INSERT INTO `clubes` (`club_id`, `club_nombre`,`club_localidad`) 
VALUES 
(1,'Libertad','Default'),
(2,'Fisherton','Default'),
(3,'El Tala','Default'),
(4,'Estudiantil','Default');

--
-- Test data for table `jugadores`
--
--
-- Jugadores del club Libertad
--
INSERT INTO `jugadores` (`jugador_id`, `jugador_fec_nac`, `jugador_nombre`, `jugador_apellido`, `jugador_numero`, `jugador_actual_club_id`, `jugador_estado`) VALUES 
(1,'2013-03-15 03:00:00','Paul','Arizin',99,1,0),
(2,'2013-03-14 03:00:00','Charles','Barkley',22,1,0),
(3,'2013-03-15 03:00:00','Rick','Barry',23,1,0),
(4,'2013-03-14 03:00:00','Elgin','Baylor',33,1,0),
(5,'2013-03-15 03:00:00','Dave','Bing',11,1,0),
(6,'2013-03-14 03:00:00','Larry','Bird',10,1,0),
(7,'2013-03-15 03:00:00','Wilt','Chamberlain',9,1,0),
(8,'2013-03-14 03:00:00','Bob','Cousy',2,1,0),
(9,'2013-03-27 03:00:00','Dave','Cowens',88,1,0);

--
-- Jugadores del club Fisherton
--
INSERT INTO `jugadores` (`jugador_id`, `jugador_fec_nac`, `jugador_nombre`, `jugador_apellido`, `jugador_numero`, `jugador_actual_club_id`, `jugador_estado`) VALUES 
(11,'2013-03-15 03:00:00','Paul','Arizin',99,2,0),
(12,'2013-03-14 03:00:00','Charles','Barkley',22,2,0),
(13,'2013-03-15 03:00:00','Rick','Barry',23,2,0),
(14,'2013-03-14 03:00:00','Elgin','Baylor',33,2,0),
(15,'2013-03-15 03:00:00','Dave','Bing',11,2,0),
(10,'2013-03-27 03:00:00','Julius','Erving',89,2,0);


--
-- Test data for table `partidos`
-- 
INSERT INTO `partidos` 
(`partido_id`, `partido_arbitro_id`, `partido_fecha`, `partido_visitante_club_id`, `partido_local_club_id`, `partido_resultado_local`, `partido_resultado_visitante`) 
VALUES 
(1,1,'2013-03-04',1,2,NULL,NULL),
(2,1,'2013-03-04',2,3,NULL,NULL),
(3,1,'2013-03-04',1,3,NULL,NULL);

--
-- Test data for table `cuartos`
-- 
INSERT INTO `cuartos` (`cuarto_id`, `cuarto_numero`, `cuarto_partido_id`) 
VALUES 
(1,1,1),(2,2,1);

--
-- Test data for table `eventos`
--

-- cuarto 1 partido 1 total puntos: 9
INSERT INTO `eventos` (`evento_id`, `evento_generador_id`, `evento_fec_hora`, `evento_tipo`, `evento_estado`, `evento_cuarto_id`, `evento_jugador_id`) 
VALUES (1,NULL,'2013-03-04 18:12:14','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,1),
(2,NULL,'2013-03-04 18:12:14','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,1),
(3,NULL,'2013-05-09 01:02:39','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,1),
(4,NULL,'2013-05-09 01:02:39','LANZAMIENTO_JUGADOR_TRES_PUNTOS',1,1,1);

-- cuarto 1 partido 1 total puntos: 11
INSERT INTO `eventos` (`evento_id`, `evento_generador_id`, `evento_fec_hora`, `evento_tipo`, `evento_estado`, `evento_cuarto_id`, `evento_jugador_id`) 
VALUES (5,NULL,'2013-03-04 18:12:14','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,12),
(6,NULL,'2013-03-04 18:12:14','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,12),
(7,NULL,'2013-05-09 01:02:39','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,12),
(8,NULL,'2013-05-09 01:02:39','LANZAMIENTO_JUGADOR_DOS_PUNTOS',1,1,12),
(9,NULL,'2013-05-09 01:02:39','LANZAMIENTO_JUGADOR_TRES_PUNTOS',1,1,12);


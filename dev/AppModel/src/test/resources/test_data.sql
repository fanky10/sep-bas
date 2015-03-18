--
-- Dumping data for table `arbitros`
--

INSERT INTO `arbitros` (`arbitro_id`, `arbitro_nombre`, `arbitro_apellido`, `arbitro_localidad`) VALUES (4,'Leonardo',' Zalazar','Villa GG');

--
-- Dumping data for table `clubes`
--

INSERT INTO `clubes` (`club_id`, `club_nombre`,`club_localidad`) 
VALUES 
(1,'Libertad','Default'),
(2,'Fisherton','Default'),
(3,'El Tala','Default'),
(4,'Estudiantil','Default');

--
-- Dumping data for table `cuartos`
--

INSERT INTO `cuartos` (`cuarto_id`, `cuarto_numero`, `cuarto_partido_id`) VALUES (11,1,21),(12,1,27);

--
-- Dumping data for table `eventos`
--

INSERT INTO `eventos` (`evento_id`, `evento_generador_id`, `evento_fec_hora`, `evento_tipo_evento`, `evento_estado`, `evento_cuarto_id`, `evento_jugador_id`) VALUES (10,NULL,'2013-03-04 18:12:14',0,1,11,61),(11,NULL,'2013-03-04 18:12:14',0,1,11,61),(12,NULL,'2013-05-09 01:02:39',0,1,12,61),(13,NULL,'2013-05-09 01:02:39',0,1,12,80),(14,NULL,'2013-05-09 01:02:39',0,1,12,60);

--
-- Dumping data for table `jugadores`
--

-- Jugadores del club Libertad
INSERT INTO `jugadores` (`jugador_id`, `jugador_fec_nac`, `jugador_nombre`, `jugador_apellido`, `jugador_numero`, `jugador_actual_club_id`, `jugador_estado`) VALUES 
(null,'2013-03-15 03:00:00','Paul','Arizin',99,1,0),
(null,'2013-03-14 03:00:00','Charles','Barkley',22,1,0),
(null,'2013-03-15 03:00:00','Rick','Barry',23,1,0),
(null,'2013-03-14 03:00:00','Elgin','Baylor',33,1,0),
(null,'2013-03-15 03:00:00','Dave','Bing',11,1,0),
(null,'2013-03-14 03:00:00','Larry','Bird',10,1,0),
(null,'2013-03-15 03:00:00','Wilt','Chamberlain',9,1,0),
(null,'2013-03-14 03:00:00','Bob','Cousy',2,1,0),
(null,'2013-03-27 03:00:00','Dave','Cowens',88,1,0),
(null,'2013-03-27 03:00:00','Julius','Erving',89,2,0),
(null,'2013-03-27 03:00:00','George','Gervin',12,2,0),
(null,'2013-03-20 03:00:00','Dave','DeBusschere',14,1,0);
-- Jugadores del club Fisherton
INSERT INTO `jugadores` (`jugador_id`, `jugador_fec_nac`, `jugador_nombre`, `jugador_apellido`, `jugador_numero`, `jugador_actual_club_id`, `jugador_estado`) VALUES 
(null,'2013-03-15 03:00:00','Paul','Arizin',99,2,0),
(null,'2013-03-14 03:00:00','Charles','Barkley',22,2,0),
(null,'2013-03-15 03:00:00','Rick','Barry',23,2,0),
(null,'2013-03-14 03:00:00','Elgin','Baylor',33,2,0),
(null,'2013-03-15 03:00:00','Dave','Bing',11,2,0),
(null,'2013-03-14 03:00:00','Larry','Bird',10,2,0),
(null,'2013-03-15 03:00:00','Wilt','Chamberlain',9,2,0),
(null,'2013-03-14 03:00:00','Bob','Cousy',2,2,0),
(null,'2013-03-27 03:00:00','Dave','Cowens',88,2,0),
(null,'2013-03-27 03:00:00','Julius','Erving',89,2,0),
(null,'2013-03-27 03:00:00','George','Gervin',12,2,0),
(null,'2013-03-20 03:00:00','Dave','DeBusschere',14,2,0);

--
-- Dumping data for table `partidos`
--
INSERT INTO `partidos` (`partido_id`, `partido_fecha`, `partido_visitante_club_id`, `partido_local_club_id`, `partido_resultado_local`, `partido_resultado_visitante`) VALUES (16,'2013-03-04',62,61,NULL,NULL),(17,'2013-03-04',62,61,NULL,NULL),(18,'2013-03-04',62,61,NULL,NULL),(19,'2013-03-04',62,61,NULL,NULL),(20,'2013-03-04',62,61,NULL,NULL),(21,'2013-03-04',62,61,NULL,NULL),(26,'2013-03-04',62,61,NULL,NULL),(27,'2013-05-08',62,61,NULL,NULL);

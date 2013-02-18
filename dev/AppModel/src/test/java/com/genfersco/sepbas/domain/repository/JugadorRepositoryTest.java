package com.genfersco.sepbas.domain.repository;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.EstadoJugador;
import com.genfersco.sepbas.domain.model.Jugador;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml" })
@Transactional
public class JugadorRepositoryTest {
	
	private Jugador jugador = new Jugador();
	
	@Autowired
	private JugadorRepository jugadorRepository;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Before
	public void buildData(){
		Club club = new Club();
		club.setNombre("SportClub");
		
		club = clubRepository.save(club);
		
		jugador.setApellido("Gonzalez");
		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
		jugador.setNombre("Cacho");
		jugador.setNumero(2);
		jugador.setClub(club);
		jugador.setEstado(EstadoJugador.HABILITADO);
		
		jugador = jugadorRepository.save(jugador);
	}
	
	@Test
	public void testGuardarJugador(){
		assertTrue(jugadorRepository.exists(jugador.getId()));
		assertTrue(jugadorRepository.count()>0);
	}
}


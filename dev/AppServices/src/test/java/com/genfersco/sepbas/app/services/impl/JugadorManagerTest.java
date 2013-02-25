package com.genfersco.sepbas.app.services.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.domain.mocked.JugadorMocked;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.repository.ClubRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class JugadorManagerTest {
	@Autowired
	private JugadorManager jugadorManager;
	@Autowired
	private ClubRepository clubRepository;

	private Jugador jugador = new Jugador();
	private Club club = new Club();

	@Before
	public void buildData() {
		club.setNombre("SportClub");
		club = clubRepository.save(club);

		jugador = jugadorManager.addJugador(JugadorMocked.getJugador(club));
	}

	@Test
	public void testGetAll() {
		List<Jugador> jugadores = jugadorManager.getJugadores();
		assertTrue(jugadores != null && !jugadores.isEmpty());
	}

	@Test
	public void testDeleteJugador() {
		Jugador aux = jugadorManager.getJugadorById(jugador.getId());
		jugadorManager.deleteJugador(aux);
		aux = jugadorManager.getJugadorById(jugador.getId());
		assertTrue(aux == null);

	}

	@Test
	public void testGetJugadoresClub() {
		Club club = new Club();
		club.setNombre("SportTest");
		club = clubRepository.save(club);
		for (int i = 0; i < 10; i++) {
			jugador = jugadorManager.addJugador(JugadorMocked.getJugador(club));
		}
		List<Jugador> jugadores = jugadorManager.getJugadoresClub(club.getId());
		assertTrue(jugadores!=null && !jugadores.isEmpty());
	}
	
}

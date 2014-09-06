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
import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.mocked.JugadorMocked;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.EstadoJugador;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.repository.ClubRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class JugadorManagerTest {
	@Autowired
	private JugadorManager jugadorManager;
	@Autowired
	private ClubMocked clubMocked;
	@Autowired
	private JugadorMocked jugadorMocked;

	private Jugador jugador = new Jugador();

	@Before
	public void buildData() {


		jugador = jugadorManager.addJugador(jugadorMocked.getJugador(false));
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
		assertTrue(aux.getEstado() == EstadoJugador.DESHABILITADO);

	}

	@Test
	public void testGetJugadoresClub() {
		Club club = clubMocked.getClub();
		for (int i = 0; i < 10; i++) {
			jugador = jugadorManager.addJugador(jugadorMocked.getJugador(club,false));
		}
		List<Jugador> jugadores = jugadorManager.getJugadoresClub(club.getId());
		assertTrue(jugadores!=null && !jugadores.isEmpty());
	}
	
}

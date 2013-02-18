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

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.mocked.JugadorMocked;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.repository.ClubRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class ServicesManagerTest {

	@Autowired
	private ServicesManager servicesManager;
	@Autowired
	private ClubRepository clubRepository;

	private Jugador jugador = new Jugador();

	@Before
	public void buildData() {
		Club club = new Club();
		club.setNombre("SportClub");

		club = clubRepository.save(club);

		jugador = servicesManager.addJugador(JugadorMocked.getJugador(club));
	}

	@Test
	public void testGetAll() {
		List<Jugador> jugadores = servicesManager.getJugadores();
		assertTrue(jugadores != null && !jugadores.isEmpty());
	}

	@Test
	public void testEliminaJugador() {
		Integer generatedId = jugador.getId();
		servicesManager.deleteJugador(generatedId);
		Jugador deleted = servicesManager.getJugadorById(generatedId);
		assertTrue(deleted == null);
	}

}

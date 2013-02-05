package com.genfersco.sepbas.app.services.impl;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Jugador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class ServicesManagerTest {
	
	@Autowired
	private ServicesManager servicesManager;
	
	private Jugador jugador = new Jugador();

	@Before
	public void buildData() {
		jugador.setApellido("Gonzalez");
		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
		jugador.setNombre("Cacho");

		jugador = servicesManager.addJugador(jugador);
	}

	@Test
	public void testGetAll() {
		List<Jugador> jugadores = servicesManager.getJugadores();
		assertTrue(jugadores!=null && !jugadores.isEmpty());
	}

}

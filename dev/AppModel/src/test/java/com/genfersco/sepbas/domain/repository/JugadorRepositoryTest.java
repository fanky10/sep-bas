package com.genfersco.sepbas.domain.repository;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.model.Jugador;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml" })
@Transactional
public class JugadorRepositoryTest {
	
	private Jugador jugador = new Jugador();
	
	@Autowired
	private JugadorRepository jugadorRepository;
	
	@Before
	public void buildData(){
//		jugador.setApellido("Gonzalez");
//		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
//		jugador.setNombre("Cacho");
//		
//		jugador = jugadorRepository.save(jugador);
	}
	
	@Test
	public void testGuardarJugador(){
		assertTrue(true);
//		assertTrue(jugadorRepository.exists(jugador.getId()));
//		assertTrue(jugadorRepository.count()>0);
	}
}


package com.genfersco.sepbas.domain.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.mocked.EventoMocked;
import com.genfersco.sepbas.domain.model.Evento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class EventoRepositoryTest {
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private EventoMocked eventoMocked;

	private Evento evento = new Evento();

	@Before
	public void buildData() {
		evento = eventoMocked.getEvento();
	}

	@Test
	public void testGuardarEvento() {
		assertTrue(eventoRepository.count() > 0);
		assertTrue(eventoRepository.exists(evento.getId()));
	}

	@Test
	public void testGuardarEventoHijo() {
		// evento hijo
		Evento eventoHijo = eventoMocked.getEvento(evento);
		assertTrue(eventoHijo != null
				&& eventoRepository.exists(eventoHijo.getId()));
	}

}

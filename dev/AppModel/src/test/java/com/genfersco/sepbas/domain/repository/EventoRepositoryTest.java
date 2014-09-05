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

import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.mocked.CuartoMocked;
import com.genfersco.sepbas.domain.mocked.EventoMocked;
import com.genfersco.sepbas.domain.mocked.JugadorMocked;
import com.genfersco.sepbas.domain.mocked.PartidoMocked;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.model.TipoEvento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class EventoRepositoryTest {
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
        private EventoMocked eventoMocked;
        @Autowired
        private CuartoMocked cuartoMocked;
        @Autowired
        private JugadorMocked jugadorMocked;
        
	private Cuarto cuarto = new Cuarto();
	private Jugador jugador = new Jugador();
	private Evento evento = new Evento();
	
	
	@Before
	public void buildData() {
                cuarto = cuartoMocked.getCuarto();
                jugador = jugadorMocked.getJugador();
                
                evento = new Evento();
		evento.setCuarto(cuarto);
		evento.setJugador(jugador);
		evento.setFechaHora(new Date(System.currentTimeMillis()));
		evento.setEstado(EstadoEvento.NO_ELIMINADO);
		evento.setTipoEvento(TipoEvento.INGRESA_JUGADOR);
		
		evento = eventoRepository.save(evento);
	}

	@Test
	public void testGuardarEvento() {
		assertTrue(eventoRepository.count() > 0);
		assertTrue(eventoRepository.exists(evento.getId()));
	}

	@Test
	public void testGuardarEventoHijo() {
		// evento hijo
		Evento eventoHijo = new Evento();
		eventoHijo.setCuarto(cuarto);
		eventoHijo.setJugador(jugador);
		eventoHijo.setFechaHora(new Date(System.currentTimeMillis()));
		eventoHijo.setEstado(EstadoEvento.NO_ELIMINADO);
		eventoHijo.setTipoEvento(TipoEvento.INGRESA_JUGADOR);
		eventoHijo.setEventoGenerador(evento);
		
		eventoHijo = eventoRepository.save(eventoHijo);
		assertTrue(eventoHijo!=null && eventoRepository.exists(eventoHijo.getId()));
	}

}

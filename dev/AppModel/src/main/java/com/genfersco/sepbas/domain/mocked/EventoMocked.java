package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.TipoEvento;
import com.genfersco.sepbas.domain.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMocked {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private CuartoMocked cuartoMocked;
    @Autowired
    private JugadorMocked jugadorMocked;
	public Evento getEvento() {
            Cuarto cuarto = cuartoMocked.getCuarto();
            Jugador jugador = jugadorMocked.getJugador();
		Evento evento = new Evento();
		evento.setCuarto(cuarto);
		evento.setFechaHora(new Date(System.currentTimeMillis()));
		evento.setEstado(EstadoEvento.NO_ELIMINADO);
		evento.setTipoEvento(TipoEvento.INGRESA_JUGADOR);
		evento.setJugador(jugador);
                evento = eventoRepository.save(evento);
		return evento;
	}
}

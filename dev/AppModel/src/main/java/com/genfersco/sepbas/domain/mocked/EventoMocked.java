package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.TipoEvento;
import com.genfersco.sepbas.domain.repository.EventoRepository;

@Component
public class EventoMocked {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private CuartoMocked cuartoMocked;
    @Autowired
    private JugadorMocked jugadorMocked;

    public Evento getEvento() {
        return getEvento(null);
    }

    public Evento getEvento(Evento eventoGenerador) {
        return getEvento(cuartoMocked.getCuarto(), eventoGenerador);
    }

    public Evento getEvento(Cuarto cuarto, Evento eventoGenerador) {
        return getEvento(cuarto, eventoGenerador, TipoEvento.INGRESA_JUGADOR, jugadorMocked.getJugador());
    }

    public Evento getEvento(Cuarto cuarto, Evento eventoGenerador, TipoEvento tipoEvento, Jugador jugador) {
        Evento evento = new Evento();
        evento.setCuarto(cuarto);
        evento.setFechaHora(new Date(System.currentTimeMillis()));
        evento.setEstado(EstadoEvento.NO_ELIMINADO);
        evento.setTipoEvento(tipoEvento);
        evento.setJugador(jugador);
        evento.setEventoGenerador(eventoGenerador);

        return eventoRepository.save(evento);
    }
}

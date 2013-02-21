package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.TipoEvento;

public class EventoMocked {

	public static Evento getEvento(Cuarto cuarto, Jugador jugador) {
		Evento evento = new Evento();
		evento.setCuarto(cuarto);
		evento.setFechaHora(new Date(System.currentTimeMillis()));
		evento.setEstado(EstadoEvento.NO_ELIMINADO);
		evento.setTipoEvento(TipoEvento.INGRESA_JUGADOR);
		evento.setJugador(jugador);
		return evento;
	}
}

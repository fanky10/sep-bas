package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Jugador;

public interface JugadorManager {
	public Jugador addJugador(Jugador jugador);
	public List<Jugador> getJugadores();
}

package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Jugador;

public interface JugadorManager {
	public Jugador addJugador(Jugador jugador);
	public List<Jugador> getJugadores();
	public void deleteJugador(Jugador id);
	public Jugador getJugadorById(Integer id);
	public List<Jugador> getJugadoresClub(Integer clubId);
}

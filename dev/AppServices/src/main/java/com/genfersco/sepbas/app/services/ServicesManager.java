package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Jugador;
/**
 * Encapsulates all calls to different managers. Instead of getting
 * and instance of each manager, this services manager gets references
 * to all of them
 * @author fanky
 *
 */
public interface ServicesManager {
	public Jugador addJugador(Jugador jugador);
	public List<Jugador> getJugadores();
	public void deleteJugador(Integer id);
	public Jugador getJugadorById(Integer id);
}

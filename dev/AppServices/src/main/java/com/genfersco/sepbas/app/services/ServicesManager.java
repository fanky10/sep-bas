package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;

/**
 * Encapsulates all calls to different managers. Instead of getting and instance
 * of each manager, this services manager gets references to all of them
 * 
 * @author fanky
 * 
 */
public interface ServicesManager {
	public Jugador addJugador(Jugador jugador);

	public List<Jugador> getJugadores();

	public void deleteJugador(Integer id);

	public Jugador getJugadorById(Integer id);
	
	public List<Club> getClubes();
	
	public Club addClub(Club club);
	
	public void deleteClub(Integer id);
	
	public Club getClub(String id);
	
	public List<Jugador> getJugadoresClub(Integer clubId);
	
}

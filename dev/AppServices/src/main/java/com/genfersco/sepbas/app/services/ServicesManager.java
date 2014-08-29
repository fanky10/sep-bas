package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;

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
	
	public Partido addPartido(Partido partido);
	
	public Cuarto addCuarto(Cuarto cuarto, List<Jugador> equipo1, List<Jugador> equipo2);
	
	public List<Arbitro> getArbitrosHabilitados();
        
        public Arbitro addArbitro(Arbitro arbitro);
}

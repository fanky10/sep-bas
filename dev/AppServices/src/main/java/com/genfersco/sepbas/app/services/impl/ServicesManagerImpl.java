package com.genfersco.sepbas.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.genfersco.sepbas.app.services.ClubManager;
import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;

@Service("servicesManager")
public class ServicesManagerImpl implements ServicesManager {
	@Autowired
	private JugadorManager jugadorManager;
	@Autowired
	private ClubManager clubManager;

	@Override
	public Jugador addJugador(Jugador jugador) {
		return jugadorManager.addJugador(jugador);
	}

	@Override
	public List<Jugador> getJugadores() {
		return jugadorManager.getJugadores();
	}

	@Override
	public void deleteJugador(Integer id) {
		Jugador jugador = getJugadorById(id);
		if (jugador != null) {// jugador valido
			jugadorManager.deleteJugador(jugador);
		}
	}

	public Jugador getJugadorById(Integer id) {
		return jugadorManager.getJugadorById(id);
	}

	@Override
	public List<Club> getClubes() {
		return clubManager.getClubes();
	}

	@Override
	public Club addClub(Club club) {
		return clubManager.addClub(club);
	}

	@Override
	public void deleteClub(Integer id) {
		clubManager.deleteClub(id);
	}

	@Override
	public Club getClub(String id) {
		try {
			Integer intId = Integer.parseInt(id);
			return clubManager.getClub(intId);
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

}

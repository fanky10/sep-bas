package com.genfersco.sepbas.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Jugador;

@Service("servicesManager")
public class ServicesManagerImpl implements ServicesManager {
	@Autowired
	private JugadorManager jugadorManager;

	@Override
	public Jugador addJugador(Jugador jugador) {
		return jugadorManager.addJugador(jugador);
	}

	@Override
	public List<Jugador> getJugadores() {
		return jugadorManager.getJugadores();
	}

}

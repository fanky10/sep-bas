package com.genfersco.sepbas.app.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.repository.JugadorRepository;

@Service("jugadorManager")
public class JugadorManagerImpl implements JugadorManager {

	@Autowired
	private JugadorRepository jugadorRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Jugador> getJugadores() {
		return jugadorRepository.findAll();
	}

	@Override
	public Jugador addJugador(Jugador jugador) {
		Jugador saved = jugadorRepository.save(jugador);
		return saved;
	}
}

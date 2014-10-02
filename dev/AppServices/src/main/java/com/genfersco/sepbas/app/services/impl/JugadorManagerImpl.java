package com.genfersco.sepbas.app.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.domain.model.EstadoJugador;
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
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT jugadores FROM Jugador jugadores WHERE jugadores.estado = :estadoJugador");
		Query query = getEntityManager().createQuery(sb.toString());
		 query.setParameter("estadoJugador", EstadoJugador.HABILITADO);
		return query.getResultList();
	}

	@Override
	public Jugador addJugador(Jugador jugador) {
		Jugador saved = jugadorRepository.save(jugador);
		return saved;
	}

	@Override
	public void deleteJugador(Jugador jugador) {
		jugador.setEstado(EstadoJugador.DESHABILITADO);
		jugadorRepository.save(jugador);
	}

	@Override
	public Jugador getJugadorById(Integer id) {
		return jugadorRepository.findOne(id);
	}

	@Override
	public List<Jugador> getJugadoresClub(Integer clubId) {
		if(clubId==null){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT jugadores FROM Jugador jugadores WHERE jugadores.club.id = :clubId");
		Query query = getEntityManager().createQuery(sb.toString());
		query.setParameter("clubId", clubId);
		return query.getResultList();
		
	}

	public JugadorRepository getJugadorRepository() {
		return jugadorRepository;
	}

	public void setJugadorRepository(JugadorRepository jugadorRepository) {
		this.jugadorRepository = jugadorRepository;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}

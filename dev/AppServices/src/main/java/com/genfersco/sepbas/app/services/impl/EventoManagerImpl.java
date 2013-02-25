package com.genfersco.sepbas.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.EventoManager;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.repository.EventoRepository;

@Service("eventoManager")
public class EventoManagerImpl implements EventoManager {
	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public Evento addEvento(Evento evento) {
		return getEventoRepository().save(evento);
	}

	public EventoRepository getEventoRepository() {
		return eventoRepository;
	}

	public void setEventoRepository(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

}

package com.genfersco.sepbas.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.PartidoManager;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.PartidoRepository;

@Service("equipoManager")
public class PartidoManagerImpl implements PartidoManager {
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Override
	public Partido savePartido(Partido partido) {
		return getPartidoRepository().save(partido);
	}

	@Override
	public Partido getPartidoActual() {
		// TODO select whatever..
		return null;
	}

	public PartidoRepository getPartidoRepository() {
		return partidoRepository;
	}

	public void setPartidoRepository(PartidoRepository partidoRepository) {
		this.partidoRepository = partidoRepository;
	}
	
}

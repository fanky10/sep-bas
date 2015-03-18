package com.genfersco.sepbas.app.services;

import com.genfersco.sepbas.domain.model.Partido;

public interface PartidoManager {
	public Partido savePartido(Partido partido);
	public Partido getPartidoActual();
}

package com.genfersco.sepbas.app.services;

import com.genfersco.sepbas.domain.model.Partido;
import java.util.List;

public interface PartidoManager {
	public Partido savePartido(Partido partido);
	public Partido getPartidoActual();
        public List<Partido> getPartidos();
}

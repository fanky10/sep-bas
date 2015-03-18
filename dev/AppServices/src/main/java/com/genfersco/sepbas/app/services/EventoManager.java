package com.genfersco.sepbas.app.services;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Evento;
import java.util.List;

public interface EventoManager {

    public Evento addEvento(Evento evento);

    public List<Evento> findEventosByCuarto(Cuarto cuarto);
}

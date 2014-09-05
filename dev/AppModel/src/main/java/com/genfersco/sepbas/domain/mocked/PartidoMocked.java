package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoMocked {
        @Autowired
        private PartidoRepository partidoRepository;
	public Partido getPartido(){
		Partido partido = new Partido();
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido.setResultadoLocal(11);
		partido.setResultadoVisitante(111);
                partido = partidoRepository.save(partido);
		return partido;
	}
}

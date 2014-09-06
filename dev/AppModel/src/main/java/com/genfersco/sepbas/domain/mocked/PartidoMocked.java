package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.PartidoRepository;

@Component
public class PartidoMocked {
	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private ClubMocked clubMocked;

	public Partido getPartido() {
		Club clubVisitante = clubMocked.getClub("Cachitos", "Arequito");
		Club clubLocal = clubMocked.getClub("Cachitos", "Funes");
		
		Partido partido = new Partido();
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido.setResultadoLocal(11);
		partido.setResultadoVisitante(111);
		partido.setClubLocal(clubLocal);
		partido.setClubVisitante(clubVisitante);
		partido = partidoRepository.save(partido);
		return partido;
	}
}

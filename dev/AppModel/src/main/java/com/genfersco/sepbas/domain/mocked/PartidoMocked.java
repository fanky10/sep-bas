package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Partido;

public class PartidoMocked {
	public static Partido getPartido(){
		Partido partido = new Partido();
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido.setResultadoLocal(11);
		partido.setResultadoVisitante(111);
		return partido;
	}
	public static Partido getPartido(Club clubLocal,Club clubVisitante){
		Partido partido = new Partido();
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido.setClubLocal(clubLocal);
		partido.setClubVisitante(clubVisitante);
		partido.setResultadoLocal(11);
		partido.setResultadoVisitante(111);
		return partido;
	}
}

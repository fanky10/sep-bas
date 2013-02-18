package com.genfersco.sepbas.domain.mocked;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Partido;

public class CuartoMocked {
	public static Cuarto getCuarto(Partido partido){
		Cuarto cuarto = new Cuarto();
		cuarto.setNumero(2);
		cuarto.setPartido(partido);
		return cuarto;
	}
}

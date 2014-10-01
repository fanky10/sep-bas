package com.genfersco.sepbas.domain.mocked;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.repository.CuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CuartoMocked {

	@Autowired
	private CuartoRepository cuartoRepository;
	@Autowired
	private PartidoMocked partidoMocked;

	public Cuarto getCuarto() {
		Cuarto cuarto = new Cuarto();
		cuarto.setNumero(2);
		cuarto.setPartido(partidoMocked.getPartido());
		cuarto = cuartoRepository.save(cuarto);
		return cuarto;
	}
}

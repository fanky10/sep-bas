package com.genfersco.sepbas.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.CuartoManager;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.repository.CuartoRepository;

@Service("cuartoManager")
public class CuartoManagerImpl implements CuartoManager{
	@Autowired
	private CuartoRepository cuartoRepository;
	
	@Override
	public Cuarto addCuarto(Cuarto cuarto) {
		return getCuartoRepository().save(cuarto);
	}

	public CuartoRepository getCuartoRepository() {
		return cuartoRepository;
	}

	public void setCuartoRepository(CuartoRepository cuartoRepository) {
		this.cuartoRepository = cuartoRepository;
	}
	
}

package com.genfersco.sepbas.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.ArbitroManager;
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.repository.ArbitroRepository;
@Service("arbitroManager")
public class ArbitroManagerImpl implements ArbitroManager{
	
	@Autowired
	private ArbitroRepository arbitroRepository;

	@Override
	public List<Arbitro> getArbitrosHabilitados() {
		return arbitroRepository.findAll();
	}

}

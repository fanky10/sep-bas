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

    @Override
    public Arbitro addArbitro(Arbitro arbitro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteArbitro(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Arbitro getArbitro(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

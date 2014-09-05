package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Arbitro;

public interface ArbitroManager {
	public List<Arbitro> getArbitrosHabilitados();
        
        public Arbitro addArbitro(Arbitro arbitro);
        
        public void deleteArbitro(Integer id);
	
	public Arbitro getArbitro(Integer id);
}

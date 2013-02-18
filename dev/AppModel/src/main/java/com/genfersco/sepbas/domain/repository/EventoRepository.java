package com.genfersco.sepbas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genfersco.sepbas.domain.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
}

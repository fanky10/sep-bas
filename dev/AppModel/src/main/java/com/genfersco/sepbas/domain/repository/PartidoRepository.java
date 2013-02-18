package com.genfersco.sepbas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genfersco.sepbas.domain.model.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer>{

}

package com.genfersco.sepbas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genfersco.sepbas.domain.model.Arbitro;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Integer> {

}
package com.genfersco.sepbas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genfersco.sepbas.domain.model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

}
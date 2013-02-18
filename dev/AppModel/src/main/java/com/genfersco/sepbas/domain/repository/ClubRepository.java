package com.genfersco.sepbas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genfersco.sepbas.domain.model.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {

}
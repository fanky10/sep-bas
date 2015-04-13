package com.genfersco.sepbas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genfersco.sepbas.domain.model.Partido;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    @Query("SELECT p FROM Partido p ORDER BY p.id desc LIMIT 1")
    public List<Partido> findLastPartido();
}

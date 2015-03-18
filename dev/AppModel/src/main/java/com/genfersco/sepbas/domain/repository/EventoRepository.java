package com.genfersco.sepbas.domain.repository;

import com.genfersco.sepbas.domain.model.Cuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genfersco.sepbas.domain.model.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	@Query
        public List<Evento> findByCuarto(Cuarto c);
}

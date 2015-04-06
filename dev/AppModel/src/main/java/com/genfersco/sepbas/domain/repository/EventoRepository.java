package com.genfersco.sepbas.domain.repository;

import com.genfersco.sepbas.domain.model.Cuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genfersco.sepbas.domain.model.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	@Query("SELECT e FROM Evento e WHERE e.cuarto = :cuarto and e.estado = com.genfersco.sepbas.domain.model.EstadoEvento.NO_ELIMINADO")
        public List<Evento> findByCuarto(@Param("cuarto") Cuarto c);
}

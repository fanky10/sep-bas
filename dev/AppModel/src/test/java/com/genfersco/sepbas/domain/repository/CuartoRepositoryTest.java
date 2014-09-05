package com.genfersco.sepbas.domain.repository;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Partido;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class CuartoRepositoryTest {
	@Autowired
	private CuartoRepository cuartoRepository;
	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private ClubRepository clubRepository;

	private Cuarto cuarto = new Cuarto();

	@Before
	public void buildData() {
		Club clubVisitante = new Club();
		clubVisitante.setNombre("Visitante");
                clubVisitante.setLocalidad("Arequito");
		clubVisitante = clubRepository.save(clubVisitante);
		
		Club clubLocal = new Club();
		clubLocal.setNombre("Local");
                clubLocal.setLocalidad("Rosario");
		clubLocal = clubRepository.save(clubLocal);
		
		Partido partido = new Partido();
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido.setClubVisitante(clubVisitante);
		partido.setClubLocal(clubLocal);
		partido.setResultadoLocal(11);
		partido.setResultadoVisitante(111);
		partido = partidoRepository.save(partido);

		cuarto.setNumero(2);
		cuarto.setPartido(partido);
		cuarto = cuartoRepository.save(cuarto);
	}

	@Test
	public void testGuardarCuarto() {
		assertTrue(cuartoRepository.count() > 0);
		assertTrue(cuartoRepository.exists(cuarto.getId()));
	}

}

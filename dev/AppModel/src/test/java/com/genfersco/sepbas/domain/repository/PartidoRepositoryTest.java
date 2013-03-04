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

import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Partido;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class PartidoRepositoryTest {
	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private ClubRepository clubRepository;
	
	private Partido partido = new Partido();
	private Club clubLocal = new Club();
	private Club clubVisitante = new Club();
	
	@Before
	public void buildData(){
		clubLocal = clubRepository.save(ClubMocked.getClub());
		clubVisitante = clubRepository.save(ClubMocked.getClub());
		
		partido.setClubLocal(clubLocal);
		partido.setClubVisitante(clubVisitante);
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido.setResultadoLocal(10);
		partido.setResultadoVisitante(20);
		
		partido = partidoRepository.save(partido);
	}
	@Test
	public void testGuardarPartido(){
		assertTrue(partidoRepository.count()>0);
		assertTrue(partidoRepository.exists(partido.getId()));
	}
	
}

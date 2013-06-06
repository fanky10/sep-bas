package com.genfersco.sepbas.domain.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.model.Arbitro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class ArbitroRepositoryTest {

	@Autowired
	private ArbitroRepository arbitroRepository;
	private Arbitro arbitro = new Arbitro();

	@Before
	public void buildData() {		
		arbitro.setNombre("Pepe");
		arbitro.setApellido("Gonzalez");
		arbitro = arbitroRepository.save(arbitro);
	}

	@Test
	public void testGuardarClub() {
		assertTrue(arbitroRepository.count() > 0);
		assertTrue(arbitroRepository.exists(arbitro.getId()));
	}
}

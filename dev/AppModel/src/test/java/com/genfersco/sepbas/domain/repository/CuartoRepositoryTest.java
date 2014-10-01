package com.genfersco.sepbas.domain.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.mocked.CuartoMocked;
import com.genfersco.sepbas.domain.model.Cuarto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class CuartoRepositoryTest {
	@Autowired
	private CuartoRepository cuartoRepository;
	@Autowired
	private CuartoMocked cuartoMocked;

	private Cuarto cuarto = new Cuarto();

	@Before
	public void buildData() {
		cuarto = cuartoMocked.getCuarto();
	}

	@Test
	public void testGuardarCuarto() {
		assertTrue(cuartoRepository.count() > 0);
		assertTrue(cuartoRepository.exists(cuarto.getId()));
	}

}

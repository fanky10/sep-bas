package com.genfersco.sepbas.domain.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.model.Club;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml" })
@Transactional
public class ClubRepositoryTest {
	private Club club = new Club();
	
	@Autowired
	private ClubRepository clubRepository;
	@Autowired
	private ClubMocked clubMocked;
	
	@Before
	public void buildData(){
		club = clubMocked.getClub();
	}
	
	@Test
	public void testGuardarClub(){
		assertTrue(clubRepository.count()>0);
		assertTrue(clubRepository.exists(club.getId()));
	}
}

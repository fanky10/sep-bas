package com.genfersco.sepbas.domain.repository;

import com.genfersco.sepbas.domain.mocked.ArbitroMocked;
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
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Partido;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml"})
@Transactional
public class PartidoRepositoryTest {

    @Autowired
    private PartidoRepository partidoRepository;
    @Autowired
    private ClubMocked clubMocked;
    @Autowired
    private ArbitroMocked arbitroMocked;

    private Partido partido = new Partido();
    private Club clubLocal = new Club();
    private Club clubVisitante = new Club();

    @Before
    public void buildData() {
        clubLocal = clubMocked.getClub();
        clubVisitante = clubMocked.getClub("San Telmo", "Funes", true);
        Arbitro arbitro = arbitroMocked.getArbitro();

        partido.setClubLocal(clubLocal);
        partido.setClubVisitante(clubVisitante);
        partido.setFecha(new Date(System.currentTimeMillis()));
        partido.setResultadoLocal(10);
        partido.setResultadoVisitante(20);
        partido.setArbitro(arbitro);

        partido = partidoRepository.save(partido);
    }

    @Test
    public void testGuardarPartido() {
        assertTrue(partidoRepository.count() > 0);
        assertTrue(partidoRepository.exists(partido.getId()));
    }

    @Test
    public void testFindLastPartido() {
        Integer savedId = partido.getId();
        List<Partido> lastest = partidoRepository.findLastPartido();
        assertTrue(!lastest.isEmpty() && lastest.get(0).getId() > 0);
        assertTrue(savedId.equals(lastest.get(0).getId()));
    }

}

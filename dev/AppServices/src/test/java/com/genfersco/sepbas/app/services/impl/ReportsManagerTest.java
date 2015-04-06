/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.impl;

import com.genfersco.sepbas.app.services.ReportsManager;
import com.genfersco.sepbas.app.services.vo.CuartoReportVO;
import com.genfersco.sepbas.app.services.vo.PartidoReportVO;
import com.genfersco.sepbas.domain.mocked.ArbitroMocked;
import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.CuartoRepository;
import com.genfersco.sepbas.domain.repository.PartidoRepository;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Facundo Scoccia <fanky10@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml"})
@Transactional
public class ReportsManagerTest {

    @Autowired
    private CuartoRepository cuartoRepository;
    @Autowired
    private PartidoRepository partidoRepository;
    @Autowired
    private ClubMocked clubMocked;
    @Autowired
    private ArbitroMocked arbitroMocked;
    @Autowired
    private ReportsManager reportsManager;

    private Partido partido = new Partido();

    @Before
    public void buildData() {
        Club clubLocal = clubMocked.getClub();
        Club clubVisitante = clubMocked.getClub("San Telmo", "Funes", true);
        Arbitro arbitro = arbitroMocked.getArbitro();

        partido.setClubLocal(clubLocal);
        partido.setClubVisitante(clubVisitante);
        partido.setFecha(new Date(System.currentTimeMillis()));
        partido.setResultadoLocal(10);
        partido.setResultadoVisitante(20);
        partido.setArbitro(arbitro);
        partido = partidoRepository.save(partido);

        Cuarto primerCuarto = new Cuarto();
        primerCuarto.setNumero(1);
        primerCuarto.setPartido(partido);
        cuartoRepository.save(primerCuarto);
    }

    @Test
    public void testGetCuartosReport() {
        List<CuartoReportVO> cuartosReportVO = reportsManager.getCuartosReport(partido.getId());
        assertTrue(cuartosReportVO != null && !cuartosReportVO.isEmpty());
    }

    @Test
    public void testGetPartidoReport() {
        PartidoReportVO partidoReport = reportsManager.getPartidoReport(partido.getId());
        assertTrue(partidoReport != null);
        assertTrue(!partidoReport.getCuartos().isEmpty());
    }
}

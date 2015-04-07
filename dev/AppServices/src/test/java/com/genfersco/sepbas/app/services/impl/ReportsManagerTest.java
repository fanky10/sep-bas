/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.impl;

import com.genfersco.sepbas.app.services.ReportsManager;
import com.genfersco.sepbas.app.services.vo.CuartoReportVO;
import com.genfersco.sepbas.app.services.vo.PartidoReportVO;
import com.genfersco.sepbas.app.services.vo.ReporteJugadorVO;
import com.genfersco.sepbas.domain.mocked.ArbitroMocked;
import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.mocked.EventoMocked;
import com.genfersco.sepbas.domain.mocked.JugadorMocked;
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.model.TipoEvento;
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
    @Autowired
    private JugadorMocked jugadorMocked;
    @Autowired
    private EventoMocked eventoMocked;

    private Partido partido = new Partido();
    private Cuarto primerCuarto = new Cuarto();
    private Cuarto segundoCuarto = new Cuarto();

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

        primerCuarto.setNumero(1);
        primerCuarto.setPartido(partido);
        primerCuarto = cuartoRepository.save(primerCuarto);
        
        segundoCuarto.setNumero(2);
        segundoCuarto.setPartido(partido);
        segundoCuarto = cuartoRepository.save(segundoCuarto);
    }

    @Test
    public void testGetCuartosReport() {
        Jugador jugadorLocal = jugadorMocked.getJugador(partido.getClubLocal(), true);
        Jugador jugadorVisitante = jugadorMocked.getJugador(partido.getClubVisitante(), true);

        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS, jugadorLocal);
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_DOS_PUNTOS, jugadorVisitante);
        
        List<CuartoReportVO> cuartosReportVO = reportsManager.getCuartosReport(partido.getId());
        assertTrue(cuartosReportVO != null && !cuartosReportVO.isEmpty());
        assertTrue(cuartosReportVO.size() == 2);
        assertTrue(cuartosReportVO.get(0).getResultadoLocal() == 3);
        assertTrue(cuartosReportVO.get(0).getResultadoVisitante() == 2);
    }

    @Test
    public void testGetPartidoReport() {
        PartidoReportVO partidoReport = reportsManager.getPartidoReport(partido.getId());
        assertTrue(partidoReport != null);
        assertTrue(!partidoReport.getCuartos().isEmpty());
    }
    
    @Test
    public void testGetReporteJugadoresByPartidoAndCuarto() {
        Jugador jugadorLocal = jugadorMocked.getJugador(partido.getClubLocal(), true);
        Jugador jugadorVisitante = jugadorMocked.getJugador(partido.getClubVisitante(), true);
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS, jugadorLocal);
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS, jugadorLocal);
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_DOS_PUNTOS, jugadorVisitante);
        
        List<ReporteJugadorVO> reporteJugadores = reportsManager.getReporteJugadoresPorCuarto(partido.getId(), primerCuarto.getId());
        assertTrue(reporteJugadores != null);
        assertTrue(!reporteJugadores.isEmpty());
        assertTrue(reporteJugadores.size() == 2);
        for(ReporteJugadorVO rjvo : reporteJugadores) {
            if(rjvo.getJugador().getId().equals(jugadorLocal.getId())) {
                assertTrue(rjvo.getCantidadTriples() == 2);
            }
            
            if(rjvo.getJugador().getId().equals(jugadorVisitante.getId())) {
                assertTrue(rjvo.getCantidadDobles() == 1);
            }
        }
    }
    
    @Test
    public void testGetReporteJugadoresByPartido() {
        Jugador jugadorLocal = jugadorMocked.getJugador(partido.getClubLocal(), true);
        Jugador jugadorVisitante = jugadorMocked.getJugador(partido.getClubVisitante(), true);
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS, jugadorLocal);
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS, jugadorLocal);
        eventoMocked.getEvento(segundoCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS, jugadorLocal);
        
        eventoMocked.getEvento(primerCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_DOS_PUNTOS, jugadorVisitante);
        eventoMocked.getEvento(segundoCuarto, null, TipoEvento.LANZAMIENTO_JUGADOR_DOS_PUNTOS, jugadorVisitante);
        
        List<ReporteJugadorVO> reporteJugadores = reportsManager.getReporteJugadoresPorCuarto(partido.getId(), null);
        assertTrue(reporteJugadores != null);
        assertTrue(!reporteJugadores.isEmpty());
        assertTrue(reporteJugadores.size() == 2);
        for(ReporteJugadorVO rjvo : reporteJugadores) {
            if(rjvo.getJugador().getId().equals(jugadorLocal.getId())) {
                assertTrue(rjvo.getCantidadTriples() == 3);
            }
            
            if(rjvo.getJugador().getId().equals(jugadorVisitante.getId())) {
                assertTrue(rjvo.getCantidadDobles() == 2);
            }
        }
    }
}

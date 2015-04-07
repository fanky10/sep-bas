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
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.PartidoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fanky10
 */
@Service("reportsManager")
public class ReportsManagerImpl implements ReportsManager {

    @Autowired
    private PartidoRepository partidoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PartidoReportVO getPartidoReport(Integer partidoId) {
        PartidoReportVO partidoReportVO = new PartidoReportVO();
        Partido partido = partidoRepository.findOne(partidoId);
        List<CuartoReportVO> cuartos = this.getCuartosReport(partidoId);

        partidoReportVO.setCuartos(cuartos);
        partidoReportVO.setPartido(partido);

        return partidoReportVO;
    }

    @Override
    public List<CuartoReportVO> getCuartosReport(Integer partidoId) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c.cuarto_id, c.cuarto_numero,");
        sb.append(" COALESCE((select sum(lanzamientosDobles) * 2 + sum(lanzamientosTriples) * 3 + sum(lanzamientosSimples) as totalPuntos from reporte_jugadores rj inner join jugadores j on j.jugador_id = rj.jugador_id where jugador_actual_club_id = p.partido_local_club_id AND rj.cuarto_id = c.cuarto_id),0) totalClubLocal,");
        sb.append(" COALESCE((select sum(lanzamientosDobles) * 2 + sum(lanzamientosTriples) * 3 + sum(lanzamientosSimples) as totalPuntos from reporte_jugadores rj inner join jugadores j on j.jugador_id = rj.jugador_id where jugador_actual_club_id = p.partido_visitante_club_id AND rj.cuarto_id = c.cuarto_id),0) totalClubVisitante");
        sb.append(" FROM cuartos c ");
        sb.append(" INNER JOIN partidos p ON p.partido_id = c.cuarto_partido_id");
        sb.append(" WHERE p.partido_id = :partidoId");
        sb.append(" GROUP BY cuarto_id");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("partidoId", partidoId);

        List<Object[]> result = query.getResultList();
        List<CuartoReportVO> cuartoReport = new ArrayList<CuartoReportVO>();
        for (Object[] row : result) {
            cuartoReport.add(new CuartoReportVO(Integer.valueOf(row[0].toString()), Integer.valueOf(row[1].toString()), Integer.valueOf(row[2].toString()), Integer.valueOf(row[3].toString())));
        }
        return cuartoReport;
    }

    @Override
    public List<ReporteJugadorVO> getReporteJugadoresPorCuarto(Integer partidoId, Integer cuartoId) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT j FROM Evento e");
        sb.append(" JOIN e.jugador j");
        sb.append(" JOIN e.cuarto c");
        sb.append(" WHERE c.partido.id = :partidoId");
        sb.append((cuartoId !=null && cuartoId > 0 ? " AND c.id = :cuartoId" : ""));
        sb.append(" GROUP BY e.jugador");
        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("partidoId", partidoId);
        if(cuartoId != null && cuartoId > 0) {
            query.setParameter("cuartoId", cuartoId);
        }

        List<Jugador> jugadoresConEventos = query.getResultList();

        sb = new StringBuilder();
        sb.append("SELECT rj.jugador_id, sum(lanzamientosSimples), sum(lanzamientosDobles), sum(lanzamientosTriples), sum(asistencias), sum(faltas) ");
        sb.append(" FROM reporte_jugadores rj");
        sb.append(" INNER JOIN cuartos c ON c.cuarto_id = rj.cuarto_id");
        sb.append(" INNER JOIN partidos p ON p.partido_id = c.cuarto_partido_id");
        sb.append(" WHERE p.partido_id = :partidoId AND c.cuarto_id = :cuartoId");
        sb.append(" GROUP BY rj.jugador_id");
        query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("partidoId", partidoId);
        query.setParameter("cuartoId", cuartoId);
        List<Object[]> reporteList = query.getResultList();

        List<ReporteJugadorVO> reporteJugadores = new ArrayList<ReporteJugadorVO>();
        for (Object[] row : reporteList) {
            for (Jugador j : jugadoresConEventos) {
                Integer jugadorId = Integer.valueOf(row[0].toString());
                Integer simples = Integer.valueOf(row[1].toString());
                Integer dobles = Integer.valueOf(row[2].toString());
                Integer triples = Integer.valueOf(row[3].toString());
                Integer asistencias = Integer.valueOf(row[4].toString());
                Integer faltas = Integer.valueOf(row[5].toString());

                if (j.getId().equals(jugadorId)) {
                    reporteJugadores.add(new ReporteJugadorVO(j, simples, dobles, triples, asistencias, faltas));
                }
            }
        }

        return reporteJugadores;
    }

}

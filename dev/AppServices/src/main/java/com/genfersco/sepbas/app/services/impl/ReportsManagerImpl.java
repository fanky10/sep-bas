/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.impl;

import com.genfersco.sepbas.app.services.ReportsManager;
import com.genfersco.sepbas.app.services.vo.CuartoReportVO;
import com.genfersco.sepbas.app.services.vo.PartidoReportVO;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.PartidoRepository;
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
        sb.append("SELECT NEW com.genfersco.sepbas.app.services.vo.CuartoReportVO(c.id,c.numero,10,12) FROM Cuarto c");
        sb.append(" WHERE c.partido.id = :partidoId");

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("partidoId", partidoId);

        List<CuartoReportVO> report = query.getResultList();

        return report;
    }

}

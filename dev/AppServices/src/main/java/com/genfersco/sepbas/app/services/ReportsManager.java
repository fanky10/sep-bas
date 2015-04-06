/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services;

import com.genfersco.sepbas.app.services.vo.CuartoReportVO;
import com.genfersco.sepbas.app.services.vo.PartidoReportVO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fanky10
 */
public interface ReportsManager {

    public PartidoReportVO getPartidoReport(Integer partidoId);

    public List<CuartoReportVO> getCuartosReport(Integer partidoId);

    public Map<String, Integer> getResultadoPorCuarto(Integer partidoId, Integer cuartoId);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.vo;

import com.genfersco.sepbas.domain.model.Partido;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author developer
 */
public class PartidoReportVO implements Serializable {

    private Partido partido;
    private List<CuartoReportVO> cuartos;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public List<CuartoReportVO> getCuartos() {
        return cuartos;
    }

    public void setCuartos(List<CuartoReportVO> cuartos) {
        this.cuartos = cuartos;
    }
    
    
}

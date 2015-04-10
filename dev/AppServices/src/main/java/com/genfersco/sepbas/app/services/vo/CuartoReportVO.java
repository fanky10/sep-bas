/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.vo;

import java.io.Serializable;

/**
 *
 * @author fanky10
 */
public class CuartoReportVO implements Serializable {

    private Integer id;
    private Integer numero;
    private Integer resultadoLocal;
    private Integer resultadoVisitante;
    
    public CuartoReportVO() {
    }

    public CuartoReportVO(Integer id, Integer numero, Integer resultadoLocal, Integer resultadoVisitante) {
        this.id = id;
        this.numero = numero;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(Integer resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public Integer getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(Integer resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }
    
    
}

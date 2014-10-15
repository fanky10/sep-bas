/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.web.form;

import java.util.List;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 *
 * @author fanky
 */
public class InicioPartidoData {
    private Integer idClubLocal;
    private Integer idClubVisitante;
    private Integer idArbitro;
    private List<Integer> idJugadoresLocales;
    private List<Integer> idJugadoresVisitantes;
    
    public Integer getClubLocal() {
        return idClubLocal;
    }

    public void setClubLocal(Integer clubLocal) {
        this.idClubLocal = clubLocal;
    }

    public Integer getClubVisitante() {
        return idClubVisitante;
    }

    public void setClubVisitante(Integer clubVisitante) {
        this.idClubVisitante = clubVisitante;
    }

    public Integer getIdClubLocal() {
        return idClubLocal;
    }

    public void setIdClubLocal(Integer idClubLocal) {
        this.idClubLocal = idClubLocal;
    }

    public Integer getIdClubVisitante() {
        return idClubVisitante;
    }

    public void setIdClubVisitante(Integer idClubVisitante) {
        this.idClubVisitante = idClubVisitante;
    }

    public Integer getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
    }

    public List<Integer> getIdJugadoresLocales() {
        return idJugadoresLocales;
    }

    public void setIdJugadoresLocales(List<Integer> idJugadoresLocales) {
        this.idJugadoresLocales = idJugadoresLocales;
    }

    public List<Integer> getIdJugadoresVisitantes() {
        return idJugadoresVisitantes;
    }

    public void setIdJugadoresVisitantes(List<Integer> idJugadoresVisitantes) {
        this.idJugadoresVisitantes = idJugadoresVisitantes;
    }
    
    
    
}

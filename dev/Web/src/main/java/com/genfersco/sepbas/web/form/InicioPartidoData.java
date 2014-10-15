/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.web.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 *
 * @author fanky
 */
@JsonPropertyOrder({ "idClubLocal","idClubVisitante","idArbitro","idJugadoresLocales","idJugadoresVisitantes" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class InicioPartidoData implements Serializable {

    private Integer idClubLocal = 0;
    private Integer idClubVisitante = 0;
    private Integer idArbitro = 0;
    private List<Integer> idJugadoresLocales = new ArrayList<Integer>();
    private List<Integer> idJugadoresVisitantes = new ArrayList<Integer>();
    
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

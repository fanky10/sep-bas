/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.dto;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fanky
 */
public class PartidoSession implements Serializable {

    private Partido partido;
    private List<Jugador> jugadoresLocalesDisponibles;
    private List<Jugador> jugadoresVisitantesDisponibles;
    private List<Jugador> jugadoresLocalesSeleccionados;
    private List<Jugador> jugadoresVisitantesSeleccionados;
    private Cuarto cuarto;

    public Cuarto getCuarto() {
        return cuarto;
    }

    public void setCuarto(Cuarto cuarto) {
        this.cuarto = cuarto;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public List<Jugador> getJugadoresLocalesDisponibles() {
        return jugadoresLocalesDisponibles;
    }

    public void setJugadoresLocalesDisponibles(List<Jugador> jugadoresLocalesDisponibles) {
        this.jugadoresLocalesDisponibles = jugadoresLocalesDisponibles;
    }

    public List<Jugador> getJugadoresVisitantesDisponibles() {
        return jugadoresVisitantesDisponibles;
    }

    public void setJugadoresVisitantesDisponibles(List<Jugador> jugadoresVisitantesDisponibles) {
        this.jugadoresVisitantesDisponibles = jugadoresVisitantesDisponibles;
    }

    public List<Jugador> getJugadoresLocalesSeleccionados() {
        return jugadoresLocalesSeleccionados;
    }

    public void setJugadoresLocalesSeleccionados(List<Jugador> jugadoresLocalesSeleccionados) {
        this.jugadoresLocalesSeleccionados = jugadoresLocalesSeleccionados;
    }

    public List<Jugador> getJugadoresVisitantesSeleccionados() {
        return jugadoresVisitantesSeleccionados;
    }

    public void setJugadoresVisitantesSeleccionados(List<Jugador> jugadoresVisitantesSeleccionados) {
        this.jugadoresVisitantesSeleccionados = jugadoresVisitantesSeleccionados;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.vo;

import com.genfersco.sepbas.domain.model.Jugador;
import java.io.Serializable;

/**
 *
 * @author fanky
 */
public class ReporteJugadorVO implements Serializable {

    private Jugador jugador;
    private Integer cantidadSimples;
    private Integer cantidadDobles;
    private Integer cantidadTriples;
    private Integer cantidadAsistencias;
    private Integer cantidadFaltas;

    public ReporteJugadorVO(Jugador jugador, Integer cantidadSimples, Integer cantidadDobles, Integer cantidadTriples, Integer cantidadAsistencias, Integer cantidadFaltas) {
        this.jugador = jugador;
        this.cantidadSimples = cantidadSimples;
        this.cantidadDobles = cantidadDobles;
        this.cantidadTriples = cantidadTriples;
        this.cantidadAsistencias = cantidadAsistencias;
        this.cantidadFaltas = cantidadFaltas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Integer getCantidadSimples() {
        return cantidadSimples;
    }

    public void setCantidadSimples(Integer cantidadSimples) {
        this.cantidadSimples = cantidadSimples;
    }

    public Integer getCantidadDobles() {
        return cantidadDobles;
    }

    public void setCantidadDobles(Integer cantidadDobles) {
        this.cantidadDobles = cantidadDobles;
    }

    public Integer getCantidadTriples() {
        return cantidadTriples;
    }

    public void setCantidadTriples(Integer cantidadTriples) {
        this.cantidadTriples = cantidadTriples;
    }

    public Integer getCantidadAsistencias() {
        return cantidadAsistencias;
    }

    public void setCantidadAsistencias(Integer cantidadAsistencias) {
        this.cantidadAsistencias = cantidadAsistencias;
    }

    public Integer getCantidadFaltas() {
        return cantidadFaltas;
    }

    public void setCantidadFaltas(Integer cantidadFaltas) {
        this.cantidadFaltas = cantidadFaltas;
    }
    
    
}

package com.genfersco.sepbas.web.form;

import java.io.Serializable;

import com.genfersco.sepbas.domain.model.Jugador;

public class IniciaCuartoForm implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2922727765877387400L;
    private Jugador[] jugadoresLocales;
    private Jugador[] jugadoresVisitantes;
    private Integer cuartoNumero;

    public Integer getCuartoNumero() {
        return cuartoNumero;
    }

    public void setCuartoNumero(Integer cuartoNumero) {
        this.cuartoNumero = cuartoNumero;
    }

    public Jugador[] getJugadoresLocales() {
        return jugadoresLocales;
    }

    public void setJugadoresLocales(Jugador[] jugadoresLocales) {
        this.jugadoresLocales = jugadoresLocales;
    }

    public Jugador[] getJugadoresVisitantes() {
        return jugadoresVisitantes;
    }

    public void setJugadoresVisitantes(Jugador[] jugadoresVisitantes) {
        this.jugadoresVisitantes = jugadoresVisitantes;
    }

}

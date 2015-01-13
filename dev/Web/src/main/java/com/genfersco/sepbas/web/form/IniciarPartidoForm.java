package com.genfersco.sepbas.web.form;

import com.genfersco.sepbas.domain.model.Arbitro;
import java.io.Serializable;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;

public class IniciarPartidoForm implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4460858768271240578L;
    private Club clubLocal;
    private Club clubVisitante;
    private Arbitro arbitro;
    private Jugador[] jugadoresLocales;
    private Jugador[] jugadoresVisitantes;

    @Override
    public String toString() {
        return String.format("arbitro: %s local: %s - %s -- visitante: %s %s", arbitro, clubLocal, jugadoresLocales, clubVisitante, jugadoresVisitantes);
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
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

    public Club getClubLocal() {
        return clubLocal;
    }

    public void setClubLocal(Club clubLocal) {
        this.clubLocal = clubLocal;
    }

    public Club getClubVisitante() {
        return clubVisitante;
    }

    public void setClubVisitante(Club clubVisitante) {
        this.clubVisitante = clubVisitante;
    }
}

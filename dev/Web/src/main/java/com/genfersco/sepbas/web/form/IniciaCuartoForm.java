package com.genfersco.sepbas.web.form;

import java.io.Serializable;

import com.genfersco.sepbas.domain.model.Jugador;

public class IniciaCuartoForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2922727765877387400L;
	private Jugador[] jugadoresEquipo1;
	private Jugador[] jugadoresEquipo2;

	public Jugador[] getJugadoresEquipo1() {
		return jugadoresEquipo1;
	}

	public void setJugadoresEquipo1(Jugador[] jugadoresEquipo1) {
		this.jugadoresEquipo1 = jugadoresEquipo1;
	}

	public Jugador[] getJugadoresEquipo2() {
		return jugadoresEquipo2;
	}

	public void setJugadoresEquipo2(Jugador[] jugadoresEquipo2) {
		this.jugadoresEquipo2 = jugadoresEquipo2;
	}

}

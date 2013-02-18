package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.EstadoJugador;
import com.genfersco.sepbas.domain.model.Jugador;

public class JugadorMocked {
	public static Jugador getJugador(Club club){
		Jugador  jugador = new Jugador();
		jugador.setApellido("Gonzalez");
		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
		jugador.setNombre("Cacho");
		jugador.setNumero(2);
		jugador.setClub(club);
		jugador.setEstado(EstadoJugador.HABILITADO);
		return jugador;
	}
}

package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.EstadoJugador;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.repository.JugadorRepository;

@Component
public class JugadorMocked {
	@Autowired
	private JugadorRepository jugadorRepository;
	@Autowired
	private ClubMocked clubMocked;

	public Jugador getJugador() {
		return getJugador(true);
	}

	public Jugador getJugador(boolean saveInstance) {
		return getJugador(clubMocked.getClub(), saveInstance);
	}

	public Jugador getJugador(Club club, boolean saveInstance) {
		Jugador jugador = new Jugador();
		jugador.setApellido("Gonzalez");
		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
		jugador.setNombre("Cacho");
		jugador.setNumero(2);
		jugador.setClub(club);
		jugador.setEstado(EstadoJugador.HABILITADO);
                if (saveInstance) {
			jugador = jugadorRepository.save(jugador);
		}
		return jugador;
	}
}

package com.genfersco.sepbas.domain.mocked;

import java.util.Date;

import com.genfersco.sepbas.domain.model.EstadoJugador;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JugadorMocked {
    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private ClubMocked clubMocked;
	public Jugador getJugador(){
		Jugador  jugador = new Jugador();
		jugador.setApellido("Gonzalez");
		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
		jugador.setNombre("Cacho");
		jugador.setNumero(2);
		jugador.setClub(clubMocked.getClub());
		jugador.setEstado(EstadoJugador.HABILITADO);
                jugador = jugadorRepository.save(jugador);
		return jugador;
	}
}

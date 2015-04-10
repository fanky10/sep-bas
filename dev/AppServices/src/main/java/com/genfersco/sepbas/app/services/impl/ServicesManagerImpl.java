package com.genfersco.sepbas.app.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genfersco.sepbas.app.services.ArbitroManager;
import com.genfersco.sepbas.app.services.ClubManager;
import com.genfersco.sepbas.app.services.CuartoManager;
import com.genfersco.sepbas.app.services.EventoManager;
import com.genfersco.sepbas.app.services.JugadorManager;
import com.genfersco.sepbas.app.services.PartidoManager;
import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.model.TipoEvento;

@Service("servicesManager")
public class ServicesManagerImpl implements ServicesManager {

    @Autowired
    private JugadorManager jugadorManager;
    @Autowired
    private ClubManager clubManager;
    @Autowired
    private PartidoManager partidoManager;
    @Autowired
    private CuartoManager cuartoManager;
    @Autowired
    private EventoManager eventoManager;
    @Autowired
    private ArbitroManager arbitroManager;

    @Override
    public Jugador addJugador(Jugador jugador) {
        return jugadorManager.addJugador(jugador);
    }

    @Override
    public List<Jugador> getJugadores() {
        return jugadorManager.getJugadores();
    }

    @Override
    public void deleteJugador(Integer id) {
        Jugador jugador = getJugadorById(id);
        if (jugador != null) {// jugador valido
            jugadorManager.deleteJugador(jugador);
        }
    }

    public Jugador getJugadorById(Integer id) {
        return jugadorManager.getJugadorById(id);
    }

    @Override
    public List<Club> getClubes() {
        return clubManager.getClubes();
    }

    @Override
    public Club addClub(Club club) {
        return clubManager.addClub(club);
    }

    @Override
    public void deleteClub(Integer id) {
        clubManager.deleteClub(id);
    }

    @Override
    public Club getClub(String id) {
        try {
            Integer intId = Integer.parseInt(id);
            return clubManager.getClub(intId);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    @Override
    public List<Jugador> getJugadoresClub(Integer clubId) {
        if (clubId == null) {
            return null;
        }
        return jugadorManager.getJugadoresClub(clubId);
    }

    @Override
    public Partido savePartido(Partido partido) {
        return partidoManager.savePartido(partido);
    }

    @Override
    public Cuarto addCuarto(Cuarto cuarto, List<Jugador> equipo1,
            List<Jugador> equipo2) {
        //TODO: encapsular esto en un nuevo objeto o algo asi.
        cuarto = cuartoManager.addCuarto(cuarto);
        for (Jugador jugador : equipo1) {
            eventoManager.addEvento(generaEventoIngresaJugador(cuarto, jugador));
        }
        for (Jugador jugador : equipo2) {
            eventoManager.addEvento(generaEventoIngresaJugador(cuarto, jugador));
        }
        return cuarto;
    }

    private Evento generaEvento(Cuarto cuarto, Jugador jugador, TipoEvento tipoEvento) {
        Evento evt = new Evento();
        evt.setCuarto(cuarto);
        evt.setEstado(EstadoEvento.NO_ELIMINADO);
        evt.setFechaHora(new Date(System.currentTimeMillis()));
        evt.setJugador(jugador);
        evt.setTipoEvento(tipoEvento);
        return evt;
    }

    private Evento generaEventoIngresaJugador(Cuarto cuarto, Jugador jugador) {
        return generaEvento(cuarto, jugador, TipoEvento.INGRESA_JUGADOR);
    }

    @Override
    public List<Arbitro> getArbitrosHabilitados() {
        return arbitroManager.getArbitrosHabilitados();
    }

    @Override
    public Arbitro saveArbitro(Arbitro arbitro) {
        return arbitroManager.addArbitro(arbitro);
    }

    @Override
    public Arbitro getArbitro(Integer id) {
        return arbitroManager.getArbitro(id);
    }

    @Override
    public void eliminarArbitro(Integer id) {
        arbitroManager.deleteArbitro(id);
    }
    
    @Override
    public Evento saveEvento(Evento e) {
        //TODO: call proper manager
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

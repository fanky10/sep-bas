package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.app.services.EventoManager;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.TipoEvento;
import com.genfersco.sepbas.dto.PartidoSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.web.form.EventoLanzamientoData;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class EventoController extends AbstractAPIController {

    @Autowired
    private EventoManager eventoManager;

    @RequestMapping(value = "/evento/lanzamiento.json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage eventoLanzamientoJSON(HttpServletRequest request, @RequestBody EventoLanzamientoData evtLanzamientoData) {
        String code = "0";
        String mensaje = "";
        Jugador jugador = servicesManager.getJugadorById(evtLanzamientoData.getIdJugadorLanzador());
        PartidoSession ps = getSavedSessionPartido(request);
        // TODO: MOVE TO BASE CONTROLLER
        if(ps == null) {
            code = "-10";
            mensaje = "Sin session";
        }else if (jugador == null) {
            code = "-1";
            mensaje = "Id jugador lanzador desconocido";
        } else if (evtLanzamientoData.getTipoEvento() == null) {
            code = "-2";
            mensaje = "Numero de puntos desconocido";
        } else {
            Evento evt = new Evento();
            evt.setJugador(jugador);
            evt.setFechaHora(new Date(System.currentTimeMillis()));
            evt.setEstado(EstadoEvento.NO_ELIMINADO);
            evt.setTipoEvento(evtLanzamientoData.getTipoEvento());
            evt.setCuarto(ps.getCuarto());
            eventoManager.addEvento(evt);
        }

        int nroPuntos = evtLanzamientoData.getNumeroPuntos();
        if (nroPuntos == 2 || nroPuntos == 3) {
            code = "0";
            mensaje = "numero de puntos:" + nroPuntos;
        }
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(mensaje);
        responseMessage.setCode(code);
        return responseMessage;
    }
}

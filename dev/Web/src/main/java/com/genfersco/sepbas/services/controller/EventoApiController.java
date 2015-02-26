package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.app.services.EventoManager;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.web.form.EventoData;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class EventoApiController extends AbstractAPIController {

    @Autowired
    private EventoManager eventoManager;

    @RequestMapping(value = "/evento/post", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage postEvento(HttpServletRequest request, @RequestBody EventoData eventoData) {
        String code = getResponseKey(request, eventoData);
        String mensaje = WebAppConstants.RESPONSE_MESSAGES.get(code);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(mensaje);
        responseMessage.setCode(code);

        if (code.equals(WebAppConstants.RESPONSE_CODE_OK)) {
            Evento evento = createEvento(request, eventoData, null);
            saveEvento(evento);
            responseMessage.setContent(evento);
        }

        return responseMessage;
    }

    private String getResponseKey(HttpServletRequest request, EventoData evtLanzamientoData) {
        String errorKey = WebAppConstants.RESPONSE_CODE_OK;
        PartidoSession ps = getSavedSessionPartido(request);

        if (ps == null || ps.getPartido() == null) {
            errorKey = WebAppConstants.RESPONSE_CODE_SIN_PARTIDO;
        } else if (ps.getCuarto() == null) {
            errorKey = WebAppConstants.RESPONSE_CODE_SIN_CUARTO;
        } else if (evtLanzamientoData.getTipoEvento() == null) {
            errorKey = WebAppConstants.RESPONSE_CODE_TIPO_EVENTO_DESCONOCIDO;
        }

        return errorKey;
    }

    private Evento createEvento(HttpServletRequest request, EventoData eventoData, Evento currentParent) {
        PartidoSession ps = getSavedSessionPartido(request);
        Jugador jugador = servicesManager.getJugadorById(eventoData.getIdJugador());
        Evento evento = new Evento();

        if (jugador == null) {
            // this should never ever executed
            throw new IllegalArgumentException("jugador con id: " + eventoData.getIdJugador() + " desconocido");
        }

        evento.setJugador(jugador);
        evento.setFechaHora(new Date(System.currentTimeMillis()));
        evento.setEstado(EstadoEvento.NO_ELIMINADO);
        evento.setTipoEvento(eventoData.getTipoEvento());
        evento.setCuarto(ps.getCuarto());
        if(currentParent != null) {
            evento.setEventoGenerador(currentParent);
        }

        if (eventoData.getEventoGenerador() != null) {
            evento = createEvento(request, eventoData.getEventoGenerador(), evento);
        }

        return evento;
    }
    
    private Evento saveEvento(Evento evento) {
        if(evento.getEventoGenerador() != null) {
            Evento parent = saveEvento(evento.getEventoGenerador());
            evento.setEventoGenerador(parent);
        }
        return eventoManager.addEvento(evento);
    }

    @RequestMapping(value = "/evento/get", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getEventos(HttpServletRequest request) {
        PartidoSession ps = getSavedSessionPartido(request);
        String code = "0";
        String mensaje = "";
        List content = null;
        if (ps == null) {
            code = "-10";
            mensaje = "Sin session";
        } else {
            content = eventoManager.findEventosByCuarto(ps.getCuarto());
        }

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(mensaje);
        responseMessage.setCode(code);
        responseMessage.setContent(content);
        return responseMessage;
    }
}

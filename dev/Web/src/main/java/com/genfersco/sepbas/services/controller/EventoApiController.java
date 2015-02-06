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

import com.genfersco.sepbas.web.form.EventoData;
import java.util.Arrays;
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
    ResponseMessage postEvento(HttpServletRequest request, @RequestBody EventoData evtLanzamientoData) {
        String code = "0";
        String mensaje = "";
        Jugador jugador = servicesManager.getJugadorById(evtLanzamientoData.getIdJugador());
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
            mensaje = "Tipo Evento desconocido";
        } else {
            Evento evt = new Evento();
            evt.setJugador(jugador);
            evt.setFechaHora(new Date(System.currentTimeMillis()));
            evt.setEstado(EstadoEvento.NO_ELIMINADO);
            evt.setTipoEvento(evtLanzamientoData.getTipoEvento());
            evt.setCuarto(ps.getCuarto());
            eventoManager.addEvento(evt);
        }
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(mensaje);
        responseMessage.setCode(code);
        return responseMessage;
    }
    
    @RequestMapping(value = "/evento/get", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getEventos(HttpServletRequest request) {
        PartidoSession ps = getSavedSessionPartido(request);
        String code = "0";
        String mensaje = "";
        List content = null;
        if(ps == null) {
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

package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.app.services.EventoManager;
import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.TipoEvento;
import com.genfersco.sepbas.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.web.form.EventoLanzamientoData;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value = "/api/secure/evento")
public class EventoController extends BaseController {

    @Autowired
    private ServicesManager servicesManager;
    @Autowired
    private EventoManager eventoManager;

    @RequestMapping(value = "/lanzamiento.json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage eventoLanzamientoJSON(@RequestBody EventoLanzamientoData evtLanzamientoData) {
        String code = "0";
        String mensaje = "";
        Jugador jugador = servicesManager.getJugadorById(evtLanzamientoData.getIdJugadorLanzador());
        List<Integer> numeroPuntosHabilitados = Arrays.asList(EventoLanzamientoData.PUNTOS_HABILITADOS);
        if (jugador == null) {
            code = "-1";
            mensaje = "Id jugador lanzador desconocido";
        } else if (!numeroPuntosHabilitados.contains(evtLanzamientoData.getNumeroPuntos())) {
            code = "-2";
            mensaje = "Numero de puntos desconocido";
        } else {
            Evento evt = new Evento();
            evt.setJugador(jugador);
            evt.setFechaHora(new Date(System.currentTimeMillis()));
            evt.setEstado(EstadoEvento.NO_ELIMINADO);
            evt.setTipoEvento(TipoEvento.INGRESA_JUGADOR);
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

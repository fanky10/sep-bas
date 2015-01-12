package com.genfersco.sepbas.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.web.form.EventoLanzamientoData;

@Controller
public class EventoController {

    @RequestMapping(value = "/secure/evento/lanzamiento.json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage eventoLanzamientoJSON(@RequestBody EventoLanzamientoData evtLanzamientoData) {
        String code = "-1";
        String mensaje = "numero de puntos desconocido";
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

    @RequestMapping(value = "/secure/evento/lanzamiento.json", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage eventoLanzamiento() {
        return new ResponseMessage();
    }
}

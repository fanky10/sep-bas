/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Jugador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fanky
 */
@Controller
public class JugadoresController {

    @Autowired
    private ServicesManager serviceManager;

    @RequestMapping(value = "/secure/api/jugadores/club/{idClub}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getJugadoresByClub(@PathVariable(value = "idClub") Integer idClub) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Club Desconocido");
        responseMessage.setCode("-1");
        List<Jugador> jugadores = serviceManager.getJugadoresClub(idClub);
        if (jugadores != null && !jugadores.isEmpty()) {
            responseMessage.setCode(ResponseMessage.CODE_OK);
            responseMessage.setMessage("");
            responseMessage.setContent(jugadores);
        }
        return responseMessage;
    }

    @RequestMapping(value = "/secure/api/jugadores/club.json", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getJugadoresByClub() {
        return getJugadoresByClub(1);
    }
}

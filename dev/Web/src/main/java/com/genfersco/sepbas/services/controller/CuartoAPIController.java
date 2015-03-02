/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.EventoData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fanky
 */
@Controller
public class CuartoAPIController extends AbstractAPIController {
    
    @RequestMapping(value = "/cuarto/nuevo", method = RequestMethod.POST)
    public @ResponseBody ResponseMessage nuevoCuarto(HttpServletRequest request) {
        String code = getResponseKey(request);
        String mensaje = WebAppConstants.RESPONSE_MESSAGES.get(code);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(mensaje);
        responseMessage.setCode(code);

        if (code.equals(WebAppConstants.RESPONSE_CODE_OK)) {
            PartidoSession partidoSession = getSavedSessionPartido(request);
            int nuevoCuartoNumero = partidoSession.getCuarto().getNumero() + 1;
            Cuarto cuarto = new Cuarto();
            cuarto.setNumero(nuevoCuartoNumero);
            cuarto.setPartido(partidoSession.getPartido());
            cuarto = getServicesManager().addCuarto(cuarto, new ArrayList<Jugador>(), new ArrayList<Jugador>());
            partidoSession.setCuarto(cuarto);
            saveSessionPartido(request, partidoSession);
            responseMessage.setContent(cuarto);
        }

        return responseMessage;
    }
}

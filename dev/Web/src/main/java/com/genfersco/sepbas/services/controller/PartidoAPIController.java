/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.dto.FinPartidoDTO;
import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.InicioPartidoData;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author fanky
 */
@Controller
public class PartidoAPIController extends AbstractAPIController {

    @Resource
    private Integer minJugadores;
    @Resource
    private Integer maxJugadores;
    
    @Deprecated
    @RequestMapping(value = "/partido/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage restAgregarPartido(@RequestBody InicioPartidoData inicioPartidoData, HttpServletRequest request, WebRequest webRequest) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(ResponseMessage.CODE_OK);
        // TODO: if it ever gets used transform from inicioPartidoData -> InicioPartidoForm
        // @Autowire particoController -> addPartido
        // the end
        return responseMessage;
    }

    @RequestMapping(value = "/partido/get", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage restGetPartido(HttpServletRequest request, WebRequest webRequest) {
        ResponseMessage message = new ResponseMessage();
        message.setCode("0");
        message.setContent(getSavedSessionPartido(request));
        return message;
    }

    @RequestMapping(value = "/partido/restart", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage restRestartPartido(HttpServletRequest request) {
        saveSessionPartido(request, null);
        ResponseMessage message = new ResponseMessage();
        message.setCode("0");
        return message;
    }
    
    @RequestMapping(value = "/partido/finalizar", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage finalizarPartido(HttpServletRequest request, @RequestBody FinPartidoDTO resultadoPartido) {
        PartidoSession ps = getSavedSessionPartido(request);
        Partido p = ps.getPartido();
        p.setResultadoLocal(resultadoPartido.getResultadoLocal());
        p.setResultadoVisitante(resultadoPartido.getResultadoVisitante());
        getServicesManager().savePartido(p);
        
        // delete session
        saveSessionPartido(request, null);

        // send response message
        ResponseMessage message = new ResponseMessage();
        String mensaje = WebAppConstants.RESPONSE_MESSAGES.get(WebAppConstants.RESPONSE_CODE_OK);
        message.setCode(WebAppConstants.RESPONSE_CODE_OK);
        message.setMessage(mensaje);
        message.setContent(p);

        return message;
    }
}

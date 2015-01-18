/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.web.form.ArbitroForm;
import com.genfersco.sepbas.web.form.InicioPartidoData;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

/**
 *
 * @author fanky
 */
@Controller
public class ServicePartidosController extends AbstractAPIController {

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
}

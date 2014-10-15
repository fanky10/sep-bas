/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.datafields.ClubPropertyEditor;
import com.genfersco.sepbas.datafields.FechaPropertyEditor;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.web.form.InicioPartidoData;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fanky
 */
@Controller
public class ServicePartidosController extends AbstractAPIController {

    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Club.class, new ClubPropertyEditor(getServicesManager()));
    }

    @RequestMapping(value = "/partido/nuevo.json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage partidoNuevo(@RequestBody InicioPartidoData inicioPartidoData) {
        String mensaje = "inicio given: " + inicioPartidoData;
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(mensaje);
        if(validateData(inicioPartidoData)){
            responseMessage.setCode("OK");
        }
        return responseMessage;
    }
    
    private boolean validateData(InicioPartidoData inicioPartidoData){
        return true;
    }

}

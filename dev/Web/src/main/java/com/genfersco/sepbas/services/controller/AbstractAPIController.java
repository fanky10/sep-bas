/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.controller.BaseController;
import com.genfersco.sepbas.web.form.EventoData;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fanky
 */
@RequestMapping(value = "/secure/api")
public abstract class AbstractAPIController extends BaseController {

    protected String getResponseKey(HttpServletRequest request) {
        String errorKey = WebAppConstants.RESPONSE_CODE_OK;
        PartidoSession ps = getSavedSessionPartido(request);

        if (ps == null || ps.getPartido() == null) {
            errorKey = WebAppConstants.RESPONSE_CODE_SIN_PARTIDO;
        } else if (ps.getCuarto() == null) {
            errorKey = WebAppConstants.RESPONSE_CODE_SIN_CUARTO;
        }

        return errorKey;
    }
}

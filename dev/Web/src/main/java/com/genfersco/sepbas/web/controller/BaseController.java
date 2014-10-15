package com.genfersco.sepbas.web.controller;

import com.genfersco.sepbas.app.services.ServicesManager;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
    @Autowired
    protected ServicesManager servicesManager;
    /**
     * Looks for error code param in the request
     * 
     * @param request
     * @return
     */
    public Integer getStatusCode(HttpServletRequest request) {

            String statusCode = request.getParameter("statusCode");
            Integer statusCodeValue = 500;
            try {
                    statusCodeValue = Integer.valueOf(statusCode);
            } catch (NumberFormatException nfe) {
                    // do nothing
            }
            return statusCodeValue;
    }
    public ServicesManager getServicesManager(){
        return servicesManager;
    }
}

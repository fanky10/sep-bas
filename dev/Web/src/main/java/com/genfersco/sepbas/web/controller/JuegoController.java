package com.genfersco.sepbas.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.web.constants.WebAppConstants;

@Controller
public class JuegoController extends BaseController {
	@Autowired
	private ServicesManager servicesManager;

	@RequestMapping(value = "/juegos/nuevo", method = RequestMethod.GET)
	public String nuevoJuego(HttpServletRequest request,
			HttpServletResponse repsponse) {
		return WebAppConstants.NUEVO_JUEGO;
	}

	public ServicesManager getServicesManager() {
		return servicesManager;
	}

	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}

}

package com.genfersco.sepbas.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.web.util.PartidoHelper;

@Controller
public class PartidoController extends BaseController {
	@Autowired
	private ServicesManager servicesManager;
	@RequestMapping(value = "/partidos/add",method = RequestMethod.POST)
	public String addPartido(HttpServletRequest request){
		Partido partido = new Partido();
		partido.setFecha(new Date(System.currentTimeMillis()));
		partido = getServicesManager().addPartido(partido);
		PartidoHelper.setPartido(request, partido);
		return "";//TODO: some redirection here
	}

	public ServicesManager getServicesManager() {
		return servicesManager;
	}

	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}
	
}

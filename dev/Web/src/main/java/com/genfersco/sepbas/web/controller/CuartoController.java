package com.genfersco.sepbas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;

@Controller
public class CuartoController {
	@Autowired
	private ServicesManager serviceManager;
	
	@RequestMapping(value="/cuartos/iniciar",method=RequestMethod.GET)
	public String showIniciaCuarto(){
		return "";
	}
	
	@RequestMapping(value="/cuartos/iniciar",method=RequestMethod.POST)
	public String guardarIniciaCuarto(){
		//TODO: call ingresoEventos controller (:
		return "";
	}
	
	@RequestMapping(value="/cuartos/finalizar",method=RequestMethod.GET)
	public String showFinalizaCuarto(){
		return "";
	}
	
	@RequestMapping(value="/cuartos/iniciar",method=RequestMethod.POST)
	public String guardarFinCuarto(){
		//TODO: call ingresoEventos controller (:
		return "";
	}
	
	public ServicesManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServicesManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
}

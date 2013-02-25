package com.genfersco.sepbas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.web.constants.WebAppConstants;

@Controller
public class CuartoController {
	@Autowired
	private ServicesManager serviceManager;
	
	@RequestMapping(value="/cuartos/iniciar",method=RequestMethod.GET)
	public String showIniciaCuarto(ModelMap map){
		List<Club> clubes = getServiceManager().getClubes();
		map.addAttribute("clubes",clubes);
		
		return WebAppConstants.INICIO_CUARTO;
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

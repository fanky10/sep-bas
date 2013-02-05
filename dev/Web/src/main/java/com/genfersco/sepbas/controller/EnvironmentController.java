package com.genfersco.sepbas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EnvironmentController {
	
	@RequestMapping(value = "/environment/services", method = RequestMethod.GET)
	public String getServices(Model map) {
		String vcapServices = java.lang.System.getenv("VCAP_SERVICES");
		map.addAttribute("vcapServices", vcapServices);
		return "web/services";
	}
}

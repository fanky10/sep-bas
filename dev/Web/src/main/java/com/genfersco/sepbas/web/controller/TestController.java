package com.genfersco.sepbas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/evento/test")
	public String showEventoView(ModelMap model){
		model.put("evento","evento!!");
		return "web/test/eventos";
	}
	
	@RequestMapping("/style/test")
	public String showStyleView(ModelMap model){
		model.put("evento","evento!!");
		return "web/test/styledSite";
	}
}

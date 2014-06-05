package com.genfersco.sepbas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.ClubForm;
import com.genfersco.sepbas.web.json.DefaultJSONResponse;
import com.genfersco.sepbas.web.json.JSONResponse;

@Controller
public class ArbitroController extends BaseController {
	@Autowired
	private ServicesManager servicesManager;

	@RequestMapping(value = "/arbitros/add", method = RequestMethod.GET)
	public String agregarClub(ModelMap map) {
		return WebAppConstants.AGREGAR_ARBITRO;
	}

	@RequestMapping(value = "/arbitros/add", method = RequestMethod.POST)
	public String agregarClub(ModelMap map, @ModelAttribute ClubForm clubForm) {
		// add logic
		return "redirect:/arbitros/list";
	}

	@RequestMapping(value = "/arbitros/list", method = RequestMethod.GET)
	public String getClubes(Model map) {
		return WebAppConstants.ARBITROS;
	}

	@RequestMapping(value = "/arbitros/delete.json", method = RequestMethod.POST)
	public @ResponseBody
	JSONResponse jsonDeleteJugador(@RequestParam("id") String id, Model map) {
		JSONResponse response = new DefaultJSONResponse("ERROR",
				"No implementado");
		return response;
	}

}

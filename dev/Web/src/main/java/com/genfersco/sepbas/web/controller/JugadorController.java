package com.genfersco.sepbas.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.JugadorForm;
import com.genfersco.sepbas.web.json.DefaultJSONResponse;
import com.genfersco.sepbas.web.json.JSONResponse;

@Controller
public class JugadorController extends BaseController {

	@Autowired
	private ServicesManager servicesManager;

	@RequestMapping(value = "/jugadores/list", method = RequestMethod.GET)
	public String getJugadores(Model map) {
		List<Jugador> jugadores = servicesManager.getJugadores();
		map.addAttribute("jugadores", jugadores);
		return WebAppConstants.JUGADORES;
	}

	@RequestMapping(value = "/jugadores/add", method = RequestMethod.GET)
	public String showAddJugador(Model map) {
		// shows view
		map.addAttribute("jugadorForm", new JugadorForm());
		return WebAppConstants.AGREGAR_JUGADOR;
	}

	@RequestMapping(value = "/jugadores/add", method = RequestMethod.POST)
	public String addJugador(@ModelAttribute JugadorForm jugadorForm, Model map) {
		// some validation later (:
		Jugador jugador = new Jugador();
		jugador.setNombre(jugadorForm.getNombre());
		jugador.setApellido(jugadorForm.getApellido());
		jugador.setFechaNacimiento(new Date(System.currentTimeMillis()));
		servicesManager.addJugador(jugador);
		// redirecciona a la url correspondiente
		return "redirect:/jugadores/list";
	}

	@RequestMapping(value = "/jugadores/delete.json", method = RequestMethod.POST)
	public @ResponseBody
	JSONResponse jsonDeleteJugador(@RequestParam("id") String id, Model map) {
		// shows view
		JSONResponse response = null;
		try {
			if (StringUtils.hasText(id)) {
				Integer iId = Integer.parseInt(id);
				servicesManager.deleteJugador(iId);
				response = new DefaultJSONResponse("OK", "Jugador eliminado");
			} else {
				response = new DefaultJSONResponse("ERROR", "Id jugador vacio");
			}
		} catch (NumberFormatException nfe) {
			response = new DefaultJSONResponse("ERROR",
					"Id jugador no es un entero");
		}
		return response;
	}
}

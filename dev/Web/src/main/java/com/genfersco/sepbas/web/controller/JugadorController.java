package com.genfersco.sepbas.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.datafields.ClubPropertyEditor;
import com.genfersco.sepbas.datafields.FechaPropertyEditor;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.JugadorForm;
import com.genfersco.sepbas.web.json.DefaultJSONResponse;
import com.genfersco.sepbas.web.json.JSONResponse;

@Controller
public class JugadorController extends BaseController {

	@Autowired
	private ServicesManager servicesManager;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Club.class, new ClubPropertyEditor(
				getServicesManager()));
		binder.registerCustomEditor(Date.class, new FechaPropertyEditor());
	}

	@RequestMapping(value = "/jugadores/list", method = RequestMethod.GET)
	public String getJugadores(Model map) {
		List<Jugador> jugadores = getServicesManager().getJugadores();
		map.addAttribute("jugadores", jugadores);
		return WebAppConstants.JUGADORES;
	}

	@RequestMapping(value = "/jugadores/add", method = RequestMethod.GET)
	public String showAddJugador(Model map) {
		// shows view
		map.addAttribute("jugadorForm", new JugadorForm());
		map.addAttribute("clubes", getServicesManager().getClubes());
		return WebAppConstants.AGREGAR_JUGADOR;
	}

	@RequestMapping(value = "/jugadores/add", method = RequestMethod.POST)
	public String addJugador(@ModelAttribute JugadorForm jugadorForm, Model map) {
		// some validation later (:
		Jugador jugador = new Jugador();
		jugador.setNombre(jugadorForm.getNombre());
		jugador.setApellido(jugadorForm.getApellido());
		jugador.setFechaNacimiento(jugadorForm.getFechaNacimiento());//new Date(System.currentTimeMillis()));
		jugador.setClub(jugadorForm.getClub());
		jugador.setNumero(jugadorForm.getNumero());
		getServicesManager().addJugador(jugador);
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
				getServicesManager().deleteJugador(iId);
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
	
	public ServicesManager getServicesManager(){
		return this.servicesManager;
	}
}

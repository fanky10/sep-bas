package com.genfersco.sepbas.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.datafields.ClubPropertyEditor;
import com.genfersco.sepbas.datafields.FechaPropertyEditor;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.JugadorForm;
import com.genfersco.sepbas.web.validation.JugadorFormValidator;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class JugadorController extends BaseController {

    @Autowired
    private JugadorFormValidator jugadorFormValidator;

    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Club.class, new ClubPropertyEditor(
                getServicesManager()));
        binder.registerCustomEditor(Date.class, new FechaPropertyEditor());
    }

    @RequestMapping(value = "/jugadores/list", method = RequestMethod.GET)
    public String getJugadores(ModelMap map) {
        List<Jugador> jugadores = servicesManager.getJugadores();
        map.addAttribute("jugadores", jugadores);
        return WebAppConstants.JUGADORES;
    }

    @RequestMapping(value = "/jugadores/add", method = RequestMethod.GET)
    public String showAddJugador(ModelMap map) {
        // shows view
        map.addAttribute("jugadorForm", new JugadorForm());
        map.addAttribute("clubes", getServicesManager().getClubes());
        return WebAppConstants.AGREGAR_JUGADOR;
    }

    @RequestMapping(value = "/jugadores/save", method = RequestMethod.POST)
    public String saveJugador(ModelMap map, @Valid @ModelAttribute JugadorForm jugadorForm, BindingResult bindingResult) {
        jugadorFormValidator.validate(jugadorForm, bindingResult);
        String redirect = "redirect:/jugadores/list";
        // some validation later (:
        if (bindingResult.hasErrors()) {
            map.addAttribute("clubes", getServicesManager().getClubes());
            redirect = WebAppConstants.AGREGAR_JUGADOR;
        } else {
            Jugador jugador = new Jugador();
            jugador.setNumero(1);
            jugador.setNombre(jugadorForm.getNombre());
            jugador.setApellido(jugadorForm.getApellido());
            jugador.setFechaNacimiento(jugadorForm.getFechaNacimiento());
            jugador.setClub(jugadorForm.getClub());
            servicesManager.addJugador(jugador);
        }
        return redirect;
    }

    @RequestMapping(value = "/jugadores/edit/{jugadorId}", method = RequestMethod.GET)
    public String editarJugador(@PathVariable("jugadorId") Integer id, ModelMap map) {
        // shows view
        Jugador jugador = servicesManager.getJugadorById(id);
        JugadorForm jugadorForm = new JugadorForm();
        jugadorForm.setId(id);
        jugadorForm.setNumero(jugador.getNumero());
        jugadorForm.setNombre(jugador.getNombre());
        jugadorForm.setApellido(jugador.getApellido());
        jugadorForm.setFechaNacimiento(jugador.getFechaNacimiento());
        jugadorForm.setClub(jugador.getClub());
        map.addAttribute("jugadorForm", jugadorForm);
        map.addAttribute("clubes", getServicesManager().getClubes());
        return WebAppConstants.AGREGAR_JUGADOR;
    }

    @RequestMapping(value = "/jugadores/del/{jugadorId}", method = RequestMethod.GET)
    public String deleteClub(@PathVariable("jugadorId") Integer id) {
        servicesManager.deleteJugador(id);
        return "redirect:/jugadores/list";
    }

    public ServicesManager getServicesManager() {
        return this.servicesManager;
    }
}

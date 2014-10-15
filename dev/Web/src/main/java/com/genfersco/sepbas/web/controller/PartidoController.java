package com.genfersco.sepbas.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.datafields.ClubPropertyEditor;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.PartidoForm;
import javax.servlet.http.HttpSession;

@Controller
public class PartidoController extends BaseController {

    @Autowired
    private ServicesManager servicesManager;

    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Club.class, new ClubPropertyEditor(
                getServicesManager()));

    }

    @RequestMapping(value = "/partidos/iniciar", method = RequestMethod.POST)
    public String addPartido(HttpSession session,
            @ModelAttribute PartidoForm partidoForm) {
        Partido partido = new Partido();
        partido.setClubLocal(partidoForm.getClubLocal());
        partido.setClubVisitante(partidoForm.getClubVisitante());
        partido.setFecha(new Date(System.currentTimeMillis()));
        partido = getServicesManager().savePartido(partido);
        savedSessionPartido(session, partido);
        return "redirect:/cuartos/iniciar";
    }

    @RequestMapping(value = "/partido/iniciar", method = RequestMethod.GET)
    public String nuevoJuego(HttpSession session,
            HttpServletResponse response, ModelMap map) {
        // TODO: check if partido iniciado
        boolean initialized = getSavedSessionPartido(session) != null;
        if (initialized) {
            return "redirect:/cuartos/iniciar";
        }
        map.addAttribute("clubes", getServicesManager().getClubes());
        map.addAttribute("arbitros", getServicesManager().getArbitrosHabilitados());
        return WebAppConstants.NUEVO_PARTIDO;
    }

    @RequestMapping(value = "/partidos/operador", method = RequestMethod.GET)
    public String nuevoJuegoOperador(HttpServletRequest request,
            HttpServletResponse repsponse, ModelMap map) {
        // TODO: clubes locales.
        //map.addAttribute("clubes", getServicesManager().getClubes());
        return WebAppConstants.INICIAR_PARTIDO;
    }

    public ServicesManager getServicesManager() {
        return servicesManager;
    }

    public void setServicesManager(ServicesManager servicesManager) {
        this.servicesManager = servicesManager;
    }

}

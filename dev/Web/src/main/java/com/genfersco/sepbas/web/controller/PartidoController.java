package com.genfersco.sepbas.web.controller;

import com.genfersco.sepbas.datafields.ArbitroPropertyEditor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.datafields.ClubPropertyEditor;
import com.genfersco.sepbas.datafields.JugadorPropertyEditor;
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.IniciarPartidoForm;
import java.util.Date;
import javax.annotation.Resource;

@Controller
public class PartidoController extends BaseController {

    @Resource
    private Integer minJugadores;
    @Resource
    private Integer maxJugadores;

    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Club.class, new ClubPropertyEditor(
                getServicesManager()));
        binder.registerCustomEditor(Jugador.class, new JugadorPropertyEditor(
                getServicesManager()));
        binder.registerCustomEditor(Arbitro.class, new ArbitroPropertyEditor(
                getServicesManager()));

    }

    @RequestMapping(value = "/partido/iniciar", method = RequestMethod.POST)
    public String addPartido(HttpServletRequest request, ModelMap map,
            @ModelAttribute IniciarPartidoForm iniciarPartidoForm) {
        String redirect = "redirect:/cuartos/iniciar";
        if (!isPartidoValid()) {
            redirect = nuevoJuego(request, map, iniciarPartidoForm);
        } else {
            Partido partido = new Partido();
            partido.setClubLocal(iniciarPartidoForm.getClubLocal());
            partido.setClubVisitante(iniciarPartidoForm.getClubVisitante());
            partido.setFecha(new Date(System.currentTimeMillis()));
            partido = getServicesManager().savePartido(partido);
            //TODO: save current jugadores playing in court
            saveSessionPartido(request, partido);
        }
        return redirect;
    }

    private boolean isPartidoValid() {
        //TODO: validate jugadores length
        // with proper message validator
        return true;
    }

    @RequestMapping(value = "/partido/iniciar", method = RequestMethod.GET)
    public String nuevoJuego(HttpServletRequest request, ModelMap map, IniciarPartidoForm iniciarPartidoForm) {
        if (getSavedSessionPartido(request) != null) {
            return "redirect:/cuartos/iniciar";
        }
        map.addAttribute("iniciarPartidoForm", iniciarPartidoForm == null ? new IniciarPartidoForm() : iniciarPartidoForm);
        map.addAttribute("clubes", getServicesManager().getClubes());
        map.addAttribute("arbitros", getServicesManager().getArbitrosHabilitados());
        return WebAppConstants.NUEVO_PARTIDO;
    }

    @RequestMapping(value = "/partido/operador", method = RequestMethod.GET)
    public String nuevoJuegoOperador(HttpServletRequest request,
            HttpServletResponse repsponse, ModelMap map) {
        // TODO: clubes locales.
        //map.addAttribute("clubes", getServicesManager().getClubes());
        return WebAppConstants.INICIAR_PARTIDO;
    }

}

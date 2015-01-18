package com.genfersco.sepbas.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.datafields.JugadorPropertyEditor;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.IniciaCuartoForm;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@Controller
public class CuartoController extends BaseController {

    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Jugador.class, new JugadorPropertyEditor(
                getServicesManager()));
    }

    @RequestMapping(value = "/cuarto/iniciar", method = RequestMethod.GET)
    public String showIniciaCuarto(HttpServletRequest request, ModelMap map,
            IniciaCuartoForm iniciaCuartoForm, BindingResult bindingResult) {
        PartidoSession partidoSession = getSavedSessionPartido(request);
        if (partidoSession == null) {
            return "redirect:/partido/iniciar";
        }
        List<Jugador> jugadoresClubLocal = partidoSession.getJugadoresLocalesDisponibles();
        List<Jugador> jugadoresClubVisitante = partidoSession.getJugadoresVisitantesDisponibles();
        if (partidoSession.getCuartoNumero() == 0) {
            partidoSession.setCuartoNumero(1);
        }
        map.addAttribute("cuartoNumero", partidoSession.getCuartoNumero());
        map.addAttribute("clubLocal", partidoSession.getPartido().getClubLocal());
        map.addAttribute("clubVisitante", partidoSession.getPartido().getClubVisitante());
        map.addAttribute("jugadoresClubLocal", jugadoresClubLocal);
        map.addAttribute("jugadoresClubVisitante", jugadoresClubVisitante);
        map.addAttribute("iniciaCuartoForm", iniciaCuartoForm == null ? new IniciaCuartoForm() : iniciaCuartoForm);

        return WebAppConstants.INICIO_CUARTO;
    }

    @RequestMapping(value = "/cuarto/iniciar", method = RequestMethod.POST)
    public String guardarIniciaCuarto(HttpServletRequest request, ModelMap map,
            @ModelAttribute IniciaCuartoForm iniciaCuartoForm, BindingResult bindingResult) {
        PartidoSession partidoSession = getSavedSessionPartido(request);
        if (partidoSession == null) {
            return "redirect:/partido/iniciar";
        }

        validateIniciaCuarto(iniciaCuartoForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return showIniciaCuarto(request, map, iniciaCuartoForm, bindingResult);
        }

        List<Jugador> jugadoresLocales = Arrays.asList(iniciaCuartoForm
                .getJugadoresLocales());
        List<Jugador> jugadoresVisitantes = Arrays.asList(iniciaCuartoForm
                .getJugadoresVisitantes());
        Cuarto cuarto = new Cuarto();
        cuarto.setNumero(iniciaCuartoForm.getCuartoNumero());
        cuarto.setPartido(partidoSession.getPartido());
        // TODO: eventos de ingreso??
        getServicesManager().addCuarto(cuarto, jugadoresLocales, jugadoresVisitantes);

        return "web/test/okMessage";
    }

    private void validateIniciaCuarto(IniciaCuartoForm iniciaCuartoForm, Errors errors) {
        if (iniciaCuartoForm.getJugadoresLocales() == null) {
            errors.rejectValue("jugadoresLocales","iniciarCuarto.jugadoresLocales.requires", "Sin jugadores locales");
        }
        if (iniciaCuartoForm.getJugadoresVisitantes() == null) {
            errors.rejectValue("jugadoresVisitantes","iniciarCuarto.jugadoresVisitantes.requires", "Sin jugadores visitantes");
        }
    }

}

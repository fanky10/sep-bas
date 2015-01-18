package com.genfersco.sepbas.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.datafields.JugadorPropertyEditor;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.IniciaCuartoForm;
import javax.servlet.http.HttpSession;

@Controller
public class CuartoController extends BaseController {

    @Autowired
    private ServicesManager serviceManager;
    @Autowired
    private PartidoController partidoController;

    @InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Jugador.class, new JugadorPropertyEditor(
                getServiceManager()));
    }

    @RequestMapping(value = "/cuartos/iniciar", method = RequestMethod.GET)
    public String showIniciaCuarto(HttpServletRequest request, ModelMap map) {
        PartidoSession partidoSession = getSavedSessionPartido(request);
        List<Jugador> jugadoresClubLocal = partidoSession.getJugadoresLocalesDisponibles();
        List<Jugador> jugadoresClubVisitante = partidoSession.getJugadoresVisitantesDisponibles();

        map.addAttribute("clubLocal", partidoSession.getPartido().getClubLocal());
        map.addAttribute("clubVisitante", partidoSession.getPartido().getClubVisitante());
        map.addAttribute("jugadoresClubLocal", jugadoresClubLocal);
        map.addAttribute("jugadoresClubVisitante", jugadoresClubVisitante);

        map.addAttribute("iniciaCuartoForm", new IniciaCuartoForm());
        return WebAppConstants.INICIO_CUARTO;
    }

    @RequestMapping(value = "/cuartos/iniciar", method = RequestMethod.POST)
    public String guardarIniciaCuarto(HttpServletRequest request,
            @ModelAttribute IniciaCuartoForm iniciaCuartoForm) {
		// TODO create a VO object (BO) CuartoBO
        // with equipo1 and equipo2 as attributes
        List<Jugador> equipo1 = Arrays.asList(iniciaCuartoForm
                .getJugadoresEquipo1());
        List<Jugador> equipo2 = Arrays.asList(iniciaCuartoForm
                .getJugadoresEquipo2());
        Partido partido = getSavedSessionPartido(request).getPartido();
        Cuarto cuarto = new Cuarto();
        cuarto.setNumero(1);
        cuarto.setPartido(partido);
        cuarto = getServiceManager().addCuarto(cuarto, equipo1, equipo2);

        // TODO: redirect ingresoEventos controller (:
        return "web/test/okMessage";
    }

    @RequestMapping(value = "/cuartos/finalizar", method = RequestMethod.GET)
    public String showFinalizaCuarto() {
        return "";
    }

    @RequestMapping(value = "/cuartos/finalizar", method = RequestMethod.POST)
    public String guardarFinCuarto() {
        // TODO: call ingresoEventos controller (:
        return "";
    }

//    protected Partido getPartido(HttpServletRequest request) {
//        Partido partido = getSavedSessionPartido(request);
//        if (partido == null) {
//            throw new IllegalArgumentException("Sin partido guardado");
//        }
//        return partido;
//    }

    public ServicesManager getServiceManager() {
        return serviceManager;
    }

    public void setServiceManager(ServicesManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    public PartidoController getPartidoController() {
        return partidoController;
    }

    public void setPartidoController(PartidoController partidoController) {
        this.partidoController = partidoController;
    }

}

package com.genfersco.sepbas.web.controller;

import com.genfersco.sepbas.app.services.PartidoManager;
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
import com.genfersco.sepbas.domain.repository.PartidoRepository;
import com.genfersco.sepbas.dto.PartidoSession;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.IniciarPartidoForm;
import com.genfersco.sepbas.web.validation.IniciarPartidoFormValidator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PartidoController extends BaseController {

    @Autowired
    private IniciarPartidoFormValidator iniciarPartidoFormValidator;
    @Autowired
    private PartidoManager partidoManager;
    @Autowired
    private PartidoRepository partidoRepository;

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
            @ModelAttribute IniciarPartidoForm iniciarPartidoForm, BindingResult bindingResult) {
        iniciarPartidoFormValidator.validate(iniciarPartidoForm, bindingResult);
        String redirect = "redirect:/cuarto/iniciar";
        if (bindingResult.hasErrors()) {
            redirect = nuevoJuego(request, map, iniciarPartidoForm, bindingResult);
        } else {
            Partido partido = new Partido();
            partido.setClubLocal(iniciarPartidoForm.getClubLocal());
            partido.setClubVisitante(iniciarPartidoForm.getClubVisitante());
            partido.setArbitro(iniciarPartidoForm.getArbitro());
            partido.setFecha(new Date(System.currentTimeMillis()));
            partido = getServicesManager().savePartido(partido);
            PartidoSession ps = new PartidoSession();
            ps.setPartido(partido);
            ps.setJugadoresLocalesDisponibles(Arrays.asList(iniciarPartidoForm.getJugadoresLocales()));
            ps.setJugadoresVisitantesDisponibles(Arrays.asList(iniciarPartidoForm.getJugadoresVisitantes()));
            saveSessionPartido(request, ps);
        }
        return redirect;
    }

    @RequestMapping(value = "/partido/iniciar", method = RequestMethod.GET)
    public String nuevoJuego(HttpServletRequest request, ModelMap map, IniciarPartidoForm iniciarPartidoForm, BindingResult result) {
        if (getSavedSessionPartido(request) != null) {
            return "redirect:/cuarto/iniciar";
        }
        map.addAttribute("iniciarPartidoForm", iniciarPartidoForm == null ? new IniciarPartidoForm() : iniciarPartidoForm);
        map.addAttribute("clubes", getServicesManager().getClubes());
        map.addAttribute("arbitros", getServicesManager().getArbitrosHabilitados());
        return WebAppConstants.NUEVO_PARTIDO;
    }

    @RequestMapping(value = {"/partido/finalizar/{partidoId}", "/partido/{partidoId}"}, method = RequestMethod.GET)
    public String finPartido(@PathVariable("partidoId") Integer partidoId, HttpServletRequest request, ModelMap map) {
        if(partidoId == null) { 
            partidoId = partidoRepository.findLastPartido().get(0).getId();
        }
        map.put("partidoId", partidoId);

        return WebAppConstants.FIN_PARTIDO;
    }
    
    @RequestMapping(value = {"/partido/finalizar"}, method = RequestMethod.GET)
    public String finalizarPartido(HttpServletRequest request, ModelMap map) {
        return this.finPartido(null, request, map);
    }

    @RequestMapping(value = "/partido/simpleOperador", method = RequestMethod.GET)
    public String nuevoJuegoOperador(HttpServletRequest request,
            HttpServletResponse repsponse, ModelMap map) {
        PartidoSession ps = getSavedSessionPartido(request);
        if (ps == null) {// apply some filtering may be?
            return "redirect:/partido/iniciar";
        } else if (ps.getCuarto() == null) {
            return "redirect:/cuarto/iniciar";
        }
        return WebAppConstants.CONSOLA_OPERADOR;
    }

    @RequestMapping(value = "/partido/operador", method = RequestMethod.GET)
    public String operadorEstatico(HttpServletRequest request,
            HttpServletResponse repsponse, ModelMap map) {
        return "web/partidos/operador_static";
    }

    @RequestMapping(value = "/partidos", method = RequestMethod.GET)
    public String getPartidos(HttpServletRequest request,
            HttpServletResponse repsponse, ModelMap map) {
        List<Partido> partidos = partidoManager.getPartidos();
        map.put("partidos", partidos);
        return WebAppConstants.LISTA_PARTIDOS;
    }

}

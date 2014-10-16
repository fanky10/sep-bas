/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.model.Jugador;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.web.form.InicioPartidoData;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fanky
 */
@Controller
public class ServicePartidosController extends AbstractAPIController {

    @Resource
    private Integer minJugadores;
    @Resource
    private Integer maxJugadores;

    @RequestMapping(value = "/partido/nuevo.json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage partidoNuevo(@RequestBody InicioPartidoData inicioPartidoData, HttpServletRequest request,HttpSession session) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(ResponseMessage.CODE_OK);
        Arbitro arbitro = getServicesManager().getArbitro(inicioPartidoData.getIdArbitro());
        Club clubLocal = getServicesManager().getClub(String.valueOf(inicioPartidoData.getIdClubLocal()));
        Club clubVisitante = getServicesManager().getClub(String.valueOf(inicioPartidoData.getIdClubVisitante()));
        if (arbitro == null) {
            responseMessage.setMessage("Arbitro desconocido");
            responseMessage.setCode("-1");
        } else if (clubLocal == null) {
            responseMessage.setMessage("Club local desconocido");
            responseMessage.setCode("-2");
        } else if (clubVisitante == null) {
            responseMessage.setMessage("Club visitante desconocido");
            responseMessage.setCode("-3");
        } else if (inicioPartidoData.getIdJugadoresLocales().size() < minJugadores) {
            responseMessage.setMessage("Cantidad jugadores locales menores a: " + minJugadores);
            responseMessage.setCode("-4");
        } else if (inicioPartidoData.getIdJugadoresLocales().size() > maxJugadores) {
            responseMessage.setMessage("Cantidad jugadores locales mayores a:" + maxJugadores);
            responseMessage.setCode("-5");
        } else if (inicioPartidoData.getIdJugadoresVisitantes().size() < minJugadores) {
            responseMessage.setMessage("Cantidad jugadores visitantes menores a: " + minJugadores);
            responseMessage.setCode("-6");
        } else if (inicioPartidoData.getIdJugadoresVisitantes().size() > maxJugadores) {
            responseMessage.setMessage("Cantidad jugadores visitantes mayores a:" + maxJugadores);
            responseMessage.setCode("-7");
        } else {
            // check cada uno de los jugadores.
            for (Integer idJugador : inicioPartidoData.getIdJugadoresLocales()) {
                Jugador j = getServicesManager().getJugadorById(idJugador);
                if (j == null) {
                    responseMessage.setMessage("Jugador local desconocido con id:" + j);
                    responseMessage.setCode("-8");
                    break;
                }
            }

            for (Integer idJugador : inicioPartidoData.getIdJugadoresVisitantes()) {
                Jugador j = getServicesManager().getJugadorById(idJugador);
                if (j == null) {
                    responseMessage.setMessage("Jugador visitante desconocido con id:" + j);
                    responseMessage.setCode("-9");
                    break;
                }
            }
        }
        // still everything valid
        if (responseMessage.getCode().equals(ResponseMessage.CODE_OK)) {
            Partido partido = new Partido();
            partido.setClubLocal(clubLocal);
            partido.setClubVisitante(clubVisitante);
            partido.setFecha(new Date(System.currentTimeMillis()));
            partido = getServicesManager().savePartido(partido);
            saveSessionPartido(session, partido);
            responseMessage.setMessage("Nuevo partido guardado");
        }

        return responseMessage;
    }

    @RequestMapping(value = "/partido.json", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage partidoNuevo(HttpServletRequest request, HttpSession session) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode("-1");
        responseMessage.setMessage("Sin partido guardado");
        Partido p = getSavedSessionPartido(session);
        if (p != null) {
            responseMessage.setCode(ResponseMessage.CODE_OK);
            responseMessage.setContent(p);
        }
        return responseMessage;

    }
}

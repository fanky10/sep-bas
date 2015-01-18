/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.web.validation;

import com.genfersco.sepbas.web.form.IniciarPartidoForm;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author fanky
 */
@Component
public class IniciarPartidoFormValidator implements Validator {

    @Resource
    private Integer minJugadores;
    @Resource
    private Integer maxJugadores;

    @Override
    public boolean supports(Class type) {
        return IniciarPartidoForm.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        IniciarPartidoForm form = (IniciarPartidoForm) target;
        if (form.getArbitro() == null) {
            errors.rejectValue("arbitro", "Arbitro Requerido");
        }
        if (form.getClubLocal() == null) {
            errors.rejectValue("clubLocal", "Club Requerido");
        }
        if (form.getClubVisitante() == null) {
            errors.rejectValue("clubVisitante", "Club Requerido");
        }
        
        if (form.getJugadoresLocales() == null) {
            errors.rejectValue("jugadoresLocales", "Sin jugadores locales");
        } else if (form.getJugadoresLocales().length < minJugadores) {
            errors.rejectValue("jugadoresLocales", "Muy pocos jugadores locales");
        } else if (form.getJugadoresLocales().length > maxJugadores) {
            errors.rejectValue("jugadoresLocales", "Muchos jugadores locales");
        }
        
        if (form.getJugadoresVisitantes()== null) {
            errors.rejectValue("jugadoresLocales", "Sin jugadores visitantes");
        } else if (form.getJugadoresVisitantes().length < minJugadores) {
            errors.rejectValue("jugadoresLocales", "Muy pocos jugadores visitantes");
        } else if (form.getJugadoresVisitantes().length > maxJugadores) {
            errors.rejectValue("jugadoresLocales", "Muchos jugadores visitantes");
        }
    }

}

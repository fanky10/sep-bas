/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.web.validation;

import com.genfersco.sepbas.web.form.JugadorForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author fanky
 */
@Component
public class JugadorFormValidator implements Validator {

    @Override
    public boolean supports(Class type) {
        return JugadorForm.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JugadorForm jf = (JugadorForm) target;
        if (jf.getFechaNacimiento() == null) {
            errors.rejectValue("fechaNacimiento", "jugador.fechaNacimiento.required", "Fecha Nacimiento Requerida");
        }
        
        if (jf.getClub() == null) {
            errors.rejectValue("club", "jugador.club.required", "Club Requerido");
        }

    }
}

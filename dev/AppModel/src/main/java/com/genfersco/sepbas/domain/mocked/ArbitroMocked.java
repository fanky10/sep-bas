/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.domain.mocked;

import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.domain.repository.ArbitroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fanky
 */
@Component
public class ArbitroMocked {

    @Autowired
    private ArbitroRepository arbitroRepository;

    public Arbitro getArbitro() {
        return getArbitro("Cacho", "Castaña", "Berabebú", true);
    }

    public Arbitro getArbitro(String nombre, String apellido, String localidad, boolean saveInstance) {
        Arbitro arbitro = new Arbitro();

        arbitro.setApellido(apellido);
        arbitro.setLocalidad(localidad);
        arbitro.setNombre(nombre);

        if (saveInstance) {
            arbitro = arbitroRepository.save(arbitro);
        }

        return arbitro;
    }
}

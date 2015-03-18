package com.genfersco.sepbas.web.form;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

public class ClubForm implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6148610887747709026L;
    private Integer id;
    
    @NotBlank(message = "La localidad es un campo obligatorio")
    private String localidad;
    
    @NotBlank(message = "El nombre es un campo obligatorio")
    private String nombre;

    public ClubForm() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}

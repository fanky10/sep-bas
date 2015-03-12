package com.genfersco.sepbas.web.form;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

public class ClubForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6148610887747709026L;
        @NotEmpty
        private String localidad;
	private Integer id;
        @NotEmpty
	private String nombre;
	public ClubForm(){
		
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}

        public String getLocalidad(){
			return this.localidad;
	}
		
	public void setLocalidad(String localidad){
			this.localidad = localidad;	
	}
}

package com.genfersco.sepbas.web.form;

import java.io.Serializable;

public class ArbitroForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6148610887747709026L;
	private Integer id;
	private String nombre;
	private String apellido;
        private String localidad;
	public ArbitroForm(){
		
	}
        
        
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getApellido(){
			return this.apellido;
	}
		
	public void setApellido(String apellido){
			this.apellido = apellido;	
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

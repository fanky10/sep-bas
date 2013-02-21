package com.genfersco.sepbas.web.form;

import java.io.Serializable;

public class ClubForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6148610887747709026L;
	private Integer id;
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
}

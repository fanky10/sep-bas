package com.genfersco.sepbas.web.form;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class JugadorForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091223400542004345L;
	private Integer id;
	private String nombre;
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

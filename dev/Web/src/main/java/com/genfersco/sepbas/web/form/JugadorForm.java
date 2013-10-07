package com.genfersco.sepbas.web.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.genfersco.sepbas.domain.model.Club;

@Component
public class JugadorForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091223400542004345L;
	private Integer id;
	private String nombre;
	private String apellido;
	private Club club;
	private Integer numero;
	private Date fechaNacimiento;
	private Float altura;
	
	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}

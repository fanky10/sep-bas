package com.genfersco.sepbas.web.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.genfersco.sepbas.domain.model.Club;
import org.hibernate.validator.constraints.NotEmpty;

@Component
public class JugadorForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091223400542004345L;
	private Integer id;

        @NotEmpty(message = "El nombre es requerido")
	private String nombre;

        @NotEmpty(message = "El apellido es requerido")
	private String apellido;
	private Club club;
	private Date fechaNacimiento;
	private Date fechaAlta;
        private Integer numero;

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
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

	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}

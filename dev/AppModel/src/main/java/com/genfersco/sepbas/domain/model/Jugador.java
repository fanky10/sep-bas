package com.genfersco.sepbas.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jugador")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jugador_id", nullable = false)
	private Integer id;
	
	@Column(name = "jugador_fec_nac", nullable = false, unique = true)
	private Date fechaNacimiento;

	@Column(name = "jugador_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "jugador_apellido", nullable = false)
	private String apellido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	
	
	
}

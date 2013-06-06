package com.genfersco.sepbas.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arbitros")
public class Arbitro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arbitro_id", nullable = false)
	private Integer id;

	@Column(name = "arbitro_nombre", nullable = false)
	private String nombre;

	@Column(name = "arbitro_apellido", nullable = false)
	private String apellido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

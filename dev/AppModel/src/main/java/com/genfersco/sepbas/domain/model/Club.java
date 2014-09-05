package com.genfersco.sepbas.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubes")
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "club_id", nullable = false)
	private Integer id;
	@Column(name = "club_nombre", nullable = false)
	private String nombre;
        @Column(name = "club_localidad", nullable = false)
        private String localidad;

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
        public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String nombre) {
		this.localidad = localidad;
	}
}

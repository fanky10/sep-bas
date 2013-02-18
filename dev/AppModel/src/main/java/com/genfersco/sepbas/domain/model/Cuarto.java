package com.genfersco.sepbas.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuartos")
public class Cuarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cuarto_id", nullable = false)
	private Integer id;

	@Column(name = "cuarto_numero", nullable = false)
	private Integer numero;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Partido.class)
	@JoinColumn(name = "cuarto_partido_id", referencedColumnName = "partido_id")
	private Partido partido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}

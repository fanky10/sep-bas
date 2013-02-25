package com.genfersco.sepbas.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partidos")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partido_id", nullable = false)
	private Integer id;

	@Column(name = "partido_fecha", nullable = false, unique = true)
	private Date fecha;

	@Column(name = "partido_resultado_local", nullable = true)
	private Integer resultadoLocal;

	@Column(name = "partido_resultado_visitante", nullable = true)
	private Integer resultadoVisitante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getResultadoLocal() {
		return resultadoLocal;
	}

	public void setResultadoLocal(Integer resultadoLocal) {
		this.resultadoLocal = resultadoLocal;
	}

	public Integer getResultadoVisitante() {
		return resultadoVisitante;
	}

	public void setResultadoVisitante(Integer resultadoVisitante) {
		this.resultadoVisitante = resultadoVisitante;
	}

}

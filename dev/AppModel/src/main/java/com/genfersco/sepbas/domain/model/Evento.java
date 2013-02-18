package com.genfersco.sepbas.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evento_id", nullable = false)
	private Integer id;

	@Column(name = "evento_fec_hora", nullable = false)
	private Date fechaHora;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Evento.class)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "evento_generador_id", referencedColumnName = "evento_id")
	private Evento eventoGenerador;

	@Column(name = "evento_estado", nullable = false)
	@Enumerated
	private EstadoEvento estado;

	// evento_cuarto_id
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Cuarto.class)
	@JoinColumn(name = "evento_cuarto_id", referencedColumnName = "cuarto_id")
	private Cuarto cuarto;

	@Column(name = "evento_tipo_evento", nullable = false)
	@Enumerated
	private TipoEvento tipoEvento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Evento getEventoGenerador() {
		return eventoGenerador;
	}

	public void setEventoGenerador(Evento eventoGenerador) {
		this.eventoGenerador = eventoGenerador;
	}

	public EstadoEvento getEstado() {
		return estado;
	}

	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}

	public Cuarto getCuarto() {
		return cuarto;
	}

	public void setCuarto(Cuarto cuarto) {
		this.cuarto = cuarto;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}

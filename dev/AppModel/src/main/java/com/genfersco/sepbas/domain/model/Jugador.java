package com.genfersco.sepbas.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "jugadores")
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jugador_id", nullable = false)
	private Integer id;

	@Column(name = "jugador_fec_nac", nullable = false, unique = true)
        @Temporal(javax.persistence.TemporalType.DATE)
       	private Date fechaNacimiento;

	@Column(name = "jugador_nombre", nullable = false)
	private String nombre;

	@Column(name = "jugador_apellido", nullable = false)
	private String apellido;

	@Column(name = "jugador_numero", nullable = false)
	private Integer numero;

	@ManyToOne(targetEntity = Club.class)
	@JoinColumn(name = "jugador_actual_club_id", referencedColumnName = "club_id")
	private Club club;

	@Column(name = "jugador_estado", nullable = false)
	@Enumerated
	private EstadoJugador estado = EstadoJugador.HABILITADO;

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

	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public EstadoJugador getEstado() {
		return estado;
	}

	public void setEstado(EstadoJugador estado) {
		this.estado = estado;
	}

}

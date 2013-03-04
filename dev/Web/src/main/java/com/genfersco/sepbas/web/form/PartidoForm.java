package com.genfersco.sepbas.web.form;

import java.io.Serializable;

import com.genfersco.sepbas.domain.model.Club;

public class PartidoForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4460858768271240578L;
	private Club clubLocal;
	private Club clubVisitante;
	
	public Club getClubLocal() {
		return clubLocal;
	}
	public void setClubLocal(Club clubLocal) {
		this.clubLocal = clubLocal;
	}
	public Club getClubVisitante() {
		return clubVisitante;
	}
	public void setClubVisitante(Club clubVisitante) {
		this.clubVisitante = clubVisitante;
	}
}

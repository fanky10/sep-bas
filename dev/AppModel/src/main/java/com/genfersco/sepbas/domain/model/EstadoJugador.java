package com.genfersco.sepbas.domain.model;

public enum EstadoJugador {
	HABILITADO(1),DESHABILITADO(0);

	private final int valor;

	EstadoJugador(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}

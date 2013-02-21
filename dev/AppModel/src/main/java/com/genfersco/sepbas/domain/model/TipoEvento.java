package com.genfersco.sepbas.domain.model;

public enum TipoEvento {
	INGRESA_JUGADOR(1),SALIDA_JUGADOR(0);

	private final int valor;

	TipoEvento(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
package com.genfersco.sepbas.domain.model;

public enum TipoEvento {
	INGRESA_JUGADOR(1),SALIDA_JUGADOR(0),
        LANZAMIENTO_JUGADOR_UN_PUNTO(2),
        LANZAMIENTO_JUGADOR_DOS_PUNTOS(3),
        LANZAMIENTO_JUGADOR_TRES_PUNTOS(2);

	private final int valor;

	TipoEvento(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}

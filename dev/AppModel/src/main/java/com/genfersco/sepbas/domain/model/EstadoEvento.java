package com.genfersco.sepbas.domain.model;

public enum EstadoEvento{
	ELIMINADO(1),NO_ELIMINADO(0);

	private final int valor;

	EstadoEvento(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}

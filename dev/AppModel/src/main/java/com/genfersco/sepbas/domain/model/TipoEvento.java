package com.genfersco.sepbas.domain.model;

public enum TipoEvento {

    INGRESA_JUGADOR(0),
    SALIDA_JUGADOR(1),
    LANZAMIENTO_JUGADOR_UN_PUNTO(2),
    LANZAMIENTO_JUGADOR_DOS_PUNTOS(3),
    LANZAMIENTO_JUGADOR_TRES_PUNTOS(4),
    ASISTENCIA_JUGADOR(5);

    private final int valor;

    TipoEvento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

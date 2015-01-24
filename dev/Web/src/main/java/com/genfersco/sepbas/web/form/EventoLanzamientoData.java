package com.genfersco.sepbas.web.form;

import com.genfersco.sepbas.domain.model.TipoEvento;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"numeroPuntos", "idJugadorLanzador", "idJugadorAsistencia"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventoLanzamientoData {

    public static final Integer[] PUNTOS_HABILITADOS = new Integer[]{1, 2, 3};
    private Integer numeroPuntos;
    private Integer idJugadorLanzador;
    private Integer idJugadorAsistencia;

    public TipoEvento getTipoEvento() {
        TipoEvento tipoEvento = null;
        if (numeroPuntos == 1) {
            tipoEvento = TipoEvento.LANZAMIENTO_JUGADOR_UN_PUNTO;
        } else if (numeroPuntos == 2) {
            tipoEvento = TipoEvento.LANZAMIENTO_JUGADOR_DOS_PUNTOS;
        } else if (numeroPuntos == 3) {
            tipoEvento = TipoEvento.LANZAMIENTO_JUGADOR_TRES_PUNTOS;
        }
        return tipoEvento;
    }

    public Integer getNumeroPuntos() {
        return numeroPuntos;
    }

    public void setNumeroPuntos(Integer numeroPuntos) {
        this.numeroPuntos = numeroPuntos;
    }

    public Integer getIdJugadorLanzador() {
        return idJugadorLanzador;
    }

    public void setIdJugadorLanzador(Integer idJugadorLanzador) {
        this.idJugadorLanzador = idJugadorLanzador;
    }

    public Integer getIdJugadorAsistencia() {
        return idJugadorAsistencia;
    }

    public void setIdJugadorAsistencia(Integer idJugadorAsistencia) {
        this.idJugadorAsistencia = idJugadorAsistencia;
    }

}

package com.genfersco.sepbas.web.form;

import com.genfersco.sepbas.domain.model.TipoEvento;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"nombreEvento", "idJugador", "idEventoGenerador"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventoData {

    public static final Integer[] PUNTOS_HABILITADOS = new Integer[]{1, 2, 3};
    private String nombreEvento;
    private Integer idJugador;
    private Integer idEventoGenerador;

    public TipoEvento getTipoEvento() {
        return TipoEvento.valueOf(nombreEvento);
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Integer getIdEventoGenerador() {
        return idEventoGenerador;
    }

    public void setIdEventoGenerador(Integer idEventoGenerador) {
        this.idEventoGenerador = idEventoGenerador;
    }
}

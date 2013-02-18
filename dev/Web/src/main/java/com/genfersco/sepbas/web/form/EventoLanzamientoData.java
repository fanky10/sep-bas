package com.genfersco.sepbas.web.form;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "numeroPuntos" })
@JsonIgnoreProperties({})
public class EventoLanzamientoData {
	private Integer numeroPuntos;

	public Integer getNumeroPuntos() {
		return numeroPuntos;
	}

	public void setNumeroPuntos(Integer numeroPuntos) {
		this.numeroPuntos = numeroPuntos;
	}

}

package com.genfersco.sepbas.web.constants;

import java.util.HashMap;
import java.util.Map;

public class WebAppConstants {

    public static final String FORMATO_FECHA = "dd/MM/yyyy";
    // List of view pages
    public static final String HOMEPAGE = "web/home";
    public static final String JUGADORES = "web/jugadores/jugadores";
    public static final String AGREGAR_JUGADOR = "web/jugadores/jugador";
    public static final String STATIC_ERROR_PAGE = "web/staticerror";
    public static final String AGREGAR_CLUB = "web/clubes/club";
    public static final String CLUBES = "web/clubes/clubes";
    public static final String INICIO_CUARTO = "web/cuartos/inicia_cuarto";
    public static final String NUEVO_PARTIDO = "web/partidos/nuevo_partido";
    public static final String FIN_PARTIDO = "web/partidos/fin_partido";
    public static final String CONSOLA_OPERADOR = "web/partidos/operador";
    public static final String LISTA_PARTIDOS = "web/partidos/partidos";
    public static final String AGREGAR_ARBITRO = "web/arbitros/arbitro";
    public static final String ARBITROS = "web/arbitros/arbitros";

    // List of Session and Request attribute names
    public static final String SESSION_PARTIDO_KEY = "sessionPartido";

    public static final Map<String, String> RESPONSE_MESSAGES = new HashMap<String, String>();
    public static final String RESPONSE_CODE_OK = "0";
    public static final String RESPONSE_CODE_SIN_PARTIDO = "-1";
    public static final String RESPONSE_CODE_SIN_CUARTO = "-2";
    public static final String RESPONSE_CODE_ID_JUGADOR_DESCONOCIDO = "-10";
    public static final String RESPONSE_CODE_TIPO_EVENTO_DESCONOCIDO = "-11";
    

    static {
        RESPONSE_MESSAGES.put(RESPONSE_CODE_OK,"response.ok");
        RESPONSE_MESSAGES.put(RESPONSE_CODE_SIN_PARTIDO,"response.sin.partido");
        RESPONSE_MESSAGES.put(RESPONSE_CODE_SIN_CUARTO,"response.sin.cuarto");
        RESPONSE_MESSAGES.put(RESPONSE_CODE_ID_JUGADOR_DESCONOCIDO,"response.idJugador.desconocido");
        RESPONSE_MESSAGES.put(RESPONSE_CODE_TIPO_EVENTO_DESCONOCIDO,"response.tipoEvento.desconocido");
    }
}

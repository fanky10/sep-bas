package com.genfersco.sepbas.web.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.web.constants.WebAppConstants;

public class PartidoHelper {
	public static Partido getPartido(HttpServletRequest request) {
		return (Partido) WebUtils.getSessionAttribute(request,
				WebAppConstants.PARTIDO_KEY);
	}
	
	public static void setPartido(HttpServletRequest request, Partido partido){
		WebUtils.setSessionAttribute(request, WebAppConstants.PARTIDO_KEY, partido);
	}
}

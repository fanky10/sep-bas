package com.genfersco.sepbas.web.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
	/**
	 * Looks for error code param in the request
	 * 
	 * @param request
	 * @return
	 */
	public Integer getStatusCode(HttpServletRequest request) {

		String statusCode = request.getParameter("statusCode");
		Integer statusCodeValue = 500;
		try {
			statusCodeValue = Integer.valueOf(statusCode);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		return statusCodeValue;
	}
}

package com.genfersco.sepbas.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genfersco.sepbas.web.constants.WebAppConstants;

@Controller
public class ErrorController extends BaseController {
	@RequestMapping(value = "/error")
	  public String showErrorPage(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {
	    Integer statusCode = getStatusCode(request);
	    response.setStatus(statusCode);
	    map.addAttribute("title", "Error Aplicacion.");
	    map.addAttribute("label", "Un Error inesperado ha pasado");
	    map.addAttribute("body", "No podemos procesar su request en este momento.");
	    map.addAttribute("statusCode", statusCode);
	    return WebAppConstants.STATIC_ERROR_PAGE;
	  }
}

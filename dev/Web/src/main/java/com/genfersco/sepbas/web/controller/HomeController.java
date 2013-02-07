package com.genfersco.sepbas.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genfersco.sepbas.web.constants.WebAppConstants;

@Controller
public class HomeController extends BaseController {

	@Resource
	private String homeMessage;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model map) {
		map.addAttribute("mensaje", getHomeMessage());
		return WebAppConstants.HOMEPAGE;
	}

	public String getHomeMessage() {
		return homeMessage;
	}

	public void setHomeMessage(String homeMessage) {
		this.homeMessage = homeMessage;
	}
}

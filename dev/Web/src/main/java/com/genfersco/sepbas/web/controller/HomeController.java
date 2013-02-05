package com.genfersco.sepbas.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/compare", method = RequestMethod.GET)
	public ModelAndView compare(@RequestParam("input1") String input1,
			@RequestParam("input2") String input2, ModelMap model) {

		int result = (input1.compareTo(input2));
		String inEnglish = (result < 0) ? "less than"
				: (result > 0 ? "greater than" : "equal to");
		String output = "According to our Comparator, '" + input1 + "' is "
				+ inEnglish + "'" + input2 + "'";
		model.addAttribute("output", output);
		System.out.println("output: " + output);
		return new ModelAndView("web/compareResult", model);
	}

	public String getHomeMessage() {
		return homeMessage;
	}

	public void setHomeMessage(String homeMessage) {
		this.homeMessage = homeMessage;
	}
}

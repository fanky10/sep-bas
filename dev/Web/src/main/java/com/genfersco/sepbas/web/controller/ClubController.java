package com.genfersco.sepbas.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.ClubForm;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClubController extends BaseController {

	@Autowired
	private ServicesManager servicesManager;

	@RequestMapping(value = "/clubes/add", method = RequestMethod.GET)
	public String agregarClub(ModelMap map) {
		// shows view
		map.addAttribute("clubForm", new ClubForm());
		return WebAppConstants.AGREGAR_CLUB;
	}

	@RequestMapping(value = "/clubes/add", method = RequestMethod.POST)
	public String agregarClub(ModelMap map, @ModelAttribute ClubForm clubForm) {
		// TODO: some validation here
		Club club = new Club();
                club.setId(clubForm.getId());
		club.setNombre(clubForm.getNombre());
                club.setLocalidad(clubForm.getLocalidad());
		servicesManager.addClub(club);
		map.addAttribute("clubForm", clubForm);
		return "redirect:/clubes/list";
	}
        @RequestMapping(value = "/clubes/edit/{clubId}", method = RequestMethod.GET)
	public String editarClub(@PathVariable("clubId") String id, ModelMap map) {
            
            ClubForm clubForm = new ClubForm();
            Club club = servicesManager.getClub(id);
            if(club!=null){
                clubForm.setId(club.getId());
                clubForm.setNombre(club.getNombre());
                clubForm.setLocalidad(club.getLocalidad());
            }
            map.addAttribute("clubForm", clubForm);
            return WebAppConstants.AGREGAR_CLUB;
        }
        @RequestMapping(value = "/clubes/list", method = RequestMethod.GET)
	public String getClubes(Model map) {
		List<Club> clubes = servicesManager.getClubes();
		map.addAttribute("clubes", clubes);
		return WebAppConstants.CLUBES;
	}
	
        @RequestMapping(value = "/clubes/del/{clubId}", method = RequestMethod.GET)
	public String deleteClub(@PathVariable("clubId") Integer id, Model map) {
            servicesManager.deleteClub(id);
            return "redirect:/clubes/list";
	}
        

}

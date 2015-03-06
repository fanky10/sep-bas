package com.genfersco.sepbas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genfersco.sepbas.app.services.ServicesManager;
import com.genfersco.sepbas.domain.model.Arbitro;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import com.genfersco.sepbas.web.form.ArbitroForm;
import com.genfersco.sepbas.web.json.DefaultJSONResponse;
import com.genfersco.sepbas.web.json.JSONResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArbitroController extends BaseController {
	@Autowired
	private ServicesManager servicesManager;

	/*@RequestMapping(value = "/arbitros/add", method = RequestMethod.GET)
	public String addArbitro(ModelMap map) {
		return WebAppConstants.AGREGAR_ARBITRO;
	}

	@RequestMapping(value = "/arbitros/add", method = RequestMethod.POST)
	public String agregarArbitro(ModelMap map, @ModelAttribute ArbitroForm arbitroForm) {
		// add logic
		return "redirect:/arbitros/list";
	}
        */
        @RequestMapping(value = "/arbitros/add", method = RequestMethod.GET)
	public String agregarArbitro(ModelMap map) {
		// shows view
		map.addAttribute("arbitroForm", new ArbitroForm());
		return WebAppConstants.AGREGAR_ARBITRO;
	}
        /*VER ERRORES CON PABLITO/FACU */
	@RequestMapping(value = "/arbitros/add", method = RequestMethod.POST)
	public String agregarArbitro(ModelMap map, @Valid @ModelAttribute ArbitroForm arbitroForm,  BindingResult result) {
		// TODO: some validation here 
                if (result.hasErrors())
                    return WebAppConstants.AGREGAR_ARBITRO;
		Arbitro arbitro = new Arbitro();
		//arbitro.setArbitro(arbitroForm.getArbitro());
                arbitro.setId(arbitroForm.getId());
                arbitro.setNombre(arbitroForm.getNombre());
                arbitro.setApellido(arbitroForm.getApellido());
                arbitro.setLocalidad(arbitroForm.getLocalidad());
		servicesManager.saveArbitro(arbitro);
		map.addAttribute("arbitroForm", arbitroForm);
		return "redirect:/arbitros/list";
	}
        @RequestMapping(value = "/arbitros/edit/{arbitroId}", method = RequestMethod.GET)
	public String editarArbitro(@PathVariable("arbitroId") Integer id, ModelMap map) {
		// shows view
                Arbitro arbitro = servicesManager.getArbitro(id);

                ArbitroForm arbitroForm = new ArbitroForm();
                arbitroForm.setId(id);
                arbitroForm.setNombre(arbitro.getNombre());
                arbitroForm.setLocalidad(arbitro.getLocalidad());
                arbitroForm.setApellido(arbitro.getApellido());
                
		map.addAttribute("arbitroForm", arbitroForm);
		return WebAppConstants.AGREGAR_ARBITRO;
	}
        
	@RequestMapping(value = "/arbitros/list", method = RequestMethod.GET)
	public String getArbitros(Model map) {
            List<Arbitro> arbitros = servicesManager.getArbitrosHabilitados();
            map.addAttribute("arbitros", arbitros);
            return WebAppConstants.ARBITROS;
	}
        
        @RequestMapping(value = "/arbitros/del/{arbitroId}", method = RequestMethod.GET)
	public String deleteArbitro(@PathVariable("arbitroId") Integer id, Model map) {
            servicesManager.eliminarArbitro(id);
            return "redirect:/arbitros/list";
	}

	@RequestMapping(value = "/arbitros/delete.json", method = RequestMethod.POST)
	public @ResponseBody
	JSONResponse jsonDeleteJugador(@RequestParam("id") String id, Model map) {
		JSONResponse response = new DefaultJSONResponse("ERROR",
				"No implementado");
		return response;
	}

}

package com.genfersco.sepbas.web.controller;

import com.genfersco.sepbas.services.controller.ResponseMessage;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvironmentController extends BaseController {

    @RequestMapping(value = "/environment/services", method = RequestMethod.GET)
    public String getServices(Model map) {
        String vcapServices = java.lang.System.getenv("VCAP_SERVICES");
        map.addAttribute("vcapServices", vcapServices);
        return "web/services";
    }

    @RequestMapping(value = "/environment/session/{sessionKey}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getSessionStatus(@PathVariable(value = "sessionKey") String sessionKey, HttpSession session) {
        Object o = session.getAttribute(sessionKey);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode("0");
        responseMessage.setContent(o);
        return responseMessage;
    }

}

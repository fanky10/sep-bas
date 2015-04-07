/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.services.controller;

import com.genfersco.sepbas.app.services.ReportsManager;
import com.genfersco.sepbas.app.services.vo.CuartoReportVO;
import com.genfersco.sepbas.domain.model.Partido;
import com.genfersco.sepbas.domain.repository.PartidoRepository;
import com.genfersco.sepbas.web.constants.WebAppConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Facundo Scoccia <fanky10@gmail.com>
 */
@Controller
public class ReportesAPIController extends AbstractAPIController {

    @Autowired
    private PartidoRepository partidoRepository;
    @Autowired
    private ReportsManager reportsManager;

    @RequestMapping(value = "/reportes/partido/{idPartido}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getPartido(@PathVariable("idPartido") Integer idPartido, HttpServletRequest request, WebRequest webRequest) {
        ResponseMessage message = new ResponseMessage();
        message.setCode("-1");
        message.setMessage("Invalid partido id");
        Map<String, Object> report = new HashMap<String, Object>();
        
        if (idPartido > 0) {
            Partido partido = partidoRepository.findOne(idPartido);

            if (partido != null) {
                List<CuartoReportVO> cuartos = reportsManager.getCuartosReport(idPartido);
                report.put("partido", partido);
                report.put("cuartos", cuartos);
                message.setCode(WebAppConstants.RESPONSE_CODE_OK);
                message.setContent(report);
            } else {
                message.setMessage("Partido not found with id: " + idPartido);
            }
        }

        return message;
    }

}

package org.woadec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.Division;
import org.woadec.services.DivisionService;
import org.woadec.urls.DivisionURLS;

@Controller("divisionController")
@RequestMapping(value = DivisionURLS.DIVISION)
public class DivisionController {

	@Autowired
	private DivisionService divisionService;

	@RequestMapping(value = DivisionURLS.GET_CLENT_ALL_DIVISION, method = RequestMethod.GET)
	@ResponseBody
	public List<Division> ClientRetreiveAllDivision() {
		return divisionService.retreiveAll();
	}

}

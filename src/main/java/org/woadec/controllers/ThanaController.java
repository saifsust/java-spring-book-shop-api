package org.woadec.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.Thana;
import org.woadec.services.ThanaService;
import org.woadec.urls.ThanaURLS;

import com.mysql.cj.xdevapi.JsonArray;

@Controller("thanaController")
@RequestMapping(value = ThanaURLS.THANA)
public class ThanaController {
	@Autowired
	private ThanaService thanaService;

	@RequestMapping(value = ThanaURLS.GET_THANAS, method = RequestMethod.GET)
	@ResponseBody
	public List<Thana> getThanas() {
		return thanaService.getAll();

	}

	@RequestMapping(value = ThanaURLS.POST_THANA, method = RequestMethod.POST)
	@ResponseBody
	public void upload(@RequestBody Thana thana) {
		thanaService.insert(new Thana(thana.getThana_name()));
	}

}

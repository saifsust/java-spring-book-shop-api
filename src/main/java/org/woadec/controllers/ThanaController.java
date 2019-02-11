package org.woadec.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.Thana;
import org.woadec.services.ThanaService;
import org.woadec.urls.ThanaUrlContents;

import com.mysql.cj.xdevapi.JsonArray;

@Controller("thanaController")
@RequestMapping(value = ThanaUrlContents.THANA)
public class ThanaController {

	private static final Logger logger = LoggerFactory.getLogger(ThanaController.class);
	@Autowired
	private ThanaService thanaService;

	@RequestMapping(value = ThanaUrlContents.GET_THANAS, method = RequestMethod.GET)
	@ResponseBody
	public List<Thana> getThanas() {

		logger.info("ThanaController getThana log INFO : ");

		List<Thana> list = thanaService.getAll();

		if (list == null)
			logger.error("ERROR");

		JsonArray json;

		return list;
	}

	// @RequestMapping(value = ThanaUrlContents.GET_THANAS, method =
	// RequestMethod.GET)
	public ResponseEntity<String> get() {

		thanaService.insert();

		return (ResponseEntity<String>) ResponseEntity.badRequest().body("Hello SIAFUL");
	}

	@RequestMapping(value = ThanaUrlContents.POST_THANA, method = RequestMethod.POST)
	public void upload(Thana thana) {
	}

	@RequestMapping(value = "/single", method = RequestMethod.GET)
	@ResponseBody
	public Thana getSingle() {
		return thanaService.get();
	}

}

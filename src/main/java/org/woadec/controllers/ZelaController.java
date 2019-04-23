package org.woadec.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.Zela;
import org.woadec.services.ZelaService;
import org.woadec.urls.ZelaURLS;

@Controller("zelaController")
@RequestMapping(value = ZelaURLS.ZELA)
public class ZelaController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ZelaController.class);
	@Autowired
	private ZelaService zelaService;

	@RequestMapping(value = ZelaURLS.GET_ZELAS, method = RequestMethod.GET)
	@ResponseBody
	public List<Zela> getAllZelas(HttpServletRequest request, HttpServletResponse response) {
		try {
			return zelaService.retreiveAll();
		} catch (Exception ex) {
			log.error("ZelaController getAllZela : " + ex.getMessage());
		}

		return null;
	}

}

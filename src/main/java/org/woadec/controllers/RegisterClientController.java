package org.woadec.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.RegisterClient;
import org.woadec.entities.Thana;
import org.woadec.services.RegisterClientService;
import org.woadec.urls.RegisterClientURLS;

import com.google.gson.Gson;

@Controller("homeController")
@RequestMapping(value = RegisterClientURLS.REGISTER_CLIENT)
public class RegisterClientController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterClientController.class);

	@Autowired
	private RegisterClientService registerClientService;

	@RequestMapping(value = "/install", method = RequestMethod.GET)
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) {

		try {
			registerClientService.install();
			logger.info("database installed successfully");
		} catch (Exception ex) {
			// TODO: handle exception
			logger.error("database does not installed ! " + ex.getMessage());
		}

		return "install successfully";

	}

	@RequestMapping(value = RegisterClientURLS.GET_REGISTER_CLIENTS, method = RequestMethod.GET)
	@ResponseBody
	public List<RegisterClient> retreiveAll(HttpServletRequest request, HttpServletResponse reponse) {
		logger.info("retrieveall method is called ! " + request.getRequestURI());
		return registerClientService.all();
	}

	@RequestMapping(value = RegisterClientURLS.POST_REGISTER_CLIENT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RegisterClient upload(@RequestBody RegisterClient client) {
		logger.info("upload method is called successfully !" + client);
		registerClientService.insert(client);
		return client;
	}
	
}

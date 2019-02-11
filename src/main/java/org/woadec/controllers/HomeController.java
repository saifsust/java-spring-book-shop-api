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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.RegisterClient;
import org.woadec.services.RegisterClientService;
import org.woadec.urls.RegisterClientUrlContents;

@Controller("homeController")
@RequestMapping(value = RegisterClientUrlContents.REGISTER_CLIENT)
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private RegisterClientService registerClientService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public RegisterClient index(HttpServletRequest request, HttpServletResponse response) {

		logger.info("HomeController Logger INFO : ");

		System.out.println("Hello Controller");

		System.out.println();

		return registerClientService.insertData();

	}

	@RequestMapping(value = RegisterClientUrlContents.GET_REGISTER_CLIENTS, method = RequestMethod.GET)
	@ResponseBody
	public List<RegisterClient> retreiveAll(HttpServletRequest request, HttpServletResponse reponse) {
		System.out.println(request.getRequestURL());

		return registerClientService.all();
	}

	@RequestMapping(value = RegisterClientUrlContents.POST_REGISTER_CLIENT, method = RequestMethod.POST)
	public void upload(@RequestParam("registerClient") RegisterClient client) {
		System.out.println("Hello ");
		System.out.println(client);
		registerClientService.insert(client);
	}
	
	
	

}

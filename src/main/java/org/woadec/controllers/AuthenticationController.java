package org.woadec.controllers;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.services.RegisterClientService;
import org.woadec.urls.AuthenticationURLS;

@Controller("authenticationController")
@RequestMapping(value = AuthenticationURLS.AUTHENTICATION)
public class AuthenticationController {

	private static final Logger Log = (Logger) LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private RegisterClientService registerClientService;

	/**
	 * 
	 * 
	 * @param userInfo
	 * @return
	 */
	
	
	@RequestMapping(value = AuthenticationURLS.IS_AUTHORIZED_USER, method = RequestMethod.POST)
	@ResponseBody
	public JSONObject isAuthorizedUser(@RequestBody JSONObject userInfo) {
		Log.info("isAuthorizerUser is called " + userInfo.toString());
		return registerClientService.isAuthorized(userInfo);
	}

	/**
	 * @return
	 */
	
	public String smsVerification() {
		return null;
	}
	
	
	

}

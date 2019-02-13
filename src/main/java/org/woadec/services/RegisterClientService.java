package org.woadec.services;

import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.RegisterClient;
import org.woadec.repositories.RegisterClientRepository;

@Service("registerClientService")
public class RegisterClientService {

	private static final Logger Log = (Logger) LoggerFactory.getLogger(RegisterClientService.class);

	@Autowired
	private RegisterClientRepository registerClientRepository;

	@Transactional
	public void install() throws Exception {
		registerClientRepository.install();
	}

	@Transactional
	public void insert(RegisterClient client) {
		registerClientRepository.insert(client);
	}

	@Transactional
	public List<RegisterClient> all() {
		return registerClientRepository.retreiveAll();
	}

	public JSONObject isAuthorized(JSONObject userInfo) {
		JSONObject token = new JSONObject();

		try {
			String email = userInfo.get("email").toString();
			String password = userInfo.get("password").toString();
			RegisterClient client = registerClientRepository.findByEmail(email);

			if (client.getEmail().equals(email) && client.getClientPassword().equals(password)) {
				token.put("token", true);
				Log.info("authentication is done" + userInfo.toString());
				return token;
			}

			token.put("token", false);

		} catch (Exception e) {
			Log.error("isAuthorized error : " + e.getMessage());
		}

		return token;
	}

}

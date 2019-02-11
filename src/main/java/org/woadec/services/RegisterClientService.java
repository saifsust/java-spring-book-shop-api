package org.woadec.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.RegisterClient;
import org.woadec.repositories.RegisterClientRepository;

@Service("registerClientService")
public class RegisterClientService {

	@Autowired
	private RegisterClientRepository registerClientRepository;

	@Transactional
	public RegisterClient insertData() {

		RegisterClient client = new RegisterClient();
		client.setFirstName("Saiful");
		client.setLastName("Islam");
		client.setEmail("saiful.sust.cse@gmail.com");
		client.setLocation("Bhuiyanpara");
		client.setPhoneNumber("01521515170");
		client.setImageLink("http://saiful/image");
		client.setThanaId(1);
		client.setZeladId(1);
		client.setDevisionId(1);
		client.setPostOfficeCode(1);

		registerClientRepository.insert(client);

		return client;

	}

	@Transactional
	public void insert(RegisterClient client) {
		registerClientRepository.insert(client);
	}

	@Transactional
	public List<RegisterClient> all() {
		return registerClientRepository.retreiveAll();
	}

}

package org.woadec.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.Zela;
import org.woadec.repositories.ZelaRepository;

@Service
public class ZelaService {

	@Autowired
	private ZelaRepository zelaRepository;

	@Transactional
	public List<Zela> retreiveAll() {
		return zelaRepository.retreiveAll();
	}

}

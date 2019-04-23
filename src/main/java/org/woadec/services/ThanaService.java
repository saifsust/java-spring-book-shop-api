package org.woadec.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.Thana;
import org.woadec.repositories.ThanaRepository;

@Service("thanaService")
public class ThanaService {
	@Autowired
	private ThanaRepository thanaRepository;

	@Transactional
	public void insert(Thana thana) {
		thanaRepository.insert(thana);
	}

	@Transactional
	public List<Thana> getAll() {
		return thanaRepository.retreiveAll();
	}

	public Thana get() {
		return thanaRepository.findById(1);
	}

}

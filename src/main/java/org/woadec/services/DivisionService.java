package org.woadec.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.Division;
import org.woadec.repositories.DivisionRepository;

@Service
public class DivisionService {

	@Autowired
	private DivisionRepository divisionRepository;

	@Transactional
	public List<Division> retreiveAll() {
		return divisionRepository.retreiveAll();
	}
}

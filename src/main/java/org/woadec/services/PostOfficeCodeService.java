package org.woadec.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.PostOfficeCode;
import org.woadec.repositories.PostOfficeServiceRepository;

@Service("postOfficeCodeService")
public class PostOfficeCodeService {
	@Autowired
	private PostOfficeServiceRepository postOfficeServiceRepository;

	@Transactional
	public void insert(PostOfficeCode model) {
		postOfficeServiceRepository.insert(model);
	}

	@Transactional
	public List<PostOfficeCode> retrieveAll() {
		return postOfficeServiceRepository.retreiveAll();
	}

}

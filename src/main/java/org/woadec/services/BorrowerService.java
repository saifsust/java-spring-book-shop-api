package org.woadec.services;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.Borrower;
import org.woadec.repositories.BorrowerRepository;

@Service("borrowerService")
public class BorrowerService {

	@Autowired
	private BorrowerRepository borrowerRepository;

	public List<Borrower> retreiveAll() {
		return borrowerRepository.retrieveAll();
	}

	public List<Borrower> report(int bookId) {
		return borrowerRepository.getReport(bookId);
	}
}

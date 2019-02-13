package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.Borrower;

@Repository
public class BorrowerRepository implements QueryMethods<Borrower> {

	private static final Logger log = (Logger) LoggerFactory.getLogger(BorrowerRepository.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Borrower model) {
		try {

			em.persist(model);

		} catch (Exception ex) {

		}
	}

	@Override
	public void insert(String values) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String set) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Borrower> retreiveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borrower findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

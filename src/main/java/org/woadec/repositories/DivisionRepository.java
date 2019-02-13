package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.Division;
import org.woadec.migrations.Migrate;

@Repository
public class DivisionRepository implements QueryMethods<Division> {

	private static final Logger log = (Logger) LoggerFactory.getLogger(DivisionRepository.class);
	@PersistenceContext
	private EntityManager em;

	private String SQL;

	@Override
	public void insert(Division model) {
		// TODO Auto-generated method stub
		try {
			em.persist(model);
			log.info("insert division successfully (insert @param model) :" + model);
		} catch (Exception ex) {
			log.error("division can not insert (insert @param model ) : " + ex.getMessage());
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
	public List<Division> retreiveAll() {

		try {
			SQL = "SELECT * FROM " + Migrate.DIVISION;
			Query query = em.createNativeQuery(SQL, Division.class);
			List<Division> results = query.getResultList();
			log.info("divisions are fetched successfully (retreiveAll) : " + results);
			return results;
		} catch (Exception ex) {
			log.error("divisions are not fetched (retreiveAll) :  " + ex.getMessage());
		}

		return null;
	}

	@Override
	public Division findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

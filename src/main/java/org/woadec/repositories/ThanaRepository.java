package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.Thana;

@Repository("thanaRepository")
public class ThanaRepository implements QueryMethods<Thana> {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(ThanaRepository.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Thana model) {
		// TODO Auto-generated method stub

		try {
			em.persist(model);
			logger.info("Thana is inserted Successfull (insert @param model) : " + model);
		} catch (Exception ex) {
			logger.error("Thana can not inserted (insert @param model) : " + ex.getMessage());
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
	public List<Thana> retreiveAll() {

		try {
			String SQL = "SELECT * FROM thanas";
			Query query = em.createNativeQuery(SQL, Thana.class);
			List<Thana> results = query.getResultList();
			logger.info("Thanas are fetched Successfull (retreiveAll) : " + results);
			return results;

		} catch (Exception ex) {
			logger.error("thanas are not fetched (retreiveall) : " + ex.getMessage());
		}
		return null;

	}

	@Override
	public Thana findById(int id) {

		String SQL = "SELECT * FROM thanas WHERE thana_id = " + id;
		Query query = em.createNativeQuery(SQL, Thana.class);
		return (Thana) query.getSingleResult();
	}

}

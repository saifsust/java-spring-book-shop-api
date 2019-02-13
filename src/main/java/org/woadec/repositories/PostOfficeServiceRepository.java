package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.PostOfficeCode;

import ch.qos.logback.classic.Logger;

@Repository
public class PostOfficeServiceRepository implements QueryMethods<PostOfficeCode> {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(PostOfficeServiceRepository.class);

	@PersistenceContext
	private EntityManager em;

	private String SQL;

	@Override
	public void insert(PostOfficeCode model) {
		try {

			em.persist(model);
			logger.info("Post Office Code is successfyll inserted by insert @param model : " + model);

		} catch (Exception ex) {
			logger.error("insert @param model : " + ex.getMessage());

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
	public List<PostOfficeCode> retreiveAll() {

		try {
			SQL = "SELECT * FROM post_office_codes";
			Query query = em.createNativeQuery(SQL, PostOfficeCode.class);
			List<PostOfficeCode> results = query.getResultList();
			logger.info("All Post Office Codes are fetched successfull " + results);
			return results;

		} catch (Exception ex) {
			// TODO: handle exception
			logger.error("In retrieveAll method some errors occure : " + ex.getMessage());
		}
		return null;
	}

	@Override
	public PostOfficeCode findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

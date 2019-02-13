package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.dialect.pagination.SQL2008StandardLimitHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.RegisterClient;
import org.woadec.migrations.Migrations;

import com.mysql.cj.log.Log;

@Repository
public class RegisterClientRepository implements QueryMethods<RegisterClient> {

	private static final Logger log = (Logger) LoggerFactory.getLogger(RegisterClientRepository.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void install() {
		try {

			Migrations.getInstance().buildEntities(entityManager);
			log.info("DATABASE INSTALL SUCCESSFULLY");
		} catch (Exception ex) {
			log.error("database does not installed " + ex.getMessage());
		}
	}

	@Override
	public void insert(RegisterClient model) {
		try {
			entityManager.persist(model);
			log.info("RegisterClient insert Successfully (insert @param model ) : " + model);

		} catch (Exception ex) {
			log.error("RegisterClient does not insert (insert @param model ) :" + ex.getMessage());
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
	public List<RegisterClient> retreiveAll() {

		try {
			String SQL = "SELECT * FROM " + Migrations.REGISTER_CLIENT;
			Query query = entityManager.createNativeQuery(SQL, RegisterClient.class);
			List<RegisterClient> results = query.getResultList();
			log.info("client are fetched successsfully (retreiveAll ) : " + results);
			return results;
		} catch (Exception ex) {
			log.error("Clients are not fetched (retreiveAll) : " + ex.getMessage());
		}

		return null;

	}

	@Override
	public RegisterClient findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public RegisterClient findByEmail(String email) {
		String SQL = "SELECT * FROM " + Migrations.REGISTER_CLIENT + " WHERE email ='" + email + "'";
		Query query = entityManager.createNativeQuery(SQL, RegisterClient.class);
		log.info("findByEmail : " + query.getSingleResult());
		return (RegisterClient) query.getSingleResult();

	}

}

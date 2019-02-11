package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.woadec.entities.RegisterClient;
import org.woadec.migrations.Migrations;

@Repository
public class RegisterClientRepository implements QueryMethods<RegisterClient> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(RegisterClient model) {
		try {
			Migrations.getInstance().buildEntities(entityManager);
			entityManager.persist(model);
		} catch (Exception ex) {
			System.out.println("ERROR : " + ex.getMessage());
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

		String SQL = "SELECT * FROM " + Migrations.REGISTER_CLIENT;
		Query query = entityManager.createNativeQuery(SQL, RegisterClient.class);
		return query.getResultList();

	}

	@Override
	public RegisterClient findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

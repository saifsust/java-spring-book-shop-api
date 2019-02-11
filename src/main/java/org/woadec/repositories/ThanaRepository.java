package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.woadec.entities.Thana;

@Repository("thanaRepository")
public class ThanaRepository implements QueryMethods<Thana> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Thana model) {
		// TODO Auto-generated method stub

		try {
			em.persist(model);
		} catch (Exception ex) {
			System.out.println("ThanaRepository Insert Exception : " + ex.getMessage());
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
		String SQL = "SELECT * FROM thanas";
		Query query = em.createNativeQuery(SQL, Thana.class);
		return query.getResultList();
	}

	@Override
	public Thana findById(int id) {

		String SQL = "SELECT * FROM thanas WHERE thana_id = "+id;
		Query query = em.createNativeQuery(SQL, Thana.class);
		return (Thana) query.getSingleResult();
	}

}

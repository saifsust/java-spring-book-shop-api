package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.Zela;
import org.woadec.migrations.Migrate;

@Repository
public class ZelaRepository implements QueryMethods<Zela> {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ZelaRepository.class);

	@PersistenceContext
	private EntityManager em;

	private String SQL;

	@Override
	public void insert(Zela model) {

		try {
			em.persist(model);

			log.info("Zela insert Successfully (insert @param model ): " + model);

		} catch (Exception ex) {
			log.error("Zela can not insert (insert param model ): " + ex.getMessage());
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
	public List<Zela> retreiveAll() {

		try {

			SQL = "SELECT * FROM " + Migrate.ZELA;
			Query query = em.createNativeQuery(SQL, Zela.class);

			List<Zela> results = query.getResultList();
			log.info("zelas are fetched successully (retreiveall) : " + results);
			return results;

		} catch (Exception ex) {
			log.error("zelas are not fetched (retreiveAll) : " + ex.getMessage());
		}

		return null;
	}

	@Override
	public Zela findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

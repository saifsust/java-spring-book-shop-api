package org.woadec.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.Book;
import org.woadec.migrations.Migrate;

@Repository
public class BookRepository implements QueryMethods<Book> {

	private static final Logger log = (Logger) LoggerFactory.getLogger(BookRepository.class);

	@PersistenceContext
	private EntityManager em;

	private String SQL;
	private Query query;

	@Override
	public void insert(Book model) {
		try {
			em.persist(model);
			log.info("INSERT Book Successfully (insert @param model ) : " + model);

		} catch (Exception ex) {
			log.error("does not insert book (insert @param model) :  " + ex.getMessage());
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
	public List<Book> retreiveAll() {
		// TODO Auto-generated method stub

		try {
			SQL = "SELECT * FROM " + Migrate.BOOK;

			Query query = em.createNativeQuery(SQL);
			List<Book> results = query.getResultList();
			log.info("Books are fetched successfully (retreiveAll ) : " + results);
			return results;

		} catch (Exception ex) {
			log.error("books are  not fetched (retreiveAll) : " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Book> findByName(String bookName) throws Exception {
		SQL = "SELECT * FROM " + Migrate.BOOK + " WHERE book_name = '" + bookName + "'";
		query = em.createNativeQuery(SQL, Book.class);
		List<Book> books = query.getResultList();
		log.info("fetched books successfully : " + books);
		return books;
	}

	private String process() {
		return null;
	}

}

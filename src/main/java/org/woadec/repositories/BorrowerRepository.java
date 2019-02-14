package org.woadec.repositories;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.woadec.entities.Book;
import org.woadec.entities.Borrower;
import org.woadec.entities.RegisterClient;
import org.woadec.migrations.Migrate;

@Repository
public class BorrowerRepository {

	private static final Logger log = (Logger) LoggerFactory.getLogger(BorrowerRepository.class);

	private String SQL;

	@PersistenceContext
	private EntityManager em;

	public List<Borrower> retrieveAll() {

		try {
			SQL = "SELECT * ";
			SQL += " FROM " + Migrate.BORROWER;
			// INNER JOIN WITH client
			SQL += " INNER JOIN " + Migrate.REGISTER_CLIENT;
			SQL += " ON fk_register_client_id = register_client_id ";
			// INNER JOIN WITH BOOK
			SQL += " INNER JOIN " + Migrate.BOOK;
			SQL += " ON fk_book_id = book_id";

			List<Borrower> borrowers = execute(SQL);
			log.info("retreiveAll : " + borrowers);

			return borrowers;
		} catch (Exception ex) {
			log.error("retreiveAll : " + ex.getMessage());

		}
		return null;
	}

	public List<Borrower> getReport(int bookId) {

		try {
			SQL = "SELECT * ";
			SQL += " FROM " + Migrate.BORROWER;
			// INNER JOIN WITH client
			SQL += " INNER JOIN " + Migrate.REGISTER_CLIENT;
			SQL += " ON fk_register_client_id = register_client_id ";
			// INNER JOIN WITH BOOK
			SQL += " INNER JOIN " + Migrate.BOOK;
			SQL += " ON fk_book_id = book_id  ";
			SQL += "WHERE ";

			SQL += Migrate.BORROWER + ".fk_book_id = " + bookId;

			List<Borrower> borrowers = execute(SQL);
			log.info("getReport : " + borrowers);
			return borrowers;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("getReport : " + e.getMessage());
		}

		return null;
	}

	private List<Borrower> execute(String SQL) throws Exception {
		Query query = em.createNativeQuery(SQL, Tuple.class);

		List<Borrower> borrowers = new ArrayList<>();
		List<Tuple> tuples = query.getResultList();

		for (Tuple tuple : tuples) {

			Book book = new Book();
			book.setBookId((int) tuple.get("book_id"));
			book.setBookName((String) tuple.get("book_name"));
			book.setBookImageLink((String) tuple.get("book_image_link"));
			book.setPublisher_id((int) tuple.get("publisher_id"));
			book.setTakenCopies((int) tuple.get("taken_copies"));
			book.setTotalCopies((int) tuple.get("total_copies"));

			RegisterClient client = new RegisterClient();

			client.setRegisterClientId((int) tuple.get("register_client_id"));
			client.setFirstName((String) tuple.get("first_name"));
			client.setLastName((String) tuple.get("last_name"));
			client.setEmail((String) tuple.get("email"));
			client.setImageLink((String) tuple.get("image_link"));
			client.setClientPassword((String) tuple.get("client_password"));
			client.setPhoneNumber((String) tuple.get("phone_number"));
			client.setLocation((String) tuple.get("location"));

			client.setZeladId((int) tuple.get("zela_id"));
			client.setPostOfficeCode((int) tuple.get("post_office_code"));
			client.setDevisionId((int) tuple.get("devision_id"));
			client.setThanaId((int) tuple.get("thana_id"));

			Date returnDate = (Date) tuple.get("receive_date");
			Date receiveDate = (Date) tuple.get("return_date");

			borrowers.add(new Borrower(client, book, receiveDate, returnDate));

		}

		return borrowers;

	}

}

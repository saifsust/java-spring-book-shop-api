package org.woadec.migrations;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Migrations implements Migrate {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Migrations.class);
	private static Migrations instance;

	private Migrations() {
	}

	public String buildEntities(EntityManager entityManager) {

		try {
			entityManager.createNativeQuery(create_database()).executeUpdate();
			// System.out.println(create_zela());
			entityManager.createNativeQuery(create_zela()).executeUpdate();
			entityManager.createNativeQuery(create_thana()).executeUpdate();
			entityManager.createNativeQuery(create_division()).executeUpdate();
			entityManager.createNativeQuery(create_post_office_code()).executeUpdate();
			entityManager.createNativeQuery(create_register_client()).executeUpdate();
			entityManager.createNativeQuery(create_book()).executeUpdate();
			entityManager.createNativeQuery(create_borrower()).executeUpdate();

			log.info("database installed successfully '.' ");

		} catch (Exception ex) {
			log.error("database does not installed ! " + ex.getMessage());
		}

		return null;
	}

	public static Migrations getInstance() {
		if (instance == null)
			return new Migrations();
		return instance;
	}

	private final String create_database() {
		String SQL = "CREATE DATABASE IF NOT EXISTS WOADEC";
		return SQL;
	}

	private final String create_register_client() {
		String SQL = SQL_INIT + REGISTER_CLIENT + "(";
		SQL += "register_client_id " + PRIMARY_KEY;
		SQL += "first_name varchar(50),";
		SQL += "last_name varchar(50),";
		SQL += "email varchar(100),";
		SQL += "client_password text(10000),";
		SQL += "phone_number varchar(45),";
		SQL += "image_link text,";
		SQL += "zela_id int(11),";
		SQL += "devision_id int(11),";
		SQL += "thana_id int(11),";
		SQL += "location varchar(100),";
		SQL += "post_office_code int(11)";
		SQL += ")";
		return SQL;
	}

	private final String create_zela() {

		String SQL = SQL_INIT + ZELA;
		SQL += "(";
		SQL += "zela_id " + PRIMARY_KEY;
		SQL += "zela_name varchar(50)";
		SQL += ")";
		return SQL;

	}

	private final String create_division() {

		String SQL = SQL_INIT + DIVISION;
		SQL += "(";
		SQL += "division_id " + PRIMARY_KEY;
		SQL += "division_name varchar(50)";
		SQL += ")";
		return SQL;

	}

	private final String create_thana() {

		String SQL = SQL_INIT + THANA;
		SQL += "(";
		SQL += "thana_id " + PRIMARY_KEY;
		SQL += "thana_name varchar(50)";
		SQL += ")";
		return SQL;

	}

	private final String create_post_office_code() {
		String SQL = SQL_INIT + POST_OFFICE_CODE;
		SQL += "(";
		SQL += "post_office_code_id " + PRIMARY_KEY;
		SQL += "post_office_code  varchar(50)";
		SQL += ")";
		return SQL;
	}

	private final String create_book() {
		String SQL = SQL_INIT + BOOK;
		SQL += "(";
		SQL += "book_id " + PRIMARY_KEY;
		SQL += "book_name varchar(300),";
		SQL += "writers varchar(400),";
		SQL += "publisher varchar(200),";
		SQL += "total_copies int,";
		SQL += "taken_copies int,";
		SQL += "book_image_link text";
		SQL += ")";
		return SQL;
	}

	private final String create_borrower() {
		String SQL = SQL_INIT + BORROWER;
		SQL += "(";
		SQL += "borrower_id " + PRIMARY_KEY;
		SQL += "register_client_id int(11),";
		SQL += "book_id int(11),";
		SQL += "receive_date date,";
		SQL += "return_date date";
		SQL += ")";
		return SQL;
	}

}

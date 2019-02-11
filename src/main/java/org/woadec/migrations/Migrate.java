package org.woadec.migrations;

public interface Migrate {
	public static final String SQL_INIT = "CREATE TABLE IF NOT EXISTS ";
	public static final String REGISTER_CLIENT = "register_clients";
	public static final String THANA = "thanas";
	public static final String DIVISION = "divisions";
	public static final String ZELA = "zelas";
	public static final String POST_OFFICE_CODE = "post_office_codes";
	public static final String BOOK = "books";
	public static final String BORROWER = "borrowers";
	public static final String PRIMARY_KEY = "int(11) not null auto_increment primary key,";

}

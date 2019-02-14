package org.woadec.entities;

import java.sql.Date;

public class Borrower {
	private int borrowerId;
	private RegisterClient registerClient;
	private Book book;
	private Date receiveDate;
	private Date returnDate;

	public Borrower() {
		super();
	}

	public Borrower(RegisterClient registerClient, Book book, Date receiveDate, Date returnDate) {
		super();
		this.registerClient = registerClient;
		this.book = book;
		this.receiveDate = receiveDate;
		this.returnDate = returnDate;
	}

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public RegisterClient getRegisterClient() {
		return registerClient;
	}

	public void setRegisterClient(RegisterClient registerClient) {
		this.registerClient = registerClient;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Borrower [borrowerId=" + borrowerId + ", registerClient=" + registerClient + ", book=" + book
				+ ", receiveDate=" + receiveDate + ", returnDate=" + returnDate + "]";
	}

}

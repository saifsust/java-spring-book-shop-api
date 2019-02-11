package org.woadec.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.BORROWER)
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "borrower_id")
	private int borrowerId;
	@Column(name = "register_client_id")
	private int registerClientId;
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "receive_date")
	private Date receiveDate;
	@Column(name = "return_date")
	private Date returnDate;

	public Borrower() {
		super();
	}

	public Borrower(int registerClientId, int bookId, Date receiveDate, Date returnDate) {
		super();
		this.registerClientId = registerClientId;
		this.bookId = bookId;
		this.receiveDate = receiveDate;
		this.returnDate = returnDate;
	}

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public int getRegisterClientId() {
		return registerClientId;
	}

	public void setRegisterClientId(int registerClientId) {
		this.registerClientId = registerClientId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
		return "Borrower [borrowerId=" + borrowerId + ", registerClientId=" + registerClientId + ", bookId=" + bookId
				+ ", receiveDate=" + receiveDate + ", returnDate=" + returnDate + "]";
	}

}

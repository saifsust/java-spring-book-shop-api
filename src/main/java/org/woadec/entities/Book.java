package org.woadec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.BOOK)
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "writers")
	private String writers;
	@Column(name = "publishers")
	private String publishers;
	@Column(name = "total_copies")
	private int totalCopies;
	@Column(name = "taken_copies")
	private int takenCopies;
	@Column(name = "book_image_link")
	private String bookImageLink;

	public Book() {
		super();
	}

	public Book(String bookName, String writers, String publishers, int totalCopies, int takenCopies,
			String bookImageLink) {
		super();
		this.bookName = bookName;
		this.writers = writers;
		this.publishers = publishers;
		this.totalCopies = totalCopies;
		this.takenCopies = takenCopies;
		this.bookImageLink = bookImageLink;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriters() {
		return writers;
	}

	public void setWriters(String writers) {
		this.writers = writers;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public int getTakenCopies() {
		return takenCopies;
	}

	public void setTakenCopies(int takenCopies) {
		this.takenCopies = takenCopies;
	}

	public String getBookImageLink() {
		return bookImageLink;
	}

	public void setBookImageLink(String bookImageLink) {
		this.bookImageLink = bookImageLink;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", writers=" + writers + ", publishers="
				+ publishers + ", totalCopies=" + totalCopies + ", takenCopies=" + takenCopies + ", bookImageLink="
				+ bookImageLink + "]";
	}

}

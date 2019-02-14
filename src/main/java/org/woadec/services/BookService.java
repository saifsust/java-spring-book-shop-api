package org.woadec.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woadec.entities.Book;
import org.woadec.repositories.BookRepository;

@Service("bookService")
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	private static final Logger log = (Logger) LoggerFactory.getLogger(BookService.class);

	public List<Book> findBookUsingBookName(String bookName) {
		try {
			List<Book> books = bookRepository.findByName(bookName);
			log.info("books are fetched " + books);
			return books;
		} catch (Exception ex) {
			log.error("can not fetch books by name : " + ex.getMessage());
		}
		return null;
	}

}

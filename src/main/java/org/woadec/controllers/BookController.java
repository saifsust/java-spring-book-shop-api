package org.woadec.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.Book;
import org.woadec.services.BookService;
import org.woadec.urls.BookURLS;

@Controller("bookController")
@RequestMapping(value = BookURLS.BOOK)
public class BookController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(BookController.class);
	private static final String NULL = "no";
	@Autowired
	private BookService BookService;

	@RequestMapping(value = BookURLS.BOOK_SEARCH, method = RequestMethod.POST)
	@ResponseBody
	List<Book> getSearchedBooks(@PathVariable("bookName") String bookName) {
		List<Book> books;

		try {
			log.info("search data : " + bookName);

			books = BookService.findBookUsingBookName(bookName);
			log.info("books : " + books);
			return books;
		} catch (Exception ex) {
			log.error("books can not fetch : " + ex.getMessage());
		}
		books = new ArrayList<>();
		Book book = new Book();
		book.setBookName(NULL);
		books.add(book);
		return books;
	}

}

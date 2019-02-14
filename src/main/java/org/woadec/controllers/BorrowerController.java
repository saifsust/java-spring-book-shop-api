package org.woadec.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.Borrower;
import org.woadec.services.BorrowerService;
import org.woadec.urls.BorrowerURLS;

@Controller("borrowerController")
@RequestMapping(value = BorrowerURLS.BORROWER)
public class BorrowerController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(BorrowerController.class);

	@Autowired
	private BorrowerService borrowerService;

	@RequestMapping(value = BorrowerURLS.BORROWER_REPORT, method = RequestMethod.POST)
	@ResponseBody
	public List<Borrower> report(@PathVariable("bookId") int bookId) {
		return borrowerService.report(bookId);
	}

}

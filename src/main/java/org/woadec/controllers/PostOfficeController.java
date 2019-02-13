package org.woadec.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woadec.entities.PostOfficeCode;
import org.woadec.services.PostOfficeCodeService;
import org.woadec.urls.PostOfficeCodeURLS;

@Controller("postOfficeController")
@RequestMapping(value = PostOfficeCodeURLS.POST_OFFICE_CODE)
public class PostOfficeController {

	@Autowired
	private PostOfficeCodeService PostOfficeCodeService;

	@RequestMapping(value = PostOfficeCodeURLS.GET_POST_OFFICE_CODES_FOR_CLIENTS, method = RequestMethod.GET)
	@ResponseBody
	public List<PostOfficeCode> getAllPostOfficeCodes(HttpServletRequest request, HttpServletResponse response) {
		return PostOfficeCodeService.retrieveAll();
	}

	@RequestMapping(value = PostOfficeCodeURLS.POST_POCS, method = RequestMethod.GET)
	@ResponseBody
	public String upload(PostOfficeCode model) {
		model = new PostOfficeCode("1219");
		PostOfficeCodeService.insert(model);
		return "INSERT SUCCESSFULLY";
	}

}

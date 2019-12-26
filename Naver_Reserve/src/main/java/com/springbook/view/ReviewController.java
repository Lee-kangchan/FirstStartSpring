package com.springbook.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@RequestMapping("/review")
	public String home(Model model) {

		return "/WEB-INF/views/reviewWrite.jsp"; 
	}
}
	
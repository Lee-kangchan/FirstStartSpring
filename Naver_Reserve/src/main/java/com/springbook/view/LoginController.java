package com.springbook.view;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.app.display.impl.DisplayService;
import com.springbook.app.display.impl.DisplayVO;
import com.springbook.app.product.impl.ProductService;
import com.springbook.app.product.impl.ProductVO;
import com.springbook.app.reservation.impl.ReservationService;
import com.springbook.app.reservation.impl.ReservationVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		return "/WEB-INF/views/login.jsp"; 
	}

	@RequestMapping(value = "/loading", method = RequestMethod.GET)
	public String loginSession(Model model,HttpSession session, @RequestParam("resrv_email") String id) {
		System.out.println(id);
		session.setAttribute("email", id);
		return "redirect:myreservation";
	}
}


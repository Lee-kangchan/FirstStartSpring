package com.springbook.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.app.display.impl.DisplayService;
import com.springbook.app.display.impl.DisplayVO;
import com.springbook.app.product.impl.ProductService;
import com.springbook.app.product.impl.ProductVO;
import com.springbook.app.reservation.impl.ReservationService;
import com.springbook.app.reservation.impl.ReservationVO;

@Controller
public class DetailController {
	@Autowired
	DisplayService displayService;

	@Autowired
	ProductService productService;
	
	@Autowired
	ReservationService reservationService;
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	
	@RequestMapping("/detail")
	public String home(Model model, @RequestParam("id")int id) {

		logger.info(id+":");
		model.addAttribute("product",productService.getDetailProduct(id));
		model.addAttribute("reservation",reservationService.getReservation(id));
		model.addAttribute("display",displayService.getDisplay(id));
		return "/WEB-INF/views/detail.jsp"; 
	}
}


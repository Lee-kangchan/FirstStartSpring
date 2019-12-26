package com.springbook.view;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.app.display.impl.DisplayService;
import com.springbook.app.display.impl.DisplayVO;
import com.springbook.app.product.impl.ProductService;
import com.springbook.app.product.impl.ProductVO;
import com.springbook.app.reservation.impl.ReservationService;
import com.springbook.app.reservation.impl.ReservationVO;

@Controller
public class ReservationController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping(value = "/reservation", method = RequestMethod.POST) 
	public String home(
			MultipartHttpServletRequest request,
			ModelMap model, 
			String name, 
			String tel,
			String email,
			int id) throws Exception {
		
		String [] value = request.getParameterValues("num");
		
		for(String vo : value) {
			logger.info(vo);
		}
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA); 
		Date currentTime = new Date();
		String oTime = date.format(currentTime); 
		
		ReservationVO vo = new ReservationVO();
		vo.setReservation_email(email);
		vo.setReservation_name(name);
		vo.setReservation_tel(tel);
		vo.setProduct_id(id);
		vo.setReservation_id(id);
		
		logger.info(name);
		logger.info(email);
		logger.info(tel);
		logger.info(id+"");
		logger.info(date.parse(oTime)+"");
		reservationService.insertReservation_info(vo);
		
		return "redirect:home"; 
	}
}
	
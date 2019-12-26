package com.springbook.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.app.product.impl.ProductService;
import com.springbook.app.product.impl.ProductVO;

@Controller
public class MyreservationController {
	private static final Logger logger = LoggerFactory.getLogger(MyreservationController.class);

	@Autowired
	ProductService productService;
	
	
	@RequestMapping(value = "/myreservation", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		ProductVO vo = new ProductVO();
		
		vo.setReservation_email(email);
		vo.setCancel_flag(0);
		model.addAttribute("normal", productService.getMyreservationProduct(vo));
		logger.info(productService.getMyreservationProduct(vo).toString());
		return "/WEB-INF/views/myreservation.jsp";
	}
	
	
	@RequestMapping(value= "/cancel", method = RequestMethod.GET)
	public @ResponseBody int CategoryAjax(Model model,@RequestParam("flag")int flag, HttpSession session) throws Exception {

		String email = (String) session.getAttribute("email");
		ProductVO vo = new ProductVO();
		vo.setCancel_flag(flag);
		vo.setReservation_email(email);
		productService.updateMyreservationProduct(vo);

		return flag;
	}
	

}

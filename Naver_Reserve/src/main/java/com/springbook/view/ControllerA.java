package com.springbook.view;




import java.util.List;

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
public class ControllerA {


	@Autowired
	ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ControllerA.class);
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		logger.info("get home");
		model.addAttribute("product",productService.getProduct());
		
		return "/WEB-INF/views/Mainpage.jsp"; 
	}
	
	@RequestMapping(value= "/ajax", method = RequestMethod.GET)
	public @ResponseBody List<ProductVO> CategoryAjax(Model model,@RequestParam("category123")int id ) throws Exception {

		
		logger.info("hi"+id);
		List<ProductVO> list;
		if(id==0) {
			list = productService.getProduct();
		}
		else {
			list = productService.getProductList(id);
		}

		return list;
	}
	

	 
} 
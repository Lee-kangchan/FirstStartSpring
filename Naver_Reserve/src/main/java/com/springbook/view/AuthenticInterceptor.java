package com.springbook.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(); //Session 값을 받아옴
		Object obj = session.getAttribute("email"); // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		
		if(obj != null) {
			response.sendRedirect("/login"); //login안되면 다시 로그인 폼으로 돌려 보냄 
			return false;
		}
		//preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐 허가받는 의미
		//따라서 true 받으면 url로  감
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
}

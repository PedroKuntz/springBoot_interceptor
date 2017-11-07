package com.springinterceptor.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("PRE HANDLE ----> Request" + request.getRequestURL());
		if (!request.getRequestURI().equals("/login")){
			String login = (String) request.getSession().getAttribute("user.login");
			if(login == null) {
				PrintWriter resp = response.getWriter();
				resp.println("Required authentication!");
				return false;
			}
		}
		System.out.println("Session Interceptor User Login: " + request.getSession().getAttribute("user.login"));
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	
}

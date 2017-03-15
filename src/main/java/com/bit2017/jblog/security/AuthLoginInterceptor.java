package com.bit2017.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit2017.jblog.service.UserService;
import com.bit2017.jblog.vo.UserVo;


public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	/*
	 * @Autowired private UserService service;
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());//값이 무엇인지
		
		System.out.println(request.getServletContext());//뭐임?
		
		UserService service = ac.getBean(UserService.class);
 
		UserVo vo = service.login(id, password); 
		if(vo == null)
		{ 
			response.sendRedirect(request.getContextPath()+"/jblog/user/login?result=fail");
		return false;
		}
		
		//인증처리
		System.out.println("authvovovovovovo=" + vo);
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser",vo);
		
		response.sendRedirect(request.getContextPath()+"/main");
		return false;
	}
}

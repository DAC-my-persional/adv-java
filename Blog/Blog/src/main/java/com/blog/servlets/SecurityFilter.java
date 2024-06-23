package com.blog.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Bin.LoginBin;

public class SecurityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			System.out.println("Security Filter init() started !!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Security Filter destroy() started !!");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		ArrayList<String> noCheckList = new ArrayList<String>();
		Collections.addAll(noCheckList, "index","newuser","login","register");
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpSession session= rq.getSession();
		LoginBin lb = (LoginBin) session.getAttribute("login");
		  String page = rq.getParameter("page");
		  if(!noCheckList.contains("page"))
		  {
			 HttpSession session1 = rq.getSession();
			 
			 if(lb == null || lb.getUser() == null)
			 {
				 HttpServletResponse resp = (HttpServletResponse) response;
				 resp.sendRedirect("default.jsp");
				 return;
			 }
		  }
		  chain.doFilter(request, response);
	}
}

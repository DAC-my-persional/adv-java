package com.blog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
		
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
	{
		String page = req.getParameter("page");
		String uri = "/WEB-INF/Views/index.jsp";
		
		if(page.equals("index"))
			uri = "/WEB-INF/Views/index.jsp";
		else if(page.equals("login"))
			uri = "/WEB-INF/Views/login.jsp";
		else if(page.equals("newuser"))
			uri = "/WEB-INF/Views/newuser.jsp";
		else if(page.equals("register"))
			uri = "/WEB-INF/Views/register.jsp";
		else if(page.equals("bloglist"))
			uri = "/WEB-INF/Views/bloglist.jsp";
		else if(page.equals("categories"))
			uri = "/WEB-INF/Views/categories.jsp";
		else if(page.equals("deleteBlog"))
			uri = "/WEB-INF/Views/deleteBlog.jsp";
		else if(page.equals("editCategories"))
			uri = "/WEB-INF/Views/editCategories.jsp";
		else if(page.equals("myBlogList"))
			uri = "/WEB-INF/Views/myBlogList.jsp";
		else if(page.equals("newblog"))
			uri = "/WEB-INF/Views/newblog.jsp";
		else
			System.out.println("Invalid Page !!");
		
		ServletContext servlet = this.getServletContext();
		 RequestDispatcher rd = servlet.getRequestDispatcher(uri);
		rd.forward(req, resp);
		
	}
	
}

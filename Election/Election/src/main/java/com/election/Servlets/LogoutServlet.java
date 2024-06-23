package com.election.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("</head>");
		out.println("<body>");
		

		ServletContext serv = this.getServletContext();
		String appTitle = serv.getInitParameter("AppTitle");
		out.printf("<h1>%s</h1>",appTitle);
		
		
		String userName = "";
		Cookie[] arr = request.getCookies();
		if(arr != null)
		{
			for(Cookie c : arr)
			{
				if(c.getName().equals("uname"));
				userName = c.getValue();
				break;
			}
		}
		out.printf("Good Bye,%s <hr/>\n",userName);
		
		// delete cookie 
		Cookie c = new Cookie("uname","");
		c.setMaxAge(-1);
		response.addCookie(c);
		
		// destroy session
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		out.println("Thank You for Voted .<br/><br/>");
		out.println("<a href='index.html'>Login Again</a>");
		out.println("</body>");
		out.println("</html>");
	}
}

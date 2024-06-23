package com.election.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.DAO.UserDAO;
import com.election.DAO.UserDaoImpl;
import com.election.entity.User;

//@WebServlet ("/vote");
public class VoteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("curuser");   // downcasting explicitly casting of User
		int userId = us.getId();
		String message = "";
		
		if(us.getStatus() == 0)
		{
			String candidateId = request.getParameter("candidate");
			int id = Integer.parseInt(candidateId);
			
			try(CandidateDAO candidate  = new CandidateDaoImpl())
			{
				// increment the voted count 
				candidate.incrementVote(id);
			}catch(Exception e)
			{
				e.printStackTrace();
				throw new ServletException();
			}
			message = "Your vote is registered successfully . <br/><br/>";
			
			try(UserDAO user = new UserDaoImpl())
			{
				user.updateStatus(userId, true);
			}catch(Exception e)
			{
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else
		{
			// if already used 
			message = "You have already voted . <br/><br/>";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("</head>");
		out.println("<body>");
//		out.println("<h3>Online Voting</h3>");
		

		ServletContext serv = this.getServletContext();
		String appTitle = serv.getInitParameter("AppTitle");
		out.printf("<h1>%s</h1>",appTitle);
		
		String userName = "";
		Cookie[] arr = request.getCookies();
		if(arr != null)
		{
			for(Cookie c:arr)
			{
				if(c.getName().equals("uname"))
				{
					userName = c.getValue();
					break;
				}
			}
		}
		out.printf("Hello, %s<hr/>\n", userName);
		out.println(message);
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Voted</title>");
//		out.println("<style>");
//		out.println("body {");
//		out.println("    font-family: Arial, sans-serif;");
//		out.println("    background-color: #f0f0f0;");
//		out.println("    margin: 0;");
//		out.println("    padding: 20px;");
//		out.println("}");
//		out.println("h1 {");
//		out.println("    text-align: center;");
//		out.println("    color: #333;");
//		out.println("}");
//		out.println("hr {");
//		out.println("    border: 1px solid #ccc;");
//		out.println("}");
//		out.println("</style>");
//		out.println("</head>");
//		out.println("<body>");
//
//		// Print application title
//		ServletContext serv = this.getServletContext();
//		String appTitle = serv.getInitParameter("AppTitle");
//		out.printf("<h1>%s</h1>", appTitle);
//
//		// Print user greeting
//		String userName = "";
//		Cookie[] arr = request.getCookies();
//		if(arr != null) {
//		    for(Cookie c:arr) {
//		        if(c.getName().equals("uname")) {
//		            userName = c.getValue();
//		            break;
//		        }
//		    }
//		}
//		out.printf("<p>Hello, %s</p>", userName);
//		out.println("<hr/>");
//
//		// Print message
//		out.println(message);
//
//		// Print sign out link
//		out.println("<p><a href='logout'>Sign Out</a></p>");
//
//		out.println("</body>");
//		out.println("</html>");

	}	
}

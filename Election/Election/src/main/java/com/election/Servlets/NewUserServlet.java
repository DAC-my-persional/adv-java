package com.election.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.DAO.UserDAO;
import com.election.DAO.UserDaoImpl;
import com.election.entity.User;

//@WebServlet ("/newUser");
public class NewUserServlet extends HttpServlet {

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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String date= request.getParameter("dob");
		Date dob = Date.valueOf(date);
		String sta = request.getParameter("status");
		int status = Integer.parseInt(sta);
		String role = request.getParameter("role");
		
		User user = new User(0,firstName,lastName,email,password,dob,status,role);
		
		int count = 0;
		
		try(UserDAO userdao = new UserDaoImpl())
		{
			count = userdao.save(user);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
			
		}
		
		if(count != 0)
		{
			response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		    out.println("<html>");
			out.println("<head>");
			out.println("<title>User status</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("USER ADDED SUCCESSFULLY <br/><br/>");
			out.println("<a href='index.html'>Login</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}

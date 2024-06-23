package com.election.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.DAO.UserDAO;
import com.election.DAO.UserDaoImpl;
import com.election.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

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
			String email = request.getParameter("email");
			// passwd has used because we store inside a
			String passwd = request.getParameter("passwd");
			
			try(UserDAO user = new UserDaoImpl())
			{
				User us = user.findByEmail(email);
				if(us != null && us.getPassword().equals(passwd))
				{
					Cookie c = new Cookie("uname", us.getFirstName());
					c.setMaxAge(3600);
					response.addCookie(c);
					System.out.println("Login Successfully " + us);
					
					HttpSession session = request.getSession();
					session.setAttribute("curuser", us);
					
					// if user is voter then it select for votes list 
					if(us.getRole().equals("voter"))
					{
						response.sendRedirect("candidateList");
						// forward method will load the page but this can change the url
//						RequestDispatcher rd = request.getRequestDispatcher("candidateList");
//						rd.forward(request, response);
						
//						String reurl = response.encodeUrl("result");
//						response.sendRedirect(reurl);
					}
					else
					{
						// if user is admin then it select for admin list
						response.sendRedirect("result");
					}
				}
				else
				{
					// login failed
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Login Failed</title>");
					out.println("</head>");
					out.println("<body>");
//					out.println("<h1>Bharat Online Voting</h1>");
					ServletContext serv = this.getServletContext();
					String appTitle = serv.getInitParameter("AppTitle");
					out.printf("<h1>%s</h1>",appTitle);
					
					out.println("Invalid email or password. <br/><br/>");
					out.println("<a href='index.html'>Login Again</a>");
					out.println("</body>");
					out.println("</html>");
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	

}

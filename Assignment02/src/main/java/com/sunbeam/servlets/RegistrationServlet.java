package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doMethod(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doMethod(req, resp);
	}

	protected void doMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dobString = req.getParameter("dob");
		Date dob = Date.valueOf(dobString);
		String role = req.getParameter("role");

		User u = new User(firstName, lastName, email, password, dob, 0, role);

		try (UserDao udao = new UserDaoImpl()) {
			int count = udao.save(u);
			System.out.println("users added : " + count);

//			String message = "User registration of" + firstName + " " + lastName + " is successfull!!!";
//			req.setAttribute("message", message);
			//cannot be done as the redirect or forward page is not a servlet but a static html page

			resp.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

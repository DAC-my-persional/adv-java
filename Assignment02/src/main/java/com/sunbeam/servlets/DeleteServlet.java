package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

@WebServlet("/delcand")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (CandidateDao udao = new CandidateDaoImpl()) {
			String idStr = req.getParameter("id");
			int id = Integer.parseInt(idStr);
			
			int count = udao.deleteById(id);
			
			String msg="User deleted Successfully!!!";
			req.setAttribute("message", msg);
			RequestDispatcher rd = req.getRequestDispatcher("result");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

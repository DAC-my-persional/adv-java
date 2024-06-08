package app.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/tata", loadOnStartup = 3, initParams = { @WebInitParam(name = "color", value = "orange"),
		@WebInitParam(name = "course", value = "DAC") })
public class SecServlet extends HttpServlet {
	private String color = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("SecondServlet.init() called");
		color = config.getInitParameter("color");
	}

	@Override
	public void destroy() {
		System.out.println("SecondServlet.destroy() called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doGet() called");
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doPost() called");
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Second</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>\n", color);
		out.println("<h1>Hii buddy, Second Servlet</h1>");
		out.println("</body>");
		out.println("</html>");

	}

}

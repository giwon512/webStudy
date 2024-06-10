package persistence;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessConfirm")
public class SessionConfirmServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("name : " + session.getAttribute("name") + "<br>");
		out.println("address : " + session.getAttribute("addr") + "<br>");
		out.println("Connection time : " + new Date(session.getCreationTime()) + "<br>");
		out.println("Expired Time : " + session.getMaxInactiveInterval() + "<br>");
		out.println("New : " + session.isNew() + "<br>");
		
		out.println("</body></html>");
		out.close();
	}
	
}

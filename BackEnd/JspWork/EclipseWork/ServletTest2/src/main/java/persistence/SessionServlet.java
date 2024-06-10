package persistence;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess")
public class SessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		
		if(name == null) {
			
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		session.setAttribute("addr", addr);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println(session.getAttribute("name") + "님 환영합니다.");
		out.println("</body></html>");
		out.close();
	}
	
}

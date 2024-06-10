package persistence;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cook")
public class CookieServlet extends HttpServlet{
	
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
		
		Cookie cookName = new Cookie("name", name);
		Cookie cookAddr = new Cookie("addr", addr);
		
		cookName.setMaxAge(60 * 60);
		cookAddr.setMaxAge(60 * 60);
		
		resp.addCookie(cookName);
		resp.addCookie(cookAddr);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("쿠키가 잘 저장되었습니다.");
		out.println("</body></html>");
		out.close();
	}
	
}

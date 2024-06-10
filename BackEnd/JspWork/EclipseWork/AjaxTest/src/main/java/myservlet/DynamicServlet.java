package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dynamic.do")
public class DynamicServlet extends HttpServlet{
	private int counter = 1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Cache-Control", "no-cache"); //무조건 새로고침을 하겠다는 뜻
		
		PrintWriter out = resp.getWriter();
		String msg = "";
		
		switch(counter % 5) {
		case 1:
			msg = "아는 것이 힘이다.";
			break;
		case 2:
			msg = "천리길도 한 걸음부터";
			break;
		case 3:
			msg = "콩 심은 데 콩 나고 팥 심은 데 팥 난다.";
			break;
		case 4:
			msg = "낫 놓고 기역자도 모른다.";
			break;
		case 0:
			msg = "구슬이 서 말이라도 꿰어야 보배다.";
			break;
		}
		counter++;
		
		out.println("<response>");
		out.println("<message>" + msg + "</message>");
		out.println("</response>");
		out.close();
	}
	
}

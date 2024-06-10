import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		Enumeration<String> names = req.getParameterNames();
		out.println("<html><body>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			
			String[] values = req.getParameterValues(name);
			out.println("<h2>당신이 선택한 " + name + "은 다음과 같습니다.<br></h2>");
			for(String v : values) {
				out.println("<li>" + v + "</li>");
			}
			
		}
		out.println("</body></html>");
		out.close();
	}
	
}

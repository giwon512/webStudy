import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test4Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		Enumeration<String> names = req.getParameterNames();
		out.println("<html><body>");
		out.println("<h1>Information</h1>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			
			String[] values = req.getParameterValues(name);
			if(name.equals("name")) {
				out.println(name  + " : " + values[0].toUpperCase() + "<br><br>");
			}
			else if(values.length == 1) {
				out.println(name  + " : " + values[0] + "<br><br>");
			}
			else {
				out.println(name);
				out.println("<o1>");
				for(String v : values) {
					out.println("<li>" + v + "</li>");
				}
				out.println("</o1><br>");
			}
		}
		out.println("</body></html>");
		out.close();
		
	}
	
}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class marketServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String[] values = req.getParameterValues("food");
		
		int result = 0;
			
		PrintWriter out = resp.getWriter();
		if(values != null) {
			for(String v : values) {
				result += Integer.parseInt(v);
			}
		}
		
		out.println("상품 가격의 총합은 : " + result);
		
		out.close();
	}
	
}

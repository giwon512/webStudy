import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class gradeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("euc-kr");
		
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		String type = req.getParameter("result");
		
		int result = 0;
			
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.println("<html><body>");
			if(type.equals("sum")) {
				result = (kor + eng + math);
				out.println("성적 총점은 " + result + "점입니다.");
			}
			else {
				result = (kor + eng + math) / 3;
				out.println("성적 평균은 " + result + "점입니다.");
			}
			out.println("</body></html>");
		}
		catch(Exception e) {
		}
		finally {
			out.close();
		}
	}
	
}

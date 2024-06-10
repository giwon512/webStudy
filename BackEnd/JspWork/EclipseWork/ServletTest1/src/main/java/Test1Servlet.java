import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = null;
		try{
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("euc-kr");
			
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
		
			out = resp.getWriter();
			out.println("<html><body>");
			if(req.getMethod().equals("POST")){
				out.println("<h1>Request POST Test</h1>");
			}
			else{
				out.println("<h1>Request GET Test</h1>");
			}
			
			out.println("당신이 보낸 데이터는 다음과 같습니다<br/>");
			out.println("이름은 " + name + "이고 주소는 " + addr + "입니다.");
			out.println("</body></html>");
		}
		catch(UnsupportedEncodingException e) {}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e) {}
		finally{
			out.close();
		}
	}
	
}

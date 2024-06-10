import javax.servlet.http.*;
import java.io.*;

public class ReqTest extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		PrintWriter out = null;
		try{
			req.setCharacterEncoding("euc-kr");
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
import javax.servlet.http.*;
import java.io.*;

public class ServletTest3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			PrintWriter out = resp.getWriter();
			out.println("<html><body>");
			out.println("<h1>This is Second Servlet</h1>");
			out.println("</body></html>");
			out.close();
		}
		catch(IOException e){
			return;
		}
	}
}
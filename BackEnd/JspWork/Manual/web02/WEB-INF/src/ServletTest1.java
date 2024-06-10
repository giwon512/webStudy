import javax.servlet.http.*;

public class ServletTest1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("Servlet Test Succeed");
	}
}
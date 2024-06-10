package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid.do")
public class validationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String birthDate = req.getParameter("birthDate");

		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		boolean isValid = true;
		
		try {
			form.parse(birthDate);
		} catch (ParseException e) {
			isValid = false;
			e.printStackTrace();
		}
		
		String msg = "날짜를 잘못 입력하였습니다.";
		if(isValid) {
			msg = "잘 입력하였습니다.";
		}
		
		resp.setContentType("text/xml;encoding=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<response>");
		out.println("<message>" + msg + "</message>");
		out.println("</response>");
		out.close();
	}
	
}

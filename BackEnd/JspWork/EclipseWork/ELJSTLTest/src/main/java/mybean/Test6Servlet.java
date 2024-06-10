package mybean;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/eltest.action")
public class Test6Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		req.setAttribute("visitCount", 100);
		
		String[] favoriteFoods = {"냉면", "돼지갈비", "순대국", "콩국수", "파스타"};
		req.setAttribute("foods", favoriteFoods);
		
		Person hong = new Person();
		Dog popee = new Dog();
		
		hong.setName("홍길동");
		popee.setName("뽀삐");
		hong.setDog(popee);
		
		req.setAttribute("person", hong);
		req.setAttribute("dog", popee);
		
		ArrayList<String> movies = new ArrayList<>();
		movies.add("aaaa");
		movies.add("bbbb");
		movies.add("cccc");
		movies.add("dddd");
		req.setAttribute("movies", movies);
		
		RequestDispatcher view = req.getRequestDispatcher("core/test4.jsp");
		view.forward(req, resp);
	}
	
}

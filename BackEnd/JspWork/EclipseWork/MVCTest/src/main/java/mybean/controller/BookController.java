package mybean.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.model.Book;

@WebServlet("/book")
public class BookController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");
		String url = "";
		
		HttpSession session = req.getSession();
		ArrayList<Book> bookList = (ArrayList<Book>)session.getAttribute("bookList");
		
			
		switch(command){
			case "shop" :
				url = "/WEB-INF/view/bookshop.jsp";
				break;
			case "bookshop" :
				url = "/WEB-INF/view/bookshop.jsp";
				
				if(bookList == null){
					bookList = new ArrayList<>();
				}
				bookList.add(getBook(req));
				session.setAttribute("bookList", bookList);
				break;
			case "checkout" :
				url = "/WEB-INF/view/checkout.jsp";
				break;
			case "del" :
				url = "/WEB-INF/view/bookshop.jsp";
				int cnt = Integer.parseInt(req.getParameter("cnt"));
				bookList.remove(cnt);
				break;
			default :
				break;
		}
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
	
	public Book getBook(HttpServletRequest request) {
		
		Book dto = new Book();
		String select = request.getParameter("book");
		String[] props = select.split(" / ");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		dto.setAuthor(props[1]);
		dto.setTitle(props[0]);
		dto.setPrice(Integer.parseInt(props[2]));
		dto.setQuantity(quantity);
	
		return dto;
	}
	
}

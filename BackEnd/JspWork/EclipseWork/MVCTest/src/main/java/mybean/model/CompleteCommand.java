package mybean.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompleteCommand implements ICommand{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) {
		//DB 연동 코드 생략
		return "/WEB-INF/view/member/registerComplete.jsp";
	}
	
}

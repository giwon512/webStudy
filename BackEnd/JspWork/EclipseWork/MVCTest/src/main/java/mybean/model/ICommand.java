package mybean.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp);
}

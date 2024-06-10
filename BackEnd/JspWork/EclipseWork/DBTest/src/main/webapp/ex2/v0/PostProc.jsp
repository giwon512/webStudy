<%@ page contentType="text/html; charset=utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="mybean.board.BoardDto" />
<jsp:setProperty property="*" name="dto" />

<jsp:useBean id="dao" class="mybean.board.BoardDao"></jsp:useBean>

<% 
	dao.setBoard(dto);
	response.sendRedirect("List.jsp"); 
%>

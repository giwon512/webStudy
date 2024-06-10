<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>shopping mall</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id != null){
%>
	<h1><%= session.getAttribute("id") %>님, 즐거운 쇼핑되세요.</h1>
	<ul>
		<li><a href="index.jsp">메인페이지</a></li>
		<li><a href="logout.jsp">로그아웃</a></li>
	</ul>
<% 	
	} else {
		response.sendRedirect("login.jsp?menu=shop");
	}
%>
</body>
</html>
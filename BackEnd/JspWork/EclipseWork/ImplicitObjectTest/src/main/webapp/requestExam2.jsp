<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("currentDate", new Date());
		Date today = (Date)request.getAttribute("currentDate");
	%>
	오늘은 <%= today %> 입니다.
	<br><br>
	
	<%
		request.removeAttribute("currentDate");
		today = (Date)request.getAttribute("currentDate");
	%>
	오늘은 <%= today %> 입니다.
</body>
</html>
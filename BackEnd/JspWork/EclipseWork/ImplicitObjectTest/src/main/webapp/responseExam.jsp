<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>responseExam.jsp</title>
</head>
<body>
	1. 다른 페이지로 이동
	<%
		//response.sendRedirect("requestExam2.jsp");
	%>
	<br>
	2. 선택에 의해 페이지 이동<br>
	<%
		request.setAttribute("param", "not null");
		String param = request.getParameter("param");
		if(param == null || param.isEmpty()){
	%>
			페이지 이동을 하지 않습니다.
	<%
		}
		else{
			response.sendRedirect("requestExam2.jsp");
		}
	%>
</body>
</html>
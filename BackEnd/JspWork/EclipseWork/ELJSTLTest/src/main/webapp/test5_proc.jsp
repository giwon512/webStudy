<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>두 수의 덧셈</h2>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	%>
	<%= num1 %> + <%= num2 %> = <%= num1 + num2 %>
	<hr>
	${param.num1 } + ${param.num2 } = ${param.num1 + param.num2 }<br>
	
	<hr>
	
	<h2>두 수는 모두 양수인가?</h2>
	${(param.num1 gt 0) and  (param.num2 gt 0)}<hr>
	
	<h2>두 숫자가 모두 걍은 숫자인가?</h2>
	${(param.num1 eq param.num2) ? "예" : "아니오"}<br>
	<hr>
	
	안녕하세요, ${empty param.id ? "guest" : param.id}님! 환영합니다.
</body>
</html>
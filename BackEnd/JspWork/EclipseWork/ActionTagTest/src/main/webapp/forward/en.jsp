<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Thank you for visiting my website.</h2>
	Followings are data you registered.<br>
	<ul>
		<li>name : <%= request.getParameter("name") %></li>
		<li>address : <%= request.getParameter("addr") %></li>
		<li>language : <%= request.getParameter("lang") %></li>
	</ul>
</body>
</html>
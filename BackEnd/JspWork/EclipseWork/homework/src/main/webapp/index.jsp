<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
</head>
<body>

<% if(session.getAttribute("id") != null){%>
		<h2><%= session.getAttribute("id") %>님의 방문을 환영합니다.</h2>
		
		<ul>
			<li><a href="logout.jsp">로그아웃</a></li>
			<li><a href="shop.jsp">쇼핑몰</a></li>
		</ul>
<% }else{%>
		<h2>환영합니다.</h2>
		로그인을 해주세요.<br><br>
		
		<ul>
			<li><a href="login.jsp?menu=index">로그인</a></li>
			<li><a href="shop.jsp">쇼핑몰</a></li>
		</ul>
<% } %>	
	
</body>
</html>
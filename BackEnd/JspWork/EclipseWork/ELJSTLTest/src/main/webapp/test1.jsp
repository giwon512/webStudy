<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("cnt1", 100);
	%>
	
	<%
		out.println(request.getAttribute("cnt1") + "<br>");
	%>
	
	<%= request.getAttribute("cnt1") %><br>
	
	<%
		int cnt2 = (Integer)request.getAttribute("cnt1");
	%>
	<%= cnt2 %><br>
	<hr>
	
	${cnt1}<br>
	${requestScope.cnt1}<br>
	${pageScope.cnt1}<br> 
	
	<% session.setAttribute("cnt3", 300); %>
	${cnt3}<br>
	${sessionScope.cnt3}<br>
	${sessionScope['cnt3']}<br>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>exam2.jsp</h2>
	irum : <%= request.getParameter("irum") %>
	<%-- <jsp:forward page="exam3.jsp" /> --%>
	
	<%
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/forward/exam3.jsp");
		dispatcher.forward(request, response);
	%>
</body>
</html>
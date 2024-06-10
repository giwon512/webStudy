<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] foods = {"불고기", "오므라이스", "짜장면"};
		request.setAttribute("foods", foods);
	%>
	
	<%
		String[] arr = (String[])request.getAttribute("foods");
		for(String food : arr){
	%>
			<%= food %><br>
	<%
		}
	%>
	<hr>
	
	<c:forEach begin="0" end="3" step="1" var="i">
		${foods[i]}<br>
	</c:forEach>
	
	<hr>
	
	<c:forEach var="food" items="${foods}">
		${food}<br>
	</c:forEach>
	
	<hr>
	
	<c:set var="guests" value="토끼/거북이*너구리-기린,고양이" />
	<c:forTokens items="${guests}" var="token" delims="/*-,">
		${token}<br>
	</c:forTokens>
	<hr>
	
	<c:redirect url="test4.jsp">
		<c:param name="name" value="신돌석" />
		<c:param name="age" value="40" />
	</c:redirect>
	
</body>
</html>
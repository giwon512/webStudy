<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	호스트 정보 : <%= request.getHeader("host") %><br>
	user-agent 정보 : <%= request.getHeader("user-agent") %><br>
	<hr>
	호스트 정보 : ${header.host} <br>
	user-agent 정보 : ${header["user-agent"]} <br>
	
	<hr>
	
	<h3>쿠키 저장</h3>
	<%
		Cookie nameCook = new Cookie("name", "honggildong");
		Cookie idCook = new Cookie("id", "hong");
		
		nameCook.setMaxAge(60*60*24);
		idCook.setMaxAge(60*60*24);
		
		response.addCookie(nameCook);
		response.addCookie(idCook);
	%>
	쿠키가 저장되었습니다. 다음 페이지로 이동해 주세요.<br>
	<a href="test3_proc.jsp">다음 페이지+</a>
</body>
</html>
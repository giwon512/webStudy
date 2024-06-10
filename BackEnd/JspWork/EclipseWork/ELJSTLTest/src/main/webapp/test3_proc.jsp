<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 정보 확인</h2>
	<%
		Cookie[] cooks = request.getCookies();
	
		for(int i = 0; i < cooks.length; i++){
			if(cooks[i].getName().equals("id")){
	%>
				<%= cooks[i].getName() %><br>
				<%= cooks[i].getValue() %><br>
	<%		
			}
		}
	%>
	
	<hr>
	
	${cookie.name.name}<br>
	${cookie.name.value}<br>
	
</body>
</html>
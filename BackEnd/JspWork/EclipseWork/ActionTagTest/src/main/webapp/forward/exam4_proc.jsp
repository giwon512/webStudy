<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String toWhere = "kr.jsp";
	String lang = "korean";
	String from = request.getRemoteAddr();
	
	System.out.println(from);
	
	if(from.endsWith("127.0.0.1")){
		toWhere = "en.jsp";
		lang = "english";
	}
%>
</body>

<jsp:forward page="<%= toWhere %>" >
	<jsp:param value="<%= lang %>" name="lang"/>
</jsp:forward>
</html>
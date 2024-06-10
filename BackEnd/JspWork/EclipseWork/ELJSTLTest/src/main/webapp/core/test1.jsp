<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int var1 = 10; %>
	<%= var1 %>
	<hr>
	
	<c:set var="var2" value="20"></c:set>
	${var2}
	
	<hr>
	
	<c:set var="var3" value="30" />
	<c:set var="result" value="${var2 + var3}" />
	두 수의 합은 ${result}입니다.
</body>
</html>
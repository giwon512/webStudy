<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	접근 방식 : <%= request.getMethod() %><br>
	접근 방식 : ${pageContext.request.method}<br>
	세션 만료 시간 : <%= session.getMaxInactiveInterval() %><br>
	세션 만료 시간 : ${pageContext.session.maxInactiveInterval }<br>
</body>
</html>
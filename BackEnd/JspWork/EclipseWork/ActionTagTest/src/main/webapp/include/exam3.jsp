<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>exam3.jsp</h1>
	exam4에게 데이터를 전달<br>
	1. url을 이용 : http://localhost:8080/ActionTagTest/include/exam4.jsp?id=asdf&addr=seoul<br>
	2. 하이퍼링크를 이용<br>
	3. form 태그를 이용<br>
	4. Action Tag(include)를 이용
	<jsp:include page="exam4.jsp">
		<jsp:param value="asdf" name="id"/>
		<jsp:param value="1111" name="pw"/>			
	</jsp:include>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test4.jsp</h1>
	이름 : ${param.name}<br>
	나이 : ${param.age}<br>
	
	<hr>
	
	<h1>내가 좋아하는 영화들</h1>
	<c:forEach var="movie" items="${movies}">
		${movie}<br>
	</c:forEach>
	
	<hr>
	
	<form>
		댓글 작성<br>
		<textarea rows="3" cols="60"></textarea>
		<button>댓글 달기</button>
	</form>
</body>
</html>
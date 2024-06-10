<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="mybean.BeanTest"></jsp:useBean>
	<jsp:setProperty property="name" name="dto" value="홍길동"/>
	<jsp:setProperty property="price" name="dto" value="10000"/>
	
	
	이름 : <jsp:getProperty property="name" name="dto"/><br>
	가격 : <jsp:getProperty property="price" name="dto"/><br>
	<hr>
	이름 : ${dto.name}<br>
	가격 : ${dto.price}<br>
	<hr>
	<a href="/ELJSTLTest/eltest.action?name=John">서블릿에게 요청</a>
</body>
</html>
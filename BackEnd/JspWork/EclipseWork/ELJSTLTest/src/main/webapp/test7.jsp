<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> ${param.name}님 환영합니다.</h2>
	총 방문자 수 : ${visitCount} <br>
	<hr>
	
	${param.name}님이 좋아하는 음식 <br>
	
	${foods[0]}<br>
	${foods[1]}<br>
	${foods[2]}<br>
	${foods[3]}<br>
	${foods[4]}<br>
	
	<hr>
	
	뽀삐의 주인 이름 : ${person.name}<br>
	홍길동의 강아지 이름 : ${person.dog.name}<br>
</body>
</html>
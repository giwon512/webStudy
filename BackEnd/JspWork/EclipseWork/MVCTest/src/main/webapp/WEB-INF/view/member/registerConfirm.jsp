<%@page import="mybean.model.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Member dto = (Member)request.getAttribute("dto");
%>
<body>
	<h1>회원 가입 확인</h1>
	<form action="/MVCTest/register?command=complete" method="post">
		당신이 입력한 내용은 다음과 같습니다.<br>
		<ul>
			<li>아이디 : <%= dto.getId() %></li>
			<li>비밀번호 : <%= dto.getPw() %></li>
			<li>이메일 : <%= dto.getEmail() %></li>
		</ul>
		
		<button>가입 완료</button>&nbsp;&nbsp;
		<button>뒤로</button>
	</form>
</body>
</html>
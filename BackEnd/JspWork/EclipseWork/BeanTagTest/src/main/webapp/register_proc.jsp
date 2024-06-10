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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	%>
	<jsp:useBean id="mem" class="mybean.MemberDto" scope="page"></jsp:useBean>
	<!-- 
		<jsp:setProperty property="mem_id" name="mem" />
		<jsp:setProperty property="mem_pw" name="mem" />
		<jsp:setProperty property="mem_name" name="mem" />
		<jsp:setProperty property="mem_email" name="mem" />
		<jsp:setProperty property="mem_tel" name="mem" />
		<jsp:setProperty property="mem_addr" name="mem" />
	 -->
	<jsp:setProperty property="*" name="mem"/>
	
	<h2>입력 내용 확인</h2>
	아이디		: <jsp:getProperty property="mem_id" name="mem" /> <br>
	비밀번호	: <jsp:getProperty property="mem_pw" name="mem" /> <br>
	이름		: <jsp:getProperty property="mem_name" name="mem" /> <br>
	이메일		: <jsp:getProperty property="mem_email" name="mem" /> <br>
	전화번호	: <jsp:getProperty property="mem_tel" name="mem" /> <br>
	주소		: <jsp:getProperty property="mem_addr" name="mem" /> <br>
</body>
</html>
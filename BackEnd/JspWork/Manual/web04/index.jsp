<!DOCTYPE html>
<%@ page	contentType="text/html; charset=euc-kr" import="java.util.Date"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jiwon</title>
</head>
<body>
	<%!
		Date today;
	%>
    <h1 style="color: skyblue;">First web server</h1>
	
	<%
		today = new java.util.Date();
	%>
	오늘은 <%= today %> 입니다.
	
</body>
</html>
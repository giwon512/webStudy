<!DOCTYPE html>
<%@ page	contentType="text/html; charset=utf-8" import="java.util.Date"%>
<%@ page	errorPage="errorPages/error1.jsp" %>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jiwon</title>	
</head>
<body>
	10/0 = <%= 10/0 %>
	<br>
	원인 : <%= exception.getMessage() %>
</body>
</html>
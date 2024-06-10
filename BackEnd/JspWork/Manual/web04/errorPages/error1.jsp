<!DOCTYPE html>
<%@ page	contentType="text/html; charset=utf-8" import="java.util.Date"%>
<%@ page 	isErrorPage="true" %>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jiwon</title>	
</head>
<body>
	<h2>에러 발생</h2>
	<br>
	원인 : <%= exception.getMessage() %>
</body>
</html>
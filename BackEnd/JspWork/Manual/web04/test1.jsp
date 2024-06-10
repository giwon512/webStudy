<!DOCTYPE html>
<%@ page	contentType="text/html; charset=utf-8" import="java.util.Date"%>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jiwon</title>	
</head>
<body>
	<h1>CSR과 SSR의 차이</h1>
	<h2>1부터 10까지의 합계</h2>
	case1. Javascript를 사용하는 경우<br>
	<script>
		let s = 0;
		for(let i = 1; i <= 10; i++){
			s += i;
		}
		
		document.write(s + "<br>");
	</script>
	case2. Java를 사용하는 경우<br>
	<%
		int sum = 0;
		for(int i = 1; i <= 10; i++){
			sum += i;
		}
	%>
	<%= sum %>
</body>
</html>
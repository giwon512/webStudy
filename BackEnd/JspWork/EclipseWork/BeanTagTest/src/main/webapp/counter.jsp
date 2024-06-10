<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>counter.jsp</title>
</head>
<body>
	<h1>전체 방문자 수 확인</h1>
	<jsp:useBean id="counter" class="scope.CounterBean" scope="application">
		<jsp:setProperty property="newVisit" name="counter" value="1" /> <!-- 한 번만 호출하고 싶을 때 -->
	</jsp:useBean>
	
	<jsp:setProperty property="restart" name="counter"/>
	<h2>전체 방문자 수 : <jsp:getProperty property="visitCount" name="counter" /></h2>
	<form>
		<button name="refresh">새로 고침</button> &nbsp;&nbsp; 
		<button name="restart" value=true>카운터를 0으로 리셋</button>
	</form>
</body>
</html>
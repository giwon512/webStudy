<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
// get 방식인지 post 방식인지 확인하기
if(request.getMethod().equalsIgnoreCase("get")){
%>
<form action="requestExam1.jsp" method="get">
이름 : <input type="text" name="name" /><br><br>
주소 : <input type="text" name="addr" /><br><br>
취미 : <br>
<input type="checkbox" name="hobby" value="등산" />등산<br>
<input type="checkbox" name="hobby" value="독서" />독서<br>
<input type="checkbox" name="hobby" value="여행" />여행<br>
<input type="checkbox" name="hobby" value="낚시" />낚시<br>
<input type="submit" value="전송" />
</form>

<%
}
%>
</body>
</html>
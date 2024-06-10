<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="test2_proc.jsp">
		이름 : <input type="text" name="name" /><br><br>
		ID : <input type="text" name="id" /><br><br>
		
		첫 번째 좋아하는 음식 : <input type="text" name="food" /><br><br>
		두 번째 좋아하는 음식 : <input type="text" name="food" /><br><br>
		
		<input type="checkbox" name="hobby" value="낚시" />낚시<br>
		<input type="checkbox" name="hobby" value="등산" />등산<br>
		<input type="checkbox" name="hobby" value="독서" />독서<br>
		
		<button>전송</button>
	</form>

</body>
</html>
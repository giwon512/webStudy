<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello World</h2>
	
	<ul>
		<li><a href="/webproject2/first">first.jsp로 이동</a></li>
		<li><a href="/webproject2/second?p1=aaa&p2=bbb">second.jsp로 이동</a></li>
	</ul>
	<br><br>
	<form action="/webproject2/third" method="POST"><br>
		name : <input type="text" name="name" /><br>
		age : <input type="text" name="age" /><br>
		point : <input type="text" name="point" /><br>
		<button>전송</button>
	</form>
	<br><br>
	<form action="/webproject2/fourth" method="GET"><br>
		name : <input type="text" name="name" /><br>
		age : <input type="text" name="age" /><br>
		point : <input type="text" name="point" /><br>
		<input type="checkbox" name="chk" value="yes" checked><br>
		<button>전송</button>
	</form>
	<br><br>
	
	<a href="/webproject2/fifth">다섯번째 요청</a>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dice.jsp</title>
</head>
<body>
	<jsp:useBean id="dice" class="scope.DiceBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="minNumber" name="dice" value="1"/>
	<jsp:setProperty property="maxNumber" name="dice" value="6"/>
	<h1>주사위 게임</h1>
	<h2>주사위 눈금은 <jsp:getProperty property="randomNumber" name="dice"/>입니다.</h2>
	<form>
		<button>주사위 다시 굴리기</button>
	</form>
	<br><br>
	카운터 : <jsp:getProperty property="counter" name="dice"/>
</body>
</html>
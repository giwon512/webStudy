<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>timer.jsp</title>
<script>
	window.onload = () => {
		let time = 0;
		let form = document.getElementsByTagName("form");
		let span = document.getElementById("setTime");
		span.innerHTML = time;
		setInterval(() => {
			time++;
			span.innerHTML = time;
		}, 1000);
		
		form[0].addEventListener('submit', (ev) => {
			//ev.preventDefault();
			time = 0;
			/*setInterval(() => {
				time++;
				span.innerHTML = time;
			}, 1000);*/
			form[0].submit();
		}, false);
	};
</script>
</head>
<body>
<jsp:useBean id="timer" class="scope.TimerBean" scope="session"></jsp:useBean>
	<h1>세션을 이용한 타이머 예제</h1>
	세션 시작합니다. 타이머 작동을 시작합니다.<br><br>
	
	<!-- bean의 프로퍼티를 마지막으로 접근한 뒤에 경과한 시간은 <jsp:getProperty property="elapsedTimeAfterLastAccess" name="timer"/>초 입니다.<br><br> -->
	bean의 프로퍼티를 마지막으로 접근한 뒤에 경과한 시간은 <span id="setTime"></span>초 입니다.<br><br>
	
	<jsp:setProperty property="restart" name="timer" param="restart"/>
	타이머를 리셋한 뒤에 경과된 시간은 <jsp:getProperty property="elapsedTime" name="timer"/>초입니다.<br><br>
	
	타이머가 시작된 뒤에 경과된 시간은 <jsp:getProperty property="elapsedTimeAfterInst" name="timer"/>초입니다.<br><br>
	
	<form>
		<button name="check">경과시간 확인</button>&nbsp;&nbsp;&nbsp;
		<button name="restart" value="true">타이머 리셋</button>
	</form>
</body>
</html>
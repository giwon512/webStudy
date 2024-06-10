<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include.jsp</title>
</head>
<jsp:useBean id="incl" class="scope.IncludeBean" scope="request"></jsp:useBean>
<jsp:setProperty property="header" name="incl" param="header"/>
<jsp:setProperty property="footer" name="incl"/>
<body>
	<jsp:include page="inc/header.jsp"></jsp:include>
	<hr>
	<form>
		머릿말에 들어갈 내용 : <br>
		<textarea rows="2" cols="60" name="header"></textarea>
		<br><br>
		
		꼬릿말에 들어갈 내용 : <br>
		<textarea rows="2" cols="60" name="footer"></textarea>
		<br><br>
		
		<button>새로 고침</button>
	</form>
	
	<hr>
	<jsp:include page="inc/footer.jsp"></jsp:include>
</body>
</html>
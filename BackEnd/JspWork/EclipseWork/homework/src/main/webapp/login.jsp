<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login page</title>
	<script>
	window.onload = () => {
		let forms = document.getElementsByTagName("form");
		forms[0].addEventListener('submit', ev => {
			ev.preventDefault();
			const id = document.getElementsByName("id");
			const pw = document.getElementsByName("pw");
			if(id[0].value.length == 0 || pw[0].value.length == 0){
				alert("아이디 혹은 비밀번호를 확인해주세요");
				return;
			}
			ev.target.submit();
		}, false);
	};
	</script>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String menu = (String)request.getParameter("menu");
		//원래는 db를 통해 값이 있는지 인증해야함.
		if("asdf".equals(id) && "1111".equals(pw)){
			session.setAttribute("id", id);
			response.sendRedirect(menu + ".jsp");
		}
	%>
	<form action="login.jsp" method="POST">
		<fieldset style="width:300px;">
			<legend>로그인</legend>
			아이디: <input type="text" name="id" /> <br><br>
			비밀번호: <input type="password" name="pw" /> <br><br>
			<input type="hidden" name="menu" value="<%=menu %>" />
			<input type="hidden" name="login" value="true" />
			<button>로그인</button>
		</fieldset>
	</form>
</body>
</html>
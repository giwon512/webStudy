<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str1 = "aaaa";
		if(str1.equals("aaaa")){
	%>
			<b>aaaa가 맞습니다.</b>
	<% 
		}
	%>
	<hr>
	<c:set var="str2" value="bbbb" />
	<c:if test="${str2.equals('bbbb')}">
		<b>bbbb가 맞습니다.</b>
	</c:if>
	<hr>
	
	<form action="test2.jsp">
		숫자1 : <input type="number" name="num1" /><br><br>
		숫자2 : <input type="number" name="num2" /><br><br>
		<button>최대값 구하기</button>
	</form>
	<%
	String num = null;
		try{
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			num = Integer.parseInt(num1) > Integer.parseInt(num2) ? num1 : num2;
		}
		catch(Exception e){}
	%>
	최대값은 <%= num %>입니다.
	<hr>
	
	<c:if test="${!empty param.num1 and !empty param.num2 }">
	최대값은 ${Integer.parseInt(param.num1) gt Integer.parseInt(param.num2) ? param.num1 : param.num2 }입니다.
	</c:if>
	<hr>
	<c:if test="${!empty param.num1 and !empty param.num2 }">
		<c:choose>
			<c:when test="${Integer.parseInt(param.num1) > Integer.parseInt(param.num2)}">
				${param.num1}이 더 크다<br>
			</c:when>
			<c:when test="${Integer.parseInt(param.num1) < Integer.parseInt(param.num2)}">
				${param.num2}이 더 크다<br>
			</c:when>
			<c:otherwise>
				똑같다
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>
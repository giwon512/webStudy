<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message.jsp</title>
</head>
<body>
	<%
		String msg = "JSP를 배웁시다.";
	%>
	Message : <%= msg %>
	
	<hr>
	
	<%-- <% simple.MessageBean msg1 = new simple.MessageBean(); %> --%>
	<jsp:useBean id="msg1" class="simple.MessageBean"></jsp:useBean>
	
	<%-- <% msg1.setMsg("JSP를 배웁시다"); %> --%>
	<jsp:setProperty property="msg" name="msg1" value="JSP를 배웁시다."/>
	
	Message : <jsp:getProperty property="msg" name="msg1"/>
	
	<hr>
	<% 
		msg1.setMsg("JSP를 배웁시다");
	%>
	Message : <%= msg1.getMsg() %>
	
</body>
</html>

<!-- 
	class name : simple.MessageBean
	property :
		name	r/w		data type	desc
		-----------------------------------------
		msg		r/w		String		메세지 입출력
	
 -->
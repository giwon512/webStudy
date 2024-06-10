<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteEmp.jsp</title>
</head>
<body>
	
	<jsp:useBean id="dao" class="mybean.dao.EmployeeDao"></jsp:useBean>
	<jsp:setProperty property="deleteEmp" name="dao" param="e_no" />
	
	<script>alert("잘 삭제되었습니다.");</script>
	<ul>
		<li><a href="index.jsp">메인 페이지로</a></li>
		<li><a href="addEmp.html">추가 페이지로</a></li>
	</ul>
</body>
</html>
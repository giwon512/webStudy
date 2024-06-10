<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>직원 정보</h1>
	<a href="addEmp.html">직원 추가하기</a> <br><br>
	<form action="" method="post">
		<select name="keyword">
			<option value="e_id">아이디</option>
			<option value="e_name">이름</option>
			<option value="e_address">주소</option>
		</select>
		<input type="text" name="searchText" />
		<button>검색</button>
	</form>
	<table border="1">
		<tr>
			<th>사번</th><th>ID</th><th>이름</th><th>패스워드</th><th>주소</th><th>수정</th><th>삭제</th>
		</tr>
	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = null;
	
	request.setCharacterEncoding("utf-8");
	String keyword = request.getParameter("keyword");
	String searchText = request.getParameter("searchText");
	if(searchText != null && searchText.isEmpty()){
		sql = "select * from tblEmp order by e_no";
	}
	else{
		sql = "select * from tblEmp where "+ keyword + " like '%" + searchText + "%'";
	}

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		conn = DriverManager.getConnection(url,"scott","1111"); 
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
	%>
		<tr>
			<td><%= rs.getInt("e_no") %></td>
			<td><%= rs.getString("e_id") %></td>
			<td><%= rs.getString("e_name") %></td>
			<td><%= rs.getString("e_pass") %></td>
			<td><%= rs.getString("e_address") %></td>
			<td><a href="updateEmp.jsp?e_no=<%= rs.getInt("e_no") %>">수정</a></td>
			<td><a href="deleteEmp.jsp?e_no=<%= rs.getInt("e_no") %>">삭제</a></td>
		</tr>
	<% 
		}
	}
	catch(Exception err){
		err.printStackTrace();
	}
	finally{
		if(conn != null) conn.close();
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
	}
	%>
	</table>
</body>
</html>
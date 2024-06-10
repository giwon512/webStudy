<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addEmp_proc.jsp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("e_id");
		String name = request.getParameter("e_name");
		String pass = request.getParameter("e_pass");
		String address = request.getParameter("e_address");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			conn = DriverManager.getConnection(url,"scott","1111");
			
			/* String sql = "insert into tblEmp values(seq_eno.nextVal, " + "'" + id + "'" + ", " 
					+ "'" + name + "'" + ", " + "'" + pass + "'" + ", " + "'" +address + "'" + ")"; */
			
			String sql = "insert into tblEmp values(seq_eno.nextVal, ?, ?, ?, ?)";
			
			//conn.createStatement().executeUpdate(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, pass);
			stmt.setString(4, address);
			
			stmt.executeUpdate();
	%>
		<script>alert("잘 추가되었습니다.");</script>
		<ul>
			<li><a href="index.jsp">메인 페이지로</a></li>
			<li><a href="addEmp.html">추가 페이지로</a></li>
		</ul>
	<%
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
</body>
</html>
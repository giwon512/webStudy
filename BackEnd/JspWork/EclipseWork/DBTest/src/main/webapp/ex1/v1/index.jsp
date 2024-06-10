<%@page import="mybean.dto.Employee"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script>
	const isDelete = (e_no) => {
		let result = confirm(e_no + "번 직원을 삭제하시겠습니까?");
		if(result === true) {
			location.href = "deleteEmp.jsp?e_no=" + e_no;
		}
	};
</script>
</head>
<jsp:useBean id="dao" class="mybean.dao.EmployeeDao" />
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
	request.setCharacterEncoding("utf-8");
	String keyword = request.getParameter("keyword");
	String searchText = request.getParameter("searchText");
	
	ArrayList<Employee> list = dao.getList(keyword, searchText);
	for (int i = 0; i < list.size(); i++){
	%>
		<tr>
			<td><%= list.get(i).getE_no() %></td>
			<td><%= list.get(i).getE_id() %></td>
			<td><%= list.get(i).getE_name() %></td>
			<td><%= list.get(i).getE_pass() %></td>
			<td><%= list.get(i).getE_address() %></td>
			<td><a href="updateEmp.jsp?e_no=<%= list.get(i).getE_no() %>">수정</a></td>
			<!-- <td><a href="deleteEmp.jsp?e_no=<%= list.get(i).getE_no() %>">삭제</a></td> -->
			<td><a href="javascript:isDelete(<%= list.get(i).getE_no() %>)">삭제</a></td>
		</tr>
	<% 
		}
	%>
	</table>
</body>
</html>
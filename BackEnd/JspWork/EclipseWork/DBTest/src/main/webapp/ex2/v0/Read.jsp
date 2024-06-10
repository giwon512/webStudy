<%@page import="mybean.board.BoardDto"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<%
	request.setCharacterEncoding("utf-8");
	int b_num = Integer.parseInt(request.getParameter("b_num"));
%>

<jsp:useBean id="dao" class="mybean.board.BoardDao"></jsp:useBean>
<%
	BoardDto board = dao.getBoard(b_num);
	if(board.getB_content() == null){
		board.setB_content("");
	}
%>
<body>
<br><br>
<table align=center width=70% border=0 cellspacing=3 cellpadding=0>
 <tr>
  <td bgcolor=9CA2EE height=25 align=center class=m>글읽기</td>
 </tr>
 <tr>
  <td colspan=2>
   <table border=0 cellpadding=3 cellspacing=0 width=100%> 
    <tr> 
	 <td align=center bgcolor=#dddddd width=10%> 이 름 </td>
	 <td bgcolor=#ffffe8><%= board.getB_name() %></td>
	 <td align=center bgcolor=#dddddd width=10%> 등록날짜 </td>
	 <td bgcolor=#ffffe8><%= board.getB_regdate() %></td>
	</tr>
    <tr>
	 <td align=center bgcolor=#dddddd width=10%> 메 일 </td>
	 <td bgcolor=#ffffe8 ><%= board.getB_email() %></td> 
	 <td align=center bgcolor=#dddddd width=10%> 홈페이지 </td>
	 <td bgcolor=#ffffe8 ><a href="http://" target="_new"><%= board.getB_homepage() %></a></td> 
	</tr>
    <tr> 
     <td align=center bgcolor=#dddddd> 제 목</td>
     <td bgcolor=#ffffe8 colspan=3><%= board.getB_subject() %></td>
   </tr>
   <tr> 
    <td colspan=4><%= board.getB_content().replace("\n", "<br>") %></td>
   </tr>
   <tr>
    <td colspan=4 align=right>
     <%= board.getB_ip() %>로 부터 글을 남기셨습니다. /  조회수 : <%= board.getB_count() %>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align=center colspan=2> 
	<hr size=1>
	[ <a href="List.jsp">목 록</a> | 
	<a href="Reply.jsp?b_num=<%=b_num%>">답 변</a> | 
	<a href="Update.jsp?b_num=<%=b_num%>">수 정</a> |
	<a href="Delete.jsp?b_num=<%=b_num%>">삭 제</a> ]<br>
  </td>
 </tr>
</table>
</body>
</html>

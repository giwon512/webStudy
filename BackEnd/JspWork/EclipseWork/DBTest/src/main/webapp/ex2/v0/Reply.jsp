<%@page import="mybean.board.BoardDto"%>
<%@ page contentType="text/html; charset=utf-8" %>
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
%>
<body>
<center>
<br><br>
<table width=80% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=84F399 height=25 align=center>답변하기</td>
 </tr>
</table>
<br>
<table width=80% cellspacing=0 cellpadding=3 align=center>
<form name=post method=post action="ReplyProc.jsp" >
<input type="hidden" name="pos" value=<%=board.getPos() %> />
<input type="hidden" name="depth" value=<%=board.getDepth() %> />
<input type="hidden" name="b_ip" value="<%= request.getRemoteAddr() %>" />
 <tr>
  <td align=center>
   <table border=0 width=100% align=center>
    <tr>
     <td width=10%>성 명</td>
     <td width=90%><input type=text name="b_name" size=10 maxlength=8></td>
    </tr>
    <tr>
	 <td width=10%>E-Mail</td>
	 <td width=90%><input type=text name="b_email" size=30 maxlength=30></td>
    </tr>
    <tr>
     <td width=10%>홈페이지</td>
     <td width=90%><input type=text name="b_homepage" size=40 maxlength=30></td>
    </tr>
    <tr>
     <td width=10%>제 목</td>
     <td width=90%><input type=text name="b_subject" size=50 maxlength=30 value="답변 : <%= board.getB_subject()  %>"></td>
    </tr>
    <tr>
     <td width=10%>내 용</td>
     <td width=90%><textarea name="b_content" rows=10 cols=50><%= board.getB_content() %></textarea></td>
    </tr>
    <tr>
     <td width=10%>비밀 번호</td> 
     <td width=90% ><input type=password name="b_pass" size=15 maxlength=15></td>
    </tr>
    <tr>
     <td colspan=2><hr size=1></td>
    </tr>
    <tr>
     <td><input type=submit value="등록" >&nbsp;&nbsp;
         <input type=reset value="다시쓰기">&nbsp;&nbsp;
     </td>
    </tr> 
   </table>
  </td>
 </tr>
</form> 
</table>
</center>
</body>
</html>
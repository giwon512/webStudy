<%@page import="mybean.board.BoardDto"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head> <title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
	   if (document.form.b_pass.value == "") {
		 alert("������ ���� �н����带 �Է��ϼ���.");
	     form.b_pass.focus();
		 return false;
		 }
	   document.form.submit();
	}
</script>
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
<table width=460 cellspacing=0 cellpadding=3>
  <tr>
   <td bgcolor=#FF9018  height=21 align=center class=m>�����ϱ�</td>
  </tr>
</table>

<form name=form method=post action="UpdateProc.jsp" >
<input type="hidden" name="b_num" value="<%=b_num %>" />
<table width=70% cellspacing=0 cellpadding=7>
 <tr>
  <td align=center>
   <table border=0>
    <tr>
     <td width=20%>�� ��</td>
     <td width=80%>
	  <input type=text name="b_name" size=30 maxlength=20 value="<%= board.getB_name() %>">
	 </td>
	</tr>
    <tr>
     <td width=20%>E-Mail</td>
     <td width=80%>
	  <input type=text name="b_email" size=30 maxlength=30 value="<%= board.getB_email() %>">
	 </td>
    </tr>
	<tr>
     <td width=20%>�� ��</td>
     <td width=80%>
	  <input type=text name="b_subject" size=50 maxlength=50 value="<%= board.getB_subject() %>">
	 </td>
    <tr>
     <td width=20%>�� ��</td>
     <td width=80%>
	  <textarea name="b_content" rows=10 cols=50><%= board.getB_content() %></textarea>
	 </td>
    </tr>
	<tr>
     <td width=20%>��� ��ȣ</td> 
     <td width=80%><input type=password name="b_pass" size=15 maxlength=15>
      �����ÿ��� ��й�ȣ�� �ʿ��մϴ�.</td>
    </tr>
	<tr>
     <td colspan=2 height=5><hr size=1></td>
    </tr>
	<tr>
     <td colspan=2>
	  <input type="button" value="�����Ϸ�" onClick="check()">
      <input type="reset" value="�ٽü���"> 	
      <input type="button" value="�ڷ�" onClick="history.back()">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</table>
</form> 
</center>
</body>
</html>
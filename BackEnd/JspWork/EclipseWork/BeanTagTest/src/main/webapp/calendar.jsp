<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date, java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calendar.jsp</title>
</head>
<body>
	<%
		Date today = new Date();
		Calendar cal = Calendar.getInstance(); //singleton 클래스 인스턴스이다.
	%>
	
	오늘은 <%= today %> 입니다. <br>
	<%= cal.get(Calendar.YEAR) %>년 &nbsp;
	<%= cal.get(Calendar.MONTH)+ 1 %>월 &nbsp; <!-- 월은 0부터 꺼내 옴 -->
	<%= cal.get(Calendar.DATE) %>일 &nbsp;
	
	<hr>
	
	<jsp:useBean id="curDate" class="simple.CalendarBean"></jsp:useBean>
	
	 오늘은 <jsp:getProperty property="today" name="curDate"/> 입니다. <br>
	 <jsp:getProperty property="year" name="curDate"/>년 &nbsp;
	 <jsp:getProperty property="month" name="curDate"/>월 &nbsp;
	 <jsp:getProperty property="date" name="curDate"/>일 &nbsp;
	 <br><br>
	 <jsp:setProperty property="greeting" name="curDate" value="좋은 아침입니다." />
	 인사말 : <jsp:getProperty property="greeting" name="curDate"/>
	 
	 
</body>
</html>

<!-- 
	class name : simple.CalendarBean
	constructor : yes
	property :
		name	r/w		data type
		----------------------------
		today	r		Date
		year	r		int
		month	r		int
		date	r		int
	
 -->
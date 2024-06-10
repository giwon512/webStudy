<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList, mybean.CarDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="parking" class="mybean.ParkingBean" scope="application"></jsp:useBean>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
%>
<jsp:setProperty property="enter" name="parking"/>
<jsp:setProperty property="exit" name="parking"/>

<body>
	<h1>주차 관리 프로그램</h1>
	<form method="post">
		주차장에 들어온 차 번호 : <input type="text" name="enter" />
		&nbsp;<button>입차</button>
	</form>
	
	<form method="post">
		주차장에서 나간 차 번호 : <input type="text" name="exit" />
		&nbsp;<button>출차</button>
	</form>
	
	<hr>
	
	주차된 차량 목록 <br>
	<table border="1">
		<tr>
			<td>차량 번호</td> <td>입차 시간</td>
		</tr>
		<% 
			ArrayList<CarDto> cars = parking.getCarInfo();
			for(int i = 0; i < cars.size(); i++) { 
		%>
				<tr>
					<td><%= cars.get(i).getPlateNumber() %></td>
					<td><%= cars.get(i).getParkingTime() %></td>
				</tr>
		<% } %>
	</table>
	<br>
	총 주차대수 : <jsp:getProperty property="counter" name="parking"/>대
</body>
</html>
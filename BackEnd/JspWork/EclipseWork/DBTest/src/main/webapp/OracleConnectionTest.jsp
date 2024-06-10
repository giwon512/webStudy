<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>오라클 연결 테스트</title>
</head>
<body>
<h1>오라클 연결 테스트</h1>

<%
Connection conn = null;

try{
Class.forName("oracle.jdbc.driver.OracleDriver"); //메모리에 드라이버를 가져오기 위한 클래스를 올림
String url = "jdbc:oracle:thin:@localhost:1521:xe"; //드라이버명@드라이버가 설치된 주소:포트번호:DB이름
conn = DriverManager.getConnection(url,"scott","1111"); // 드라이버를 가져옴

if(conn != null){
out.println("<h2>연결 성공</h2>");
}
}
catch(Exception err){
err.printStackTrace();
}
finally{
conn.close();
}
%>
</body>
</html>
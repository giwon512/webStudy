<%@page import="mybean.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	ArrayList<Book> bookList = (ArrayList<Book>)session.getAttribute("bookList");
	int total = 0;
%>
<body>
	<h1>도서 구매 주문 페이지</h1>
	<b>주문한 도서</b>
	<table border="1">
		<tr>
			<th>도서 제목</th><th>작가</th><th>가격</th><th>수량</th>
		</tr>
		<%
			if(bookList != null){
				for(Book b : bookList){
					total += b.getPrice() * b.getQuantity();
		%>
		<tr>
			<td><%= b.getTitle() %></td>
			<td><%= b.getAuthor() %></td>
			<td><%= b.getPrice() %></td>
			<td><%= b.getQuantity() %></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<br>
	<b>전체 구입액수 : <%= total %></b>
	<form method="post" action="index.jsp">
		<button>결제</button>
	</form>
</body>
</html>
<%@page import="mybean.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="book" class="mybean.model.Book"></jsp:useBean>

<%
	ArrayList<Book> bookList = (ArrayList<Book>)session.getAttribute("bookList");
%>

<body>
	<b>현재 주문한 도서</b>
	<table border="1">
		<tr>
			<th>도서 제목</th><th>작가</th><th>가격</th><th>수량</th><th>삭제</th>
		</tr>
		<%
			if(bookList != null){
				for(int i = 0; i < bookList.size(); i++){
		%>
		<tr>
			<td><%= bookList.get(i).getTitle() %></td>
			<td><%= bookList.get(i).getAuthor() %></td>
			<td><%= bookList.get(i).getPrice() %></td>
			<td><%= bookList.get(i).getQuantity() %></td>
			<td>
				<form action="/MVCTest/book?command=del" method="post">
					<input type="hidden" name="cnt" value="<%= i %>" />
					<button>삭제</button>
				</form>
			</td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<br>
	<form method="post" action="/MVCTest/book?command=checkout">
		<button>체크아웃</button>
	</form>
</body>
</html>
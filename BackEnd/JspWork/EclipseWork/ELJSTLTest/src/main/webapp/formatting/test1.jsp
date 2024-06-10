<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="100000000000"></fmt:formatNumber><br>
	<fmt:formatNumber value="100000000000" groupingUsed="false"></fmt:formatNumber><br>
	<fmt:formatNumber value="3.141592" pattern="#.###"></fmt:formatNumber><br>
	<fmt:formatNumber value="0.5" type="percent"></fmt:formatNumber><br>
	<fmt:formatNumber value="250000000" type="currency" currencySymbol="$"></fmt:formatNumber><br>
	<hr>
	
	<c:set var="today" value="<%= new Date() %>" /><br>
	<fmt:formatDate value="${today }" /><br>
	<fmt:formatDate value="${today }" type="date"/><br>
	<fmt:formatDate value="${today }" type="time"/><br>
	<fmt:formatDate value="${today }" type="both"/><br>
	<hr>
	<fmt:formatDate value="${today }" dateStyle="short"/><br>
	<fmt:formatDate value="${today }" dateStyle="medium"/><br>
	<fmt:formatDate value="${today }" dateStyle="long"/><br>
	<fmt:formatDate value="${today }" dateStyle="full"/><br>
	<hr>
	<fmt:formatDate value="${today }" dateStyle="short" type="time"/><br>
	<fmt:formatDate value="${today }" dateStyle="medium" type="time"/><br>
	<fmt:formatDate value="${today }" dateStyle="long" type="time"/><br>
	<fmt:formatDate value="${today }" dateStyle="full" type="time"/><br>
	<hr>
	<fmt:formatDate value="${today }" pattern="yyyy/MM/dd(E)" /><br>
	
	<hr>
	
	<!-- 원하는 국가 형태 -->
	<fmt:setLocale value="en_us"/><br>
	<fmt:formatNumber value="250000000"  type = "currency"/><br>
	<fmt:formatDate value="${today}"  type = "both" dateStyle="full"
	timeStyle="full"/><br>
	
	<hr>
	<!-- 해당 국가 표준 시간 -->
	<fmt:setLocale value="ko_kr"/>
	서울 : <fmt:formatDate value="${today}"  type = "both" />
	<br>
	<fmt:timeZone value="Asia/Beijing">
	베이징 : <fmt:formatDate value="${today}"  type = "both" />
	</fmt:timeZone>
	<br>
	<fmt:timeZone value="Europe/London">
	런던 : <fmt:formatDate value="${today}"  type = "both" />
	</fmt:timeZone>
	<br>
	<fmt:timeZone value="America/New_York">
	뉴욕 : <fmt:formatDate value="${today}"  type = "both" />
	</fmt:timeZone>
	
	<hr>
	<!-- 문자 인코딩 -->
	<fmt:requestEncoding value="UTF-8" />
		
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String[] news = {"“먹는거 아냐”…日서 난리난 26만원 ‘초코송이’ 이어폰" ,
			"\"쏘니 위해 26년만에 잔디 싹 바꿨다\" 태국이 털어 놓은...",
			"대전 여야 13일간 총선 레이스 시작…시장·길거리·아파트..."};
	request.setAttribute("news", news);
%>

<c:forEach var="s" items="${news}">
	${s}<br>
</c:forEach>

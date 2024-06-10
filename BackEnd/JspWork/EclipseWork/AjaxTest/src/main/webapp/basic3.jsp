<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String userNum = request.getParameter("userNum");
	String name="", gender="", addr="", tel="";
	
	if(userNum.equals("1")) {
		name="홍길동";
		gender="남성";
		addr="서울시 강북구";
		tel="111-1111";
	}else if(userNum.equals("2")) {
		name="임꺽정";
		gender="남성";
		addr="서울시 성동구";
		tel="222-2222";
	}else if(userNum.equals("3")) {
		name="aaa";
		gender="bbb";
		addr="cccc";
		tel="333-3333";
	}
%>

<%= name %>,<%= gender %>,<%= addr %>,<%= tel %> 
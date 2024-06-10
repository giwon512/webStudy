<%@ page contentType="text/html; charset=UTF-8"%>
[머릿말]<br>
<jsp:useBean id="incl" class="scope.IncludeBean" scope="request"></jsp:useBean>
<jsp:getProperty property="header" name="incl"></jsp:getProperty>
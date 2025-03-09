<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Retail App</title>
</head>
<body>
<%@ include file="header.jsp"%>
Hello 
	<%
	out.print(session.getAttribute("username"));
	%>!</br>

Its index.jsp

<%
out.println(request.getParameter("sTracking"));
%>
</body>
</html>
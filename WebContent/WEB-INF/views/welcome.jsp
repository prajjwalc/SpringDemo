<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>

<h2>Welcome Page via Spring MVC</h2>

param1=${param1} <br/>
welcome=${welcome1}<br/>
welcome1=${welcome}<br/>

<springForm:form action="/SpringDemo/welcome" method="post" commandName="welcome123">
	Subject : <springForm:input type="text" name="subject" path="subject"  /><br/>
			  <springForm:errors path="subject" cssClass="error" /> <br/>
	Message : <springForm:input type="text" name="message" path="message"  /><br/>
	<input type="submit" value="Submit" />
</springForm:form>
</body>
</html>
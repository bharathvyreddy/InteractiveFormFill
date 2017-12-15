<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Do you want to confirm these values?
	<%session.getAttribute("studentid"); %>
	<%session.getAttribute("studentname"); %>
	<%session.getAttribute("studentmajor"); %>
	<%session.getAttribute("studentadvisor"); %>
	
	<form action="sp" name="secondpage">
	<input type="radio" name="confirm" value="Yes"/>Yes<input type="radio" name="confirm" value="No"/>No
	</form>
</body>
</html>
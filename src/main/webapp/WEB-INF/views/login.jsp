<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn Page</title>
</head>
<body>

	<h2 style="text-align: center;">Employee Information</h2>
	<center>
	<form:form method="POST" modelAttribute="userAttr" action="./user">
		<table>
			<tr>
				<td><form:label path="username">Username:</form:label></td>
				<td><form:input path="username" /></td>
				<td><font color="red"><form:errors path="username"></form:errors></font></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:input path="password" type="password"/></td>
				<td><font color="red"> <form:errors path="password"></form:errors></font></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
		<font color="red">${msg}</font>
	</form:form>
	</center>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>User</title>
    <%@ page isELIgnored="false" %>
</head>
<body>

    <spring:url value="/save" var="saveURL"></spring:url>
    <form:form action="${saveURL}" modelAttribute="empDetail" method="POST">
        <form:hidden path="id"></form:hidden>
        <table>
			<tr>
                <td><form:label path="name">Name: </form:label></td>
                <td><form:input path="name" value="${ empDetail.name }"/></td>
                <td><font color="red"><form:errors path="name"></form:errors></font></td>
			</tr>
			<tr>
				<td><form:label path="department">Department: </form:label></td>
                <td><form:input path="department" value="${ empDetail.department }"/></td>
                <td><font color="red"><form:errors path="department"></form:errors></font></td>
			</tr>
			<tr>
				<td><form:label path="designation">Designation: </form:label></td>
                <td><form:input path="designation" value="${ empDetail.designation }"/></td>
                <td><font color="red"><form:errors path="designation"></form:errors></font></td>
			</tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>

    </form:form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>List</title>
    <%@ page isELIgnored="false" %>
    
    <style>
		table {
			width: 50%;
		}
		
		table, th, td {
			border: 1px solid black;
			border-collapse: collapse;
		}
		
		th, td {
			padding: 15px;
			text-align: left;
		}
		
		table tr:nth-child(even) {
			background-color: #eee;
		}
		
		table tr:nth-child(odd) {
			background-color: #fff;
		}
		
		table th {
			background-color: black;
			color: white;
		}
	</style>
</head>



<body>

    <spring:url value="/add" var="addURL"></spring:url>
    <a href="${addURL}">Add user</a>
 
   <h1>List</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Department</th>
                <th>Designation</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.designation}</td>
                    
                    <td>
                        <spring:url value="/update/${employee.id}" var="updateURL" ></spring:url>
                        <a href="${updateURL}">Update</a>
                    </td>
                    <td>
                        <spring:url value="/delete/${employee.id}" var="deleteURL" ></spring:url>
                        <a href="${deleteURL}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
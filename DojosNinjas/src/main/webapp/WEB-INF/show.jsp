<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/chasesstyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <style>
    .container{
    	display: flex;
    	flex-direction: row;
    	}
    </style>
    
    <title>Table</title>
</head>
<body>
	<div id="container">
	<a href="/dojos" class="orangebtn">All Dojos</a>
		<h1 class="ou">All ninjas in <c:out value="${dojo.name}"/></h1>
		<table class="red">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
			<tbody>
				<c:forEach  var="ninja" items="${dojo.ninjas}">
				<tr>
					<td><c:out value="${ninja.firstName}"/></td>
					<td><c:out value="${ninja.lastName}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
</body>
</html>
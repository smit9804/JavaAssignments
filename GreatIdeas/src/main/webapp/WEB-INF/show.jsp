<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/chasesstyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	
	<title>Welcome</title>
</head>
<body>
	<h1 class="orange"><c:out value="${idea.content}"/></h1>
	<br>
	<br>
	<h4>Creator: <c:out value="${idea.creator.name}"/></h4>
	<c:if test="${idea.creator.id == user.id}">
		<a href="/ideas/edit/${idea.id}" class="bluebtn">Edit</a>
	</c:if>
</body>
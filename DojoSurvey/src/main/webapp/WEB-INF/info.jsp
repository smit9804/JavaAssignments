<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/chasestyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    
    <title>Main Page</title>
</head>
<body>
<div id="content">
	<table class="beach">
		<tr>
			<th>Name</th>
			<th>Location</th>
			<th>Language</th>
			<th>Comment</th>
		</tr>
		<tr>
			<td> <c:out value="${name}"/></td>
			<td> <c:out value="${location}"/></td>
			<td> <c:out value="${language}"/></td>
			<td> <c:out value="${comment}"/></td>
	</table>
</div>
</body>
</html>
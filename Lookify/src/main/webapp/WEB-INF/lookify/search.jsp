<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>

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
    
    <title>Search</title>
</head>
<body>
	<div class="formright">
		<form action="/search" method="post">
			<input class="form" type="submit" value="Search Artists">
			<input class="form" type="search" name="artist" placeholder="Artist">
		</form>
		<a href="/lookify" class="greenbtn">Dashboard</a>
	</div>
	<div>
		<table class="orange">
		    <thead>
		        <tr>
		            <th scope="col" class="blue">Name</th>
		            <th scope="col" class="blue">Rating</th>
		            <th scope="col" class="blue">Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${lookify}" var="lookify">
		        <tr>
		            <td><a href="lookify/<c:out value="${lookify.id}"/>"><c:out value="${lookify.name}"/></a></td>
		            <td><c:out value="${lookify.rating}"/></td>
		            <td><a href="/delete/<c:out value="${lookify.id}"/>">Delete</a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
	
</body>
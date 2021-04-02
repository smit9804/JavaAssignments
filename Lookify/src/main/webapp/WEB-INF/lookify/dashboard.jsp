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
    
    <title>Table</title>
</head>
<body>
	<h1>Lookify Dashboard</h1>
	<a href="/lookify/new" class="greenbtn">Add New</a>
	<div class="formright">
				<form action="/search" method="post">
					<input class="form" type="submit" value="Search Artists">
					<input class="form" type="search" name="artist" placeholder="Artist">
				</form>
			</div>
	<table class="yellow">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Artist</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lookify}" var="lookify">
        <tr>
            <td class="green"><a href="/show/${lookify.id}"><c:out value="${lookify.name}"/></a></td>
            <td class="green"><c:out value="${lookify.rating}"/></td>
            <td class="green"><c:out value="${lookify.artist}"/></td>
            <td class="green"><form action="/lookify/${lookify.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete" class="redbtn"></form></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
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
<h1>All Languages</h1>
<table class="yellow">
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${language}" var="language">
        <tr>
            <td class="ou"><a href="/show/${language.id}"><c:out value="${language.name}"/></a></td>
            <td class="ou"><c:out value="${language.creator}"/></td>
            <td class="ou"><c:out value="${language.version}"/></td>
            <td class="ou"><a href="/languages/${language.id}/edit" class="yellowbtn">Edit</a>|<a href="/languages/delete" class="redbtn">Delete</a>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/languages/new" class="greenbtn">New Language</a>
</body>
</html>
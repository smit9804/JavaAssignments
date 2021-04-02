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
			<h1>New Ninja</h1>
			<form:form action="/addNinja" method="post" modelAttribute="ninjaObject">
   			    <h2>
   			        <form:label cssClass="label left" path="dojo">Dojo:</form:label>
   			    	<form:select cssClass="box" path="dojo">
   			    		<c:forEach items="${dojos}" var="dojo">
   			    			<form:option value="${dojo}"><c:out value="${dojo.name}"/></form:option>
		    			</c:forEach>
 			    	</form:select>
			    </h2>		  
			    <h2>
			        <form:label cssClass="label left" path="firstName">First Name:</form:label>
			        <form:input cssClass="box" path="firstName"/>
			    </h2>
   			    <h2>
			        <form:label cssClass="label left" path="lastName">Last Name:</form:label>
			        <form:input cssClass="box" path="lastName"/>
			    </h2>
   			    <h2>
			        <form:label cssClass="label left" path="age">Age:</form:label>
			        <form:input cssClass="box" path="age"/>
			    </h2>
			    <input id="btn" type="submit" value="Add"/>	 
			</form:form>
		</div>
</body>
</html>
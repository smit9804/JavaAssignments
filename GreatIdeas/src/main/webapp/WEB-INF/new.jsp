<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Idea</title>
     <link rel="stylesheet" type="text/css" href="css/chasesstyle.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<h1> Create a new Idea!</h1>
	
		<form:form action="/ideas/new" method="post" modelAttribute="newidea">

		<p>
			<form:label path="content">Idea: </form:label>
			<form:input path="content" />
		</p>
		<p>
			<form:errors class="red" path="content" />
		</p>
		<input class="greenbtn" type="submit" value="Create Idea!" />

	</form:form>
</body>

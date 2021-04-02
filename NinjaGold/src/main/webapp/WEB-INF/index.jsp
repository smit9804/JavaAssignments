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
    	align-content: center;
    	}
    </style>
    
    <title>Code</title>
</head>
<body>
<div id="header">
<h3 class ="yellow">Your Gold: <c:out value="${gold}"/></h3>
</div>
	<div class="container">
	<form action="/monies" method="POST">
		<div class="blue">
			<h1>Farm</h1>
			<h4>(earns 10-20 gold)</h4>
			<input type="hidden" name="process" value="farm">
			<input type="submit" class="yellowbtn" value="FindGold!">
		</div>
	</form>
	<form action="/monies" method="POST">	
		<div class="blue">
			<h1>Cave</h1>
			<h4>(earns 5-10 gold)</h4>
			<input type="hidden" name="process" value="cave">
			<input type="submit" class="yellowbtn" value="FindGold!">
		</div>
	</form>
	<form action="/monies" method="POST">
		<div class="blue">
			<h1>House</h1>
			<h4>(earns 2-5 gold)</h4>
			<input type="hidden" name="process" value="house">
			<input type="submit" class="yellowbtn" value="FindGold!">
		</div>
	</form>
	<form action="/monies" method="POST">	
		<div class="blue">
			<h1>Casino</h1>
			<h4>(earns/takes 0-50 gold)</h4>
			<input type="hidden" name="process" value="casino">
			<input type="submit" class="yellowbtn" value="FindGold!">
		</div>
	</form>
	</div>
	<div class="row">
		<div class="col-lg-12" overflow="scroll">
			<ul>
		        <% if(session.getAttribute("activities") != null){ %>
       				<% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities"); %>
       				<% for(int i = 0; i < activities.size(); i++) { %>
       				<% if(activities.get(i).contains("lost")) { %>
       					<li class="red"><%= activities.get(i) %></li>
       				<% } else { %>
       					<li class="green"><%= activities.get(i) %></li>
       			<% 		} %>
       			<%	 } %>
       			<% } %>
        	</ul>
		</div>
		
	</div>

</body>
</html>
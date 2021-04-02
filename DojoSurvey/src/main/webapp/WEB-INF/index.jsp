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
	<h1 class="desert">Chaser</h1>
	<form class="beach" action="/info" method="POST">
		<input type="text" placeholder="Name?" name="name">
		<br>
		<br>
		<select name="location">
			<option value="Burbank">Burbank</option>
			<option value="San Jose">San Jose</option>
			<option value="Dallas">Dallas</option>
			<option value="Bellevue">Bellevue</option>
		</select>
		<br>
		<br>
		<select name="language">
			<option value="HTML">HTML</option>
			<option value="CSS">CSS</option>
			<option value="JavaScript">JavaScript</option>
			<option value="Python">Python</option>
			<option value="Java">Java</option>
			<option value="C#">C#</option>
		</select>
		<br>
		<br>
		<input type="textarea" name="comment">
		<input class="greenbtn" type="submit" value="Submit">
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isErrorPage="true" %>
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
	<h1 class="orange">Edit <c:out value="${idea.content}"/></h1>
	<c:out  value="${error}"/>
	<form:form action="/ideas/edit/${idea.id}" method="post" modelAttribute="idea">
	<input type="hidden" name="_method" value="put">
		<h5>
			<form:label path="content">Idea: </form:label>
			<form:input path="content" />
		</h5>
		<p>
		<form:errors class="red" path="content"/>
		</p>
		<input class="purplebtn" type="submit" value="Update"/>
	</form:form>
	<form action="/ideas/${idea.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" class="redbtn" value="Delete">
	</form>
	</body>
	</html>
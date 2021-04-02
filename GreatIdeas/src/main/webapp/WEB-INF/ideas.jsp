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
	<div id="header">
		<h1 class="orange">Welcome, <c:out value="${user.name}" /></h1><a href="/logout" class="redbtn" >Logout</a>
	</div>
	<div>
		<table class="table table-primary">
			<thead>
				<tr>
					<th>Idea</th>
					<th>Created By:</th>			
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allIdeas}" var="idea">
				<tr>
					<td>
						<a href="/ideas/${idea.id }">
							<c:out value="${idea.content}"/>
						</a>
					</td>
					<td><c:out value="${idea.creator.name}"/></td>
					<td>
						<c:choose>
							<c:when test="${idea.likedUser.contains(user)==false}">
								<form action="/ideas/${idea.id}/like" method="post">
									<input class="bluebtn" type="submit" value="Like">
								</form>
							</c:when>
							<c:otherwise>
								<form action="/ideas/${idea.id}/unlike" method="post">
									<input class="bluebtn" type="submit" value="Unlike">
								</form>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href ="/ideas/new" class="purplebtn">Create an Idea</a>
	</div>
</body>
</html>
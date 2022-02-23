<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Reading Books</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<h3>All Books</h3>
				<div class="table-responsive">
					<table class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col">Id</th>
					      <th scope="col">Title</th>
					      <th scope="col">Language</th>
					      <th scope="col"># Pages</th>
					    </tr>
					  </thead>
					  <tbody>
						  <c:forEach var="book" items="${books}">
							<tr>
						      <th scope="row">${book.id}</th>
						      <td><a href="/books/${book.id}">${book.title}</a></td>
						      <td>${book.language}</td>
						      <td>${book.numberOfPages}</td>
						    </tr>
						</c:forEach>
					  </tbody>
					</table>
				</div>
				
				
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
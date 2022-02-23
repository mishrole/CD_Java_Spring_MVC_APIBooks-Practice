<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Book</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<h3 class="text-center">New Book</h3>
				<div class="card">
					<div class="card-body">
						<form action="/books" method="POST" id="validate">
							<div class="row mx-auto">
								<div class="col-12">
									<div class="form-floating mb-3">
									  <input type="text" class="form-control requires-validation validate-save" name="title" id="title">
									  <div class="invalid-feedback"></div>
									  <label for="title">Title</label>
									</div>
								</div>

								<div class="col-12">
									<div class="form-floating mb-3">
									  <textarea name="description" class="form-control requires-validation validate-save" id="description"></textarea>
									  <div class="invalid-feedback"></div>
									  <label for="description">Description</label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <input type="text" class="form-control requires-validation validate-save" name="language" id="language">
									  <div class="invalid-feedback"></div>
									  <label for="language">Language</label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <input type="number" class="form-control requires-validation validate-save validate-minimum" name="numberOfPages" id="numberOfPages" min="100">
									  <div class="invalid-feedback"></div>
									  <label for="years">Number of Pages</label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="d-flex align-items-center justify-content-end">
										<button class="btn btn-primary" type="submit">Save</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- jQuery (No necesario en Bootstrap 5) -->
	<!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/validateHelper.js"></script>
	<script src="/js/validateForm.js"></script>
</body>
</html>
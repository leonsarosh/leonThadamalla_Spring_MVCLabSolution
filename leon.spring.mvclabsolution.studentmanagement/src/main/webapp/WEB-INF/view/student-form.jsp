<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Student Registration Form</title>
</head>
<body>
	<div class="container">
		<h3>Student Form for ${mode}</h3>
		<form action="save" method="POST">
			<input type="hidden" name="studentId" value="${student.studentId}" class="form-control mb-4 col-4" />
			<input type="text" name="firstName" value="${student.firstName}" placeholder="First Name" class="form-control mb-4 col-4"> 
			<input type="text" name="lastName" value="${student.lastName}" placeholder="Last Name" class="form-control mb-4 col-4"> 
			<input type="text" name="course" value="${student.course}" placeholder="Course" class="form-control mb-4 col-4"> 
			<input type="text" name="country" value="${student.country}" placeholder="Country" class="form-control mb-4 col-4">
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>	
		<a href="list">Back to Students List</a>
		<hr>
		<h6>All fields are mandatory and should be strings only for successful add and update</h6>
	</div>
</body>
</html>
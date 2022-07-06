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
<title>CRM Customer Form</title>
</head>
<body>
<h3 align=center style="background-color:LightGrey;">Customer Form for ${mode}</h3>
	<div class="container">
		<form action="save" method="POST">
			<input type="hidden" name="customerId" value="${customer.customerId}" class="form-control mb-4 col-4" />
			<input type="text" name="custFirstName" value="${customer.custFirstName}" placeholder="First Name" class="form-control mb-4 col-4"> 
			<input type="text" name="lastName" value="${customer.lastName}" placeholder="Last Name" class="form-control mb-4 col-4"> 
			<input type="text" name="emailAdd" value="${customer.emailAdd}" placeholder="Email Address" class="form-control mb-4 col-4"> 
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>	
		<a href="list">Back to Customer List</a>
		<hr>
		<h6>All fields are mandatory and should be strings only for successful add and update</h6>
	</div>
</body>
</html>
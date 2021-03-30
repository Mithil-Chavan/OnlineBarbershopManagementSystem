<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>






<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Barber Shop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <div class="navbar-header">
    <img src="http://localhost:8080/about1.png" width="70" height="100" alt="Bootstrappin"/>
    </div>
     <a class="navbar-brand" > &nbsp&nbsp&nbsp FLOYD'S Online Barber Shop
      <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp For Men & Women</br> </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/shopkeeper/appointments">Home</a></li>
       <li><a href="/about">About Us</a></li>
      <li><a href="/contact">Contact Us</a></li>
    
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li><a href="<spring:url value='/user/login'/>">Log Out</a></li>
    </ul>
  </div>
</nav>

<div class="container">
<caption><h2>Services List</h2></caption>
<table  border="1" class="table table-striped table-bordered">
				<tr>
					<th>Service Name</th><th>ServiceDescription</th><th>Service Price</th><th>Service Duration</th><th>select</th><th>Delete</th><th>Update</th>
				</tr>
			
 					<c:forEach var="s" items="${requestScope.services_list}">
			
				<tr>
						<td> ${s.serviceName}</td>
						<td>${s.serviceDescription}</td>
						<td>${s.servicePrice}</td>
						<td>${s.serviceDuration}</td>
						<td><input type="checkbox" value="${s.serviceId}" name="services"></td>
				<td><a href="<spring:url value='/shopkeeper/removeservice?sid=${s.serviceId}'/>">Delete</a></td>
				<td><a href="<spring:url value='/shopkeeper/updateservice?sid=${s.serviceId}'/>">Update</a></td>
			</tr>
		</c:forEach> 
	</table>
	</div>

</body>
</html>

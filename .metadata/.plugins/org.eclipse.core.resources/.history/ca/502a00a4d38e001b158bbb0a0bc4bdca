<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>




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
    <img src="http://localhost:8080/about1.png" width="70" height="100" alt="Bootstrappin"/>
    </div>
    <div class="navbar-header">
       <a class="navbar-brand" > &nbsp&nbsp&nbsp FLOYD'S Online Barber Shop
      <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp For Men & Women</br> </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="/about">About Us</a></li>
      <li><a href="/contact">Contact Us</a></li>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
           <li><a href="<spring:url value='/user/login'/>">Log Out</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
 <sf:form method="post" action="selectservices">
<caption><h2>Select Shop from ${sessionScope.shop_location}</h2></caption>
<div >
		<caption><h2>Shops List</h2></caption>
		
		<div class="container">
				<table border="1" class="table table-striped table-bordered">
	
		<tr>
			<th>Shop Name </th><th>Location</th><th>Mobile No</th><th>Owner Name</th><th>Reviews</th><th>Shop Open/Close </th><th>Select</th>
		</tr>
	
		<c:forEach var="s" items="${requestScope.shops_list}">
			<tr>
				<td>${s.shopName}</td>
				<td>${s.location}</td>
				<td>${s.contactNumber}</td>
				<td>${s.ownerName}</td>
				<td>${s.reviews}</td>
				<td>${s.status}</td>
				<td><input type="radio" value="${s.shopId}" name="shopId"></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<%--
	
	<select name="shop">
	<c:forEach var="s" items="${requestScope.shops_list}">
		<option value="${s.shopId}">${s.shopName}</option>
	</c:forEach>
	</select>
	
	--%>
		<input type="submit" class="btn btn-success" value="submit">
	</div>

	</sf:form>
 
</div>

</body>
</html>

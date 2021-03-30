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
<style>
body {
	margin: 0;
	padding: 0;
	font-weight: Century Gothic;
	/*  background: url("http://localhost:8080/Background1.jpg")no-repeat;
	background-size: cover; */ 
	background-position: center;
	width:100%; height:650px;
}
.container{
	height: 80vh;
 	width: 80%;
	background: rgba(255, 255, 255, .85);
	position: absolute;
	top: 60%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 0 20px;
}

.img{
	height: 140px;
	width: 100px;
	background: url("http://localhost:8080/about1.png")no-repeat;
	background-size: cover;
	background-position:center;
	border-radius: 50px;
	position: absolute;
	top: 0%;
	left: 50%;
	transform: translate(-50%, -50%);
}
.container h1{
	color: white;
	margin-top: 70px;
	
}	
.container p{
	color: white;
	margin-top: 60px;
	font-size: large;
	
}
.btn{
	background: repeat;
	outline: none;
	border: 1px solid white;
	color: white;
	width: 50%;
	padding: 7px 15px;
	font_size: large;
	cursor: pointer;
	transition: 0.3s ease;
	margin-top: 50px;
}
.btn:hover{
	background: white;
	color: black;
	
}
	


</style>

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
 <table border="1" class="table table-striped table-bordered">

		<caption><h2>Shops List</h2></caption>
			<tr>
			<th>Shop Name </th><th>Location</th><th>Mobile No</th><th>Owner Name</th><th>Reviews</th><th>Shop Open/Close </th>
		</tr>
		<c:forEach var="s" items="${requestScope.shops_list}">
			<tr>
				<td>${s.shopName}</td>
				<td>${s.location}</td>
				<td>${s.contactNumber}</td>
				<td>${s.ownerName}</td>
				<td>${s.reviews}</td>
				<td>${s.status}</td>
				<%-- <c:forEach var="serv" items="${s.services}">
				<td>${serv.serviceName}</td>
				</c:forEach>--%>
				
				<td><a href="<spring:url value='/admin/delete?sid=${s.shopId}'/>">Delete</a></td>
				<td><a href="<spring:url value='/admin/update?sid=${s.shopId}'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<spring:url value='/admin/register'/>">Add New shop</a>
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body {
	margin: 0;
	padding: 0;
	font-weight: Century Gothic;
 	background: url("http://localhost:8080/contactimg.png")no-repeat; 
	background-size: cover;
	background-position: center;
	width:100%; height:650px;
}
.container{
	height: 75vh;
 	width: 80%;
	background: rgba(0, 0, 0, .6);
	position: absolute;
	top: 50%;
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
	background: no-repeat;
	outline: none;
	border: 1px solid white;
	color: white;
	width: 10%;
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

.social-menu ul{
	position: absolute;
	top: 90%;
	left: 50%;
	padding: 0;
	margin: 0;
	transform: translate(-50%, -50%);
	display: flex;
}
.social-menu ul li{
	list-style: none;
	margin: 0 15px;
	
}	
.social-menu ul li .fa{
	font-size: 30px;
	line-height: 60px;
	transition: .6s;
	color: #000;
}
.social-menu ul li .fa:hover {
	color: #fff;
}

.social-menu ul li a{
	position: relative;
	display: block;
	width: 60px;
	height: 60px;
	border-radius: 50%;
	background-color: #fff;
	text-align: center;
	transition: .6s;
	box-shadow: 0 5px 4px rgba(0,0,0,.5);	
}	
.social-menu ul li a:hover {
	transform: translate(0, -10px);
}
.social-menu ul li:nth-child(1) a:hover {	
	background-color: #3b5999;
}
.social-menu ul li:nth-child(2) a:hover {	
	background-color: #e4405f;
}
.social-menu ul li:nth-child(3) a:hover {	
	background-color: #55acee;
}
.social-menu ul li:nth-child(4) a:hover {	
	background-color: #25D366;
}





</style>
</head>
<body>
<div class="social-menu">


<div class="container">
<body> 
<div class="social-menu">
<ul>
	<li><a href="#"><i class="fa fa-facebook"></i></a></li>
	<li><a href="#"><i class="fa fa-instagram"></i></a></li>
	<li><a href="#"><i class="fa fa-twitter"></i></a></li>
	<li><a href="#"><i class="fa fa-whatsapp"></i></a></li>

</ul>

</div>
</body>


<center>
	<h1>Contact Us...</h1>
 	<div class="img">
 	
 	</div> 
 	
 	<h2> <p style="color:white;"><p style="text-align:center;">ADDRESS  :-    123,Main Street, Pune 1001<left></p></h2>
 	<h2> <p style="color:white;"><p style="text-align:center;">MAIL ID  :- Floyd.barbershop@gmail.com<left></p></h2>
 	<h2> <p style="color:white;"><p style="text-align:center;">CONTACT NO :- 123-456-7890<left></p></h2>
 	
 	
 	
</center>


</body>
</html>
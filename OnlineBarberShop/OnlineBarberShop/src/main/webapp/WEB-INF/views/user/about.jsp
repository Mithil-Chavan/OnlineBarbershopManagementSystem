<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<!-- <meta charset="ISO-8859-1"> -->

<title>About Us</title>
</head>
<body>


<style>
body {
	margin: 0;
	padding: 0;
	font-weight: Century Gothic;
	background: url("http://localhost:8080/About.jpg")no-repeat;
	background-size: cover;
	background-position: center;
	width:100%; height:650px;
}
.container{
	height: 75vh;
 	width: 30%;
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





<div class="container">
<center>
	<h1>About Us...</h1>
 	<div class="img">
 	
 	</div> 
 	
 	   <h4> <p style="color:white;"> Floyds Barbershop mixes excellent service with the new style appeal of an
 		 experienced and talented staff. From the diverse styles and personalities of our stylists
 		 and barbers, to our signature poster wall plastered with a time machine of music
 		 legends and icons,We offer a full menu of services for everyone, including haircuts, hair color, fades, beard
 		 trims, straight razor shaves, and signature massage shampoo, finishing every service
 		 vibe, and haircuts with an unbeatable value. On top of that, no two shops are the same
 		 and meaning the Floyds Barbershop experience is truly one of a kind.
 	</p></h4>
 	<button class="btn"><h2>Read more</h2></button>
</center>


</body>
</html>
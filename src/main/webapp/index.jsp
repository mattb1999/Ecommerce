<%@page import="com.gruppomcr.dao.session.UtenteDAOSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="Style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<%@ include file = "template/Navbar.jsp" %>
	<%@ include file = "template/Footer.jsp" %>
	
<div style="text-align:center;">
	<h2 >Discover a new way to shop online with <b style="color:orange">Foodazon</b></h2>
	<button style="background-color:orange;" type="button" class="btn btn-alert p-4 rounded-circle btn-lg"><b>Shop</b></button>
</div>	

<div class="grid"> 
 	<div style="height:450px; width:300px; background-color:black; border-radius:10px; margin-top:1%;display:inline-block" class="box1"></div>
 	<div style="height:300px; width:450px; border-radius:10px; margin-top:10%;margin-left:10%;"class="box2"></div>
 	<div style="height:450px; width:300px; background-color:black; border-radius:10px; margin-top:1%;margin-left:250%;"class="box3"></div>	
</div>
	<div class="grid">
	<div style="height:300px; width:450px; background-color:green; border-radius:10px;margin-top:1%; margin-left:10%"class="box4"></div>
	<div style="height:300px; width:450px; background-color:green; border-radius:10px;margin-top:1%; margin-left:200%"class="box5"></div>
</div>


</body>
</html>

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


<title>LoginPage</title>
</head>
<body>
<%@ include file = "template/Navbar.jsp" %>
<%@ include file = "template/Footer.jsp" %>


<div id="alertA">
<%if (request.getAttribute("loggato")!=null&&request.getAttribute("loggato").toString().contentEquals("false")) { %>
<div id="alertB" class="alert alert-danger" role="alert">
<a>Il <b>nome utente</b> o la <b>password</b> sono errati!</a>
<%} %>
</div>
</div>
 <%if(request.getSession().getAttribute("utente")==null) { %>
<header class="header">
	<div>
		<section class="sect1">
			<h2>Log In and start shopping at <b>Foodazon</b>!</h2>

	<div id="log" class="container-fluid">
	<h1>Log In!</h1>
	<form action="LoginServlet" method="get">
		<input id="fieldLog" type="text" class="form-control" name="usr" id="usr" placeholder="Username"/>
		<br/>
		<input id="fieldLog" type="password" class="form-control" name="psw" id="psw" placeholder="Password"/>
		<br/>
		<button id="butLog" type="submit" class="btn btn-primary" id="psw">Log In</button>
		
		
	</form>
	<h5>NON HAI UN ACCOUNT?</h5>
	<a href="Registra.jsp">REGISTRATI!</a>
	</div>
		</section>
	</div>
</header>
<%} %>
<%if(request.getSession().getAttribute("utente")!=null) { %>
<div class="container">
<div class="left">
<section>
	<h2 class="firstL">Hello</h2>
	<br>
	<br>
	<h2 class="secondL"><%=utente.getModel().getUser() %></h2>
	<br>
	<br>
	<h2 class="thirdL">Let's start</h2>
	<br>
	<br>
	<h2 class="fifthL">Shopping at</h2>
	<br>
	<br>
	<h2 class="fourthL"><b>Foodazon</b>!</h2>
</section>
</div>
<div class="right">
<section>
<div id="log" class="container-fluid">
	<div style="margin:auto; text-align:center;">
<h3 style="color:darkorange">I TUOI DATI</h3>
</div>
<br>
<table class="table table-bordered">
<thead class="table-black">
<tr>
<th scope="col">Nome</th>
<td scope="col"><%=utente.getModelAnag().getNome() %></td>
</tr>
<tr>
<th scope="col">Cognome</th>
<td scope="col"><%=utente.getModelAnag().getCognome()%></td>
</tr>
<tr>
<th scope="col">Mail</th>
<td scope="col"><%=utente.getModelAnag().getMail()%></td>
</tr>
<tr>
<th scope="col">Cellulare</th>
<td scope="col"><%=utente.getModelAnag().getTelefono() %></td>
</tr>
<tr>
<th scope="col">Città</th>
<td scope="col"><%=utente.getModelAnag().getCitta() %></td>
</tr>
<tr>
<th scope="col">Indirizzo</th>
<td scope="col"><%=utente.getModelAnag().getIndirizzo() %></td>
</tr>
<tr>
<th scope="col">Via</th>
<td scope="col"><%=utente.getModelAnag().getVia() %></td>
</tr>
</thead>
</table>
</div>
</section>
</div>
</div>
<%} %>
</body>

</html>
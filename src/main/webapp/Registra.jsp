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
<title>Sig In</title>

</head>
<body>
<%@ include file = "template/Navbar.jsp" %>
<%@ include file = "template/Footer.jsp" %>

<div class="divAlertReg">
<%if (request.getAttribute("registrato")!=null&&request.getAttribute("registrato").toString().contentEquals("false")) { %>
<div id="divAlertReg2" class="alert alert-danger" role="alert">
<a>Il <b>nome utente</b> o la <b>password</b> sono errati!</a>
<%} %>
</div>
</div>

<div class="container">
<div class="left">
<section>
	<h2 class="firstL">Sign In</h2>
	<br>
	<br>
	<h2 class="secondL">and Explore</h2>
	<br>
	<br>
	<h2 class="thirdL">how Amazing</h2>
	<br>
	<br>
	<h2 class="fourthL"><b>Foodazon</b> is!</h2>
</section>
</div>
<div class="right">
<section>
<div class="cornice">
	<form action="RegistraServlet" method="get">
<div class="form-group">
    <label for="inputUser">Username</label>
    <input type="text" class="form-control" name="user" id="inputUser" placeholder="Username" required>
  </div>
  <div class="form-group">
    <label for="inputPass">Password</label>
    <input type="password" class="form-control" name="pwd" id="inputPass" placeholder="Password" required>
  </div>
  <div class="form-group">
    <label for="inputNome">Nome</label>
    <input type="text" class="form-control" name="nome" id="inputNome" placeholder="Nome" required>
  </div>
  <div class="form-group">
    <label for="inputCognome">Cognome</label>
    <input type="text" class="form-control" name="cognome" id="inputCognome" placeholder="Cognome" required>
  </div>
  <div class="form-group">
    <label for="inputIndirizzo">Indirizzo</label>
    <input type="text" class="form-control" name="indirizzo" id="inputIndirizzo" placeholder="Indirizzo" required>
  </div>
  <div class="form-group">
    <label for="inputCitta">Città</label>
    <input type="text" class="form-control" name="citta" id="inputCitta" placeholder="Città" required>
  </div>
  <div class="form-group">
    <label for="inputIndirizzo">Via</label>
    <input type="text" class="form-control" name="via" id="inputVia" placeholder="Via" required>
  </div>
  <div class="form-group">
    <label for="inputEmail">Indirizzo E-Mail</label>
    <input type="email" name="mail" class="form-control" id="inputEmail" aria-describedby="emailHelp" placeholder="Inserisci email" required>
    
  </div>
  <div class="form-group">
    <label for="inputIndirizzo">Telefono</label>
    <input type="text" class="form-control" name="telefono" id="inputTelefono" placeholder="Telefono" required>
  </div>
  
  
  <button style="background-color:DarkOrange; margin-top:10px" type="submit" class="btn btn-primary">INVIO</button>
</form>
</div>
</section>
</div>
</div>
</body>
</html>
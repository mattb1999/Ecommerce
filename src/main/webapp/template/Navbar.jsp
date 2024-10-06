<%@page import="com.gruppomcr.dao.session.UtenteDAOSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand navbar-light bg-light">
         <div class="container-fluid">
            <img src="images/logoCarrello.png" class="logo">
            <a class="navbar-brand">Foodazon</a>
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
            <li class="nav-item">
          <a class="nav-link" href="index.jsp">Home</a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="Login.jsp">Account</a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="Carrello.jsp">Carrello</a>
          </li>
    <%
	UtenteDAOSession utente = (UtenteDAOSession) session.getAttribute("utente");
	%>
         <%if(request.getSession().getAttribute("utente")!=null && utente.getModel().getIdProfilo()==99) { %>
       	    <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Bentornato <%=utente.getModel().getUser() %> !
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="Catalogo.jsp">Catalogo</a></li>
            <li><a class="dropdown-item" href="ListaFatture.jsp">Le mie Fatture</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="Logout.jsp">Log Out</a></li>
          </ul>
         </li>
        <%} %>
         <%if(request.getSession().getAttribute("utente")!=null && utente.getModel().getIdProfilo()==1) { %>
       	    <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Bentornato Admin!
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="AddArticoli.jsp">Aggiungi Articoli</a></li>
            
            <li><a class="dropdown-item" href="Logout.jsp">Log Out</a></li>
          </ul>
         </li>
        <%} %>
        </ul>
        </div>
        </div>
</nav>
</body>
</html>
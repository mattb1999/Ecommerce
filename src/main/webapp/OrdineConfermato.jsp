<%@page import="com.gruppomcr.dao.session.UtenteDAOSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%
	UtenteDAOSession utente = (UtenteDAOSession) session.getAttribute("utente");
	%>
	<div id="logoCarrello" class="container-fluid">

</div>
<br>
<br>
<div class="container-fluid">
<h1 style="text-align:center;">ORDINE CONFERMATO! TORNA ALLA <a href="index.jsp">HOME</a></h1>
</div>
</body>
</html>
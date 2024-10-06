<%@page import="com.gruppomcr.dao.session.UtenteDAOSession" %>
<%@page import="java.util.*" %>
<%@page import="com.gruppomcr.dao.model.ArticoliDAOModel" %>
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
    
<title>CATALOGO</title>

</head>
<body>
<%@ include file = "template/Navbar.jsp" %>
<%@ include file = "template/Footer.jsp" %>

	

<form action="CarrelloServlet" method="get">
<div class="catalog">
<div class="container-fluid">
	<table class="table table-bordered">
	<%
	List<ArticoliDAOModel> lista = (List<ArticoliDAOModel>) session.getAttribute("lista");
%>
  <thead class="table-black">
    <tr>
    <th scope="col">Acquista</th>
      <th scope="col">Id</th>
      <th scope="col">Nome</th>
      <th scope="col">Prezzo</th>
      <th scope="col">Disponibile</th>
      <th>Quantità</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <%for(ArticoliDAOModel articolo:lista){ %>
    <tr>
    	<td><input type="checkbox" name="<%=articolo.getId()%>" value="1"></td>
      <th scope="row"><%= articolo.getCodice()%></th>
      <td><%=articolo.getNome_commerciale() %></td>
      <td><%=articolo.getPrezzo() %></td>
      <%if(articolo.isIsvalid()){ %>
      <td>Si</td>
    <%  }else{ %>
      <td>No</td>
      <% } %>
      <td><input type="number" min="1" value="1" name="<%=articolo.getCodice() %>"></td>
    </tr>
    <%} %>
    
  </tbody>
  
</table>
</div>
<div id="butP">
<button style="background-color:DarkOrange; margin-top:10px" type="submit" class="btn btn-primary">Aggiungi al Carrello</button>
</div>
</div>
</form>
</body>
</html>
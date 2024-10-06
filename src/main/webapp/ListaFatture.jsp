<%@page import="com.gruppomcr.dao.session.UtenteDAOSession" %>
<%@page import="com.gruppomcr.dao.model.FattureDAOModel" %>
<%@page import="java.util.*" %>
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
<%@ include file = "template/Navbar.jsp" %>
<%@ include file = "template/Footer.jsp" %>

	<%
	System.out.println(request.getSession().getAttribute("listaFatture"));
	List<FattureDAOModel> listaFatture = (List<FattureDAOModel>)session.getAttribute("listaFatture");
	%>

	
<%if(session.getAttribute("utente")!=null&&session.getAttribute("listaFatture")!=null) { %>	
	<div>
<table class="table table-bordered">
	
	
  <thead class="table-black">
    <tr>
      <th scope="col">Numero Fattura</th>
      <th scope="col">Importo</th>
      <th scope="col">Iva</th>    
      <th scope="col">IdCliente</th>
      <th scope="col">dataFattura</th>    
      <th scope="col">NumeroFornitore</th>  
      <th scope="col">IdOrdine</th>          
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <%
  for(FattureDAOModel model:listaFatture) { %>
		 
	 <tr>
      <td scope="row"><%=model.getNumeroFattura() %></td>
      <td scope="row"><%=model.getImporto() %></td>
      <td scope="row"><%=model.getIva() %></td> 
      <td scope="row"><%=model.getIdCliente() %></td> 
      <td scope="row"><%=model.getDataFattura() %></td> 
      <td scope="row"><%=model.getNumeroFornitore() %></td> 
      <td scope="row"><%=model.getId_ordine() %></td>     
    </tr>
 <% } %>
    
  </tbody>
</table>
</div>
<%} %>	
</body>
</html>
<%@page import="java.util.*" %>
<%@page import="com.gruppomcr.dao.model.ArticoliDAOModel" %>
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
<form action="OrdineConfermatoServlett" method="get">
<%
	List<ArticoliDAOModel> listaOrdine = (List<ArticoliDAOModel>) session.getAttribute("listaOrdine");
	%>

<div style="margin:auto; text-align:center;">
<h3>DATI ACQUIRENTE</h3>
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
<br>
<div style="margin:auto; text-align:center;">
<h3>DETTAGLI ORDINE</h3>
</div>
<br>
<div>

<table class="table table-bordered">
	
	
  <thead class="table-black">
    <tr>
      <th scope="col">Prodotto</th>
      <th scope="col">Prezzo</th>
      <th scope="col">Quantità</th>    
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <%
  for(ArticoliDAOModel model:listaOrdine) { %>
		 
	 <tr>
      <td scope="row"><%=model.getNome_commerciale() %></td>
      <td scope="row"><%=model.getPrezzo() %></td>
      <td scope="row"><input type="number" name="<%=model.getCodice()%>" value="<%=model.getQuantita()%>" min="0"></td>     
    </tr>
 <% } %>
    
    <tr>
      <th scope="row">Importo Totale</th>
      <td><%=session.getAttribute("impFinale") %> Euro</td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
</table>
</div>
<div id="butP" >
<button id="butLog" class="btn btn-primary">PAGA</button>
</div>
</form>
</body>
</html>
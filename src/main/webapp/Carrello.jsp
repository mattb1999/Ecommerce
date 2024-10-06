<%@page import="java.util.*" %>
<%@page import="com.gruppomcr.dao.model.ArticoliDAOModel" %>
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
<form action="OrdineServlet" method="get">
<%@ include file = "template/Navbar.jsp" %>
<%@ include file = "template/Footer.jsp" %>

	<%if((List<ArticoliDAOModel>) session.getAttribute("listaCarrello")!=null) { %>

	<table class="table">
	<%
	List<ArticoliDAOModel> listaCarrello = (List<ArticoliDAOModel>) session.getAttribute("listaCarrello");
	%>
	
  <thead>
    <tr>
      <th scope="col">Nome</th>
      <th scope="col">Prezzo</th>
      <th scope="col">Quantità</th>
      
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <%
  for(ArticoliDAOModel model:listaCarrello) { %>
		 
	 <tr>
      <td scope="row"><%=model.getNome_commerciale() %></td>
      <td scope="row"><%=model.getPrezzo() %></td>
      <td scope="row"><input type="number" name="<%=model.getCodice()%>" value="<%=model.getQuantita()%>" min="0"></td>      
    </tr>
 <% } %>
    
    <tr>
      <th scope="row">Sub Totale</th>
      <td><%=session.getAttribute("importo") %> Euro</td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
</table>
<div id="butP">
<button style="background-color:DarkOrange; margin-top:10px" type="submit" class="btn btn-primary">Vai all'ordine</button>
</div>
 </form>
<%} %>

<%if(request.getSession().getAttribute("utente")==null || (List<ArticoliDAOModel>) session.getAttribute("listaCarrello")==null) { %>

<div id="logoCarrello" class="container-fluid">

</div>
<br>
<br>
<div class="container-fluid">
<h1 style="text-align:center;">Oh Oh! Il carrello è vuoto!</h1>
</div>
<%} %>
</body>
</html>
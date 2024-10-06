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
	<%@ include file="template/Navbar.jsp"%>
	<%@ include file="template/Footer.jsp"%>

	<%
	if (request.getSession().getAttribute("utente") != null) {
	%>
	<div class="divAlertReg">
		<%
		if (request.getAttribute("aggiunto") != null && request.getAttribute("aggiunto").toString().contentEquals("true")) {
		%>
		<div id="divAlertReg2" class="alert alert-success" role="alert">
			<a>L'<b>articolo</b> è stato aggiunto correttamente!
			</a>
			<%
			}
			%>
		</div>
	</div>
	<div class="container">
		<div class="left">
			<section>
				<h2 class="firstL">Hello</h2>
				<br> <br>
				<h2 class="secondL"><%=utente.getModel().getUser()%></h2>
				<br> <br>
				<h2 class="thirdL">Let's start</h2>
				<br> <br>
				<h2 class="fifthL">
					<b>ADDING</b> products
				</h2>
				<br> <br>
				<h2 class="fourthL">
					<b>Foodazon</b>!
				</h2>
			</section>
		</div>
		<div class="right">
			<section>

				<div id="log">
					<h3 style="color: darkorange">AGGIUNGI ARTICOLI</h3>
					
					<form action="AddArticoliServlet" method="get">
						<input id="fieldLog" type="text" class="form-control" name="nome"
							id="nome" placeholder="Nome commerciale" /> <br /> 
							<input
							id="fieldLog" type="text" class="form-control" name="codice"
							id="codice" placeholder="Codice Prodotto" /> <br /> 
							<input
							id="fieldLog" type="text" class="form-control" name="prezzo"
							id="prezzo" placeholder="Prezzo" /> <br /> <input id="fieldLog"
							type="text" class="form-control" name="marca" id="marca"
							placeholder="Marca Prodotto" />


						<button id="butLog" type="submit" class="btn btn-primary">Aggiungi
							Articolo</button>
					</form>
				</div>
			</section>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>
package com.gruppomcr.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gruppomcr.dao.concrete.AnagraficaDAO;
import com.gruppomcr.dao.concrete.LoginDAO;

/**
 * Servlet implementation class RegistraServlet
 */
@WebServlet
public class RegistraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("registrato",false);
		
		
		LoginDAO login = new LoginDAO();
		AnagraficaDAO anagrafica = new AnagraficaDAO();
		
		try {
			
			login.eseguiInsert(request.getParameter("user"), request.getParameter("pwd"));
			anagrafica.eseguiInsert(request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("indirizzo"), request.getParameter("citta"),request.getParameter("via"),request.getParameter("mail"), request.getParameter("telefono") );
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			request.setAttribute("registrato", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Registra.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

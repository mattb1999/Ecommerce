package com.gruppomcr.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.concrete.FattureDAO;
import com.gruppomcr.dao.model.FattureDAOModel;
import com.gruppomcr.dao.session.UtenteDAOSession;

/**
 * Servlet implementation class ListaFattureServlet
 */
@WebServlet
public class ListaFattureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UtenteDAOSession utente = (UtenteDAOSession) session.getAttribute("utente");
		
		try {
			
			FattureDAO fattu=new FattureDAO();
		List<FattureDAOModel> listaFatture =fattu.eseguiSelectById(utente.getModelAnag().getId());
		request.getSession().setAttribute("listaFatture", listaFatture);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListaFatture.jsp");
		dispatcher.forward(request, response);
		}catch(Exception e) {
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

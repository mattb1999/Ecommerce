package com.gruppomcr.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import com.gruppomcr.dao.concrete.ArticoliDAO;


/**
 * Servlet implementation class AddArticoliServlet
 */
@WebServlet
public class AddArticoliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("aggiunto",false);
		
		
		ArticoliDAO articolo = new ArticoliDAO();
		
		try {
			articolo.eseguiInsert(request.getParameter("nome"),request.getParameter("codice"),Double.parseDouble(request.getParameter("prezzo")), request.getParameter("marca"));
			
			
			request.setAttribute("aggiunto",true);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddArticoli.jsp");
			
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			
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

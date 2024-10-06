package com.gruppomcr.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.model.ArticoliDAOModel;
import com.gruppomcr.dao.session.UtenteDAOSession;

/**
 * Servlet implementation class OrdineConfermatoServlett
 */
@WebServlet
public class OrdineConfermatoServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession();
		
		UtenteDAOSession utente = (UtenteDAOSession) session.getAttribute("utente");
		
		double impFinale = 0;
		
		List<ArticoliDAOModel> listaCarrello = new ArrayList<ArticoliDAOModel>((List<ArticoliDAOModel>) session.getAttribute("listaCarrello"));
		List<ArticoliDAOModel> listaOrdine = new ArrayList<ArticoliDAOModel>();
		List<String> quantita2 = new ArrayList<String>();
		
		for(ArticoliDAOModel articolo:listaCarrello) {
			String codice = articolo.getCodice();
			quantita2.add(request.getParameter(codice));
		}
		
		for(int i = 0, j = 0; i<listaCarrello.size()&&j<quantita2.size();i++,j++) {
			ArticoliDAOModel model = listaCarrello.get(i);
			String quantita = quantita2.get(j);
			model.setQuantita(Integer.valueOf(quantita));
			impFinale += model.getQuantita() * model.getPrezzo();
			listaOrdine.add(model);
		}
		
		
		try {
			utente.getOrdinedao().eseguiInsert(utente.getModel().getId());
			utente.getFattura().eseguiInsert(impFinale, 22, utente.getModelAnag().getId(), Date.valueOf(LocalDate.now()), 1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		utente.setOrdini(listaOrdine);
		
		
		session.setAttribute("listaOrdine", listaOrdine);
		session.setAttribute("impFinale", impFinale);
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrdineConfermato.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

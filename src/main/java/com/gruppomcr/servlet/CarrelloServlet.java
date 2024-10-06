package com.gruppomcr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.concrete.ArticoliDAO;
import com.gruppomcr.dao.model.ArticoliDAOModel;
import com.gruppomcr.dao.session.UtenteDAOSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet
public class CarrelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			
			UtenteDAOSession utente = (UtenteDAOSession) session.getAttribute("utente");
			
			double impTot=0;
			
			ArticoliDAO art = new ArticoliDAO();
			
			List<ArticoliDAOModel> listaArt = new ArrayList<ArticoliDAOModel>(art.eseguiSelect());
			List<ArticoliDAOModel> listaCarrello = new ArrayList<ArticoliDAOModel>();
			
			for(ArticoliDAOModel articolo:listaArt) {
				int id = articolo.getId();
				if(request.getParameter(id+"")!=null&& !request.getParameter(id+"").contentEquals("")) {
					listaCarrello.add(articolo);
					String codice = articolo.getCodice();
					if(request.getParameter(codice)!=null&& !request.getParameter(codice).contentEquals("")) {
						articolo.setQuantita(Integer.parseInt(request.getParameter(codice)));
						
						
						impTot += articolo.getQuantita() * articolo.getPrezzo();
						
					}
				}
			}
			
			utente.setCarrello(listaCarrello);
			
			session.setAttribute("listaCarrello", listaCarrello);
			session.setAttribute("importo", impTot);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Carrello.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

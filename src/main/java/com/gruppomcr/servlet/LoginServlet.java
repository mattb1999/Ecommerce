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

import com.gruppomcr.dao.concrete.AnagraficaDAO;
import com.gruppomcr.dao.concrete.ArticoliDAO;
import com.gruppomcr.dao.concrete.FattureDAO;
import com.gruppomcr.dao.concrete.LoginDAO;
import com.gruppomcr.dao.model.AnagraficaDAOModel;
import com.gruppomcr.dao.model.ArticoliDAOModel;
import com.gruppomcr.dao.model.FattureDAOModel;
import com.gruppomcr.dao.model.LoginDAOModel;
import com.gruppomcr.dao.session.UtenteDAOSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //è un Long e serve alla servlet per viaggiare in rete
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("loggato",false);
		String username = request.getParameter("usr");
		String pass = request.getParameter("psw");
		
		System.out.println(username+" "+pass);
		
		LoginDAO login = new LoginDAO();
		
		AnagraficaDAO anag = new AnagraficaDAO();
		AnagraficaDAOModel modelAnag = new AnagraficaDAOModel();
		
		HttpSession session = request.getSession();
		
		UtenteDAOSession utente = new UtenteDAOSession();
		
		try {
			
			
			LoginDAOModel model = login.checkLogin(username, pass);
			String usr2=model.getUser();
			String psw2=model.getPassword();
			
			if(model!=null&&usr2!=null&&psw2!=null&&usr2.contentEquals(username)&&psw2.contentEquals(pass)) {
				
				modelAnag = anag.eseguiSelectById(model.getId());
				utente.setModel(model);
				utente.setModelAnag(modelAnag);
				ArticoliDAO articoli = new ArticoliDAO();
				List<ArticoliDAOModel> lista = new ArrayList<ArticoliDAOModel>(articoli.eseguiSelect());
				
				FattureDAO fattu=new FattureDAO();
				List<FattureDAOModel> listaFatture =fattu.eseguiSelectById(utente.getModelAnag().getId());
				
				
				session.setAttribute("listaFatture", listaFatture);
				
				session.setAttribute("utente", utente);
				
				session.setAttribute("lista", lista);
				
				request.setAttribute("loggato", true);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("loggato", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
				System.out.println("Login non effettuato");
			}
		} catch (Exception e) {
		
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

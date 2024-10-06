package com.gruppomcr.dao.session;
import java.util.List;

import com.gruppomcr.dao.concrete.AnagraficaDAO;
import com.gruppomcr.dao.concrete.ArticoliDAO;
import com.gruppomcr.dao.concrete.FattureDAO;
import com.gruppomcr.dao.concrete.LoginDAO;
import com.gruppomcr.dao.concrete.OrdiniDAO;
import com.gruppomcr.dao.model.AnagraficaDAOModel;
import com.gruppomcr.dao.model.ArticoliDAOModel;
import com.gruppomcr.dao.model.FattureDAOModel;
import com.gruppomcr.dao.model.LoginDAOModel;
import com.gruppomcr.dao.model.OrdiniDAOModel;
import com.gruppomcr.dao.model.PermessiDAOModel;

public class UtenteDAOSession {
	
	AnagraficaDAOModel modelAnag = new AnagraficaDAOModel();
	AnagraficaDAO anag = new AnagraficaDAO();
	ArticoliDAOModel modelArt = new ArticoliDAOModel();
	ArticoliDAO art=new ArticoliDAO();
	LoginDAOModel model = new LoginDAOModel();
	LoginDAO log = new LoginDAO();
	List<ArticoliDAOModel> carrello;
	List<ArticoliDAOModel> ordini;
	FattureDAO fattura = new FattureDAO();
	FattureDAOModel fatturaModel;
	OrdiniDAO ordinedao = new OrdiniDAO();
	OrdiniDAOModel ordine = new OrdiniDAOModel();
	PermessiDAOModel permessi = new PermessiDAOModel();

	public LoginDAOModel getModel() {
		return model;
	}

	public void setModel(LoginDAOModel model) {
		this.model = model;
	}

	public AnagraficaDAOModel getModelAnag() {
		return modelAnag;
	}

	public void setModelAnag(AnagraficaDAOModel modelAnag) {
		this.modelAnag = modelAnag;
	}

	public AnagraficaDAO getAnag() {
		return anag;
	}

	public void setAnag(AnagraficaDAO anag) {
		this.anag = anag;
	}

	public ArticoliDAOModel getModelArt() {
		return modelArt;
	}

	public void setModelArt(ArticoliDAOModel modelArt) {
		this.modelArt = modelArt;
	}

	public ArticoliDAO getArt() {
		return art;
	}

	public void setArt(ArticoliDAO art) {
		this.art = art;
	}

	public LoginDAO getLog() {
		return log;
	}

	public void setLog(LoginDAO log) {
		this.log = log;
	}

	public List<ArticoliDAOModel> getCarrello() {
		return carrello;
	}

	public void setCarrello(List<ArticoliDAOModel> carrello) {
		this.carrello = carrello;
	}

	public List<ArticoliDAOModel> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<ArticoliDAOModel> ordini) {
		this.ordini = ordini;
	}

	public FattureDAO getFattura() {
		return fattura;
	}

	public void setFattura(FattureDAO fattura) {
		this.fattura = fattura;
	}

	public OrdiniDAOModel getOrdine() {
		return ordine;
	}

	public void setOrdine(OrdiniDAOModel ordine) {
		this.ordine = ordine;
	}

	public OrdiniDAO getOrdinedao() {
		return ordinedao;
	}

	public void setOrdinedao(OrdiniDAO ordinedao) {
		this.ordinedao = ordinedao;
	}

	public FattureDAOModel getFatturaModel() {
		return fatturaModel;
	}

	public void setFatturaModel(FattureDAOModel fatturaModel) {
		this.fatturaModel = fatturaModel;
	}

	public PermessiDAOModel getPermessi() {
		return permessi;
	}

	public void setPermessi(PermessiDAOModel permessi) {
		this.permessi = permessi;
	}

	


	
}

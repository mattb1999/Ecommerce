package com.gruppomcr.dao.model;

public class ArticoliDAOModel {
	private int id=0;
	private String nome_commerciale=null;
	private String codice=null;
	private double prezzo=0.0;
	private String articolo=null;
	private boolean isvalid=true;
	private int quantita=0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_commerciale() {
		return nome_commerciale;
	}
	public void setNome_commerciale(String nome_commerciale) {
		this.nome_commerciale = nome_commerciale;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getArticolo() {
		return articolo;
	}
	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}
	public boolean isIsvalid() {
		return isvalid;
	}
	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}

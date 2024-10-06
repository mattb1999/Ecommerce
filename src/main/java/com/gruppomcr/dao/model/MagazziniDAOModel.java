package com.gruppomcr.dao.model;

public class MagazziniDAOModel {
	private int id=0;
	private String citta=null;
	private String indirizzo=null;
	private String tipologia;;
	private boolean parcheggio_aziendale=true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia ;
	}
	public boolean isParcheggio_aziendale() {
		return parcheggio_aziendale;
	}
	public void setParcheggio_aziendale(boolean parcheggio_aziendale) {
		this.parcheggio_aziendale = parcheggio_aziendale;
	}
	
	

}

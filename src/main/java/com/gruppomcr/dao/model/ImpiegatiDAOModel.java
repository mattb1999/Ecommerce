package com.gruppomcr.dao.model;

public class ImpiegatiDAOModel {
	private int id=0;
	private String cognome=null;
	private int id_dipartimento=0;
	private boolean isValid=true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getId_dipartimento() {
		return id_dipartimento;
	}
	public void setId_dipartimento(int id_dipartimento) {
		this.id_dipartimento = id_dipartimento;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
}

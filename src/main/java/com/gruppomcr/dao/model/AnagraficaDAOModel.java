package com.gruppomcr.dao.model;

public class AnagraficaDAOModel {
	private int id=0;
	private String nome=null;
	private String cognome=null;
	private String indirizzo=null;
	private int idlogin=0;
	private String citta=null;
	private String via=null;
	private String mail=null;
	private String telefono=null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdlogin() {
		return idlogin;
	}
	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}
	
	
}

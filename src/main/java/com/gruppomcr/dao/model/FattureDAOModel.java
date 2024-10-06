package com.gruppomcr.dao.model;

import java.sql.Date;

public class FattureDAOModel {
	private int numeroFattura=0;
	
	private Double importo=0.0;
	private int iva=0;
	private int idCliente=0;
	private Date dataFattura=null;
	private int numeroFornitore=0;
	private int id_ordine=0;
	
	public int getNumeroFattura() {
		return numeroFattura;
	}
	public void setNumeroFattura(int numeroFattura) {
		this.numeroFattura = numeroFattura;
	}
	
	public Double getImporto() {
		return importo;
	}
	public void setImporto(Double importo) {
		this.importo = importo;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getDataFattura() {
		return dataFattura;
	}
	public void setDataFattura(Date dataFattura) {
		this.dataFattura = dataFattura;
	}
	public int getNumeroFornitore() {
		return numeroFornitore;
	}
	public void setNumeroFornitore(int numeroFornitore) {
		this.numeroFornitore = numeroFornitore;
	}
	public int getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}
	
	
	
}

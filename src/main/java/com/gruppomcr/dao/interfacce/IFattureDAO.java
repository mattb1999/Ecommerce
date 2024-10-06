package com.gruppomcr.dao.interfacce;

import java.sql.Date;
import java.util.List;

import com.gruppomcr.dao.model.FattureDAOModel;




public interface IFattureDAO {
	
	   public void eseguiDelete(int id) throws Exception;

	    public void eseguiInsert(double importo,int iva,int idCliente,Date dataFattura,int numeroFornitore) throws Exception;

	    public List<FattureDAOModel> eseguiSelectById(int idCliente) throws Exception;


	    public void eseguiUpdateById(int numeroFattura, double importo,int iva,int idCliente,Date dataFattura,int numeroFornitore,int id_ordine) throws Exception;

	    public List<FattureDAOModel> eseguiSelect() throws Exception;

}

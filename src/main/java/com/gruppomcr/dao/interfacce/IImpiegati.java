package com.gruppomcr.dao.interfacce;

import java.util.List;

import com.gruppomcr.dao.model.ImpiegatiDAOModel;



public interface IImpiegati {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( String cognome,int id_dipartimento,boolean isValid) throws Exception;

    public ImpiegatiDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id, String cognome,int id_dipartimento) throws Exception;

    public List<ImpiegatiDAOModel> eseguiSelect() throws Exception;

}

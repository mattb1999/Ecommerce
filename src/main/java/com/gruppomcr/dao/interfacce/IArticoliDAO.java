package com.gruppomcr.dao.interfacce;

import java.util.List;

import com.gruppomcr.dao.model.ArticoliDAOModel;

public interface IArticoliDAO {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( String nome_commerciale,String codice, double prezzo,String articolo) throws Exception;

    public ArticoliDAOModel eseguiSelectById(String codice) throws Exception;


    public void eseguiUpdateById(int id, String nome_commerciale,String codice, double prezzo,String articolo) throws Exception;

    public List<ArticoliDAOModel> eseguiSelect() throws Exception;
}

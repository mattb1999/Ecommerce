package com.gruppomcr.dao.interfacce;

import java.util.List;


import com.gruppomcr.dao.model.Articoli_ordini_relDAOModel;

public interface IArticoli_ordini_RelDAO {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( int...articoli) throws Exception;

    public Articoli_ordini_relDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id,int id_ordini,int id_articoli) throws Exception;

    public List<Articoli_ordini_relDAOModel> eseguiSelect() throws Exception;
}

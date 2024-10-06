package com.gruppomcr.dao.interfacce;

import java.util.List;



import com.gruppomcr.dao.model.Magazzini_articoli_relDAOModel;

public interface IMagazzini_articoli_relDAO {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( int id_magazzini,int id_articoli) throws Exception;

    public Magazzini_articoli_relDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id, int id_magazzini,int id_articoli) throws Exception;

    public List<Magazzini_articoli_relDAOModel> eseguiSelect() throws Exception;
}

package com.gruppomcr.dao.interfacce;

import java.util.List;

import com.gruppomcr.dao.model.PermessiDAOModel;


public interface IPermessiDAO {
	
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert(String funzione, int idProfilazione) throws Exception;

    public PermessiDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(String funzione, int idProfilazione, int id) throws Exception;

    public List<PermessiDAOModel> eseguiSelect() throws Exception;
}

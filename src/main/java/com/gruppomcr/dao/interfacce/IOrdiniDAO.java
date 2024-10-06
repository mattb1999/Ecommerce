package com.gruppomcr.dao.interfacce;

import java.util.List;


import com.gruppomcr.dao.model.OrdiniDAOModel;

public interface IOrdiniDAO {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert(int id) throws Exception;

    public OrdiniDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id, int id_articoliordirel, int id_login) throws Exception;

    public List<OrdiniDAOModel> eseguiSelect() throws Exception;
}

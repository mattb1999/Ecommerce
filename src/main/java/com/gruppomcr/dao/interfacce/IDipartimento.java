package com.gruppomcr.dao.interfacce;

import java.util.List;


import com.gruppomcr.dao.model.DipartimentoDAOModel;

public interface IDipartimento {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( String nome) throws Exception;

    public DipartimentoDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id, String nome) throws Exception;

    public List<DipartimentoDAOModel> eseguiSelect() throws Exception;

}

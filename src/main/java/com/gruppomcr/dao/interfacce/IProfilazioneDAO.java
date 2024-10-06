package com.gruppomcr.dao.interfacce;

import java.util.List;


import com.gruppomcr.dao.model.ProfilazioneDAOModel;

public interface IProfilazioneDAO {
	
	public void eseguiDelete(int codiceProfilo) throws Exception;

    public void eseguiInsert(int codiceProfilo, String profilo) throws Exception;

    public ProfilazioneDAOModel eseguiSelectById(int codiceProfilo) throws Exception;


    public void eseguiUpdateById(int codiceProfilo, String profilo) throws Exception;

    public List<ProfilazioneDAOModel> eseguiSelect() throws Exception;
}

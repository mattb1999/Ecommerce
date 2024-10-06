package com.gruppomcr.dao.interfacce;

import java.util.List;


import com.gruppomcr.dao.model.MagazziniDAOModel;

public interface IMagazzini {
	public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( String citta,String indirizzo, String tipologia,boolean parcheggio_aziendale) throws Exception;

    public MagazziniDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id, String citta,String indirizzo, String tipologia,boolean parcheggio_aziendale) throws Exception;

    public List<MagazziniDAOModel> eseguiSelect() throws Exception;
}

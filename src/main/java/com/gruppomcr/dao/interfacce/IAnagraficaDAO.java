package com.gruppomcr.dao.interfacce;

import java.util.List;

import com.gruppomcr.dao.model.AnagraficaDAOModel;


public interface IAnagraficaDAO {
    public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( String nome, String cognome,String indirizzo,String citta,String via,String mail,String telefono) throws Exception;

    public AnagraficaDAOModel eseguiSelectById(int id) throws Exception;


    public void eseguiUpdateById(int id, String nome, String cognome,String indirizzo,String citta,String via,String mail,String telefono,int idlogin) throws Exception;

    public List<AnagraficaDAOModel> eseguiSelect() throws Exception;
}

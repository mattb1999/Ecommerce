  package com.gruppomcr.dao.interfacce;

import java.util.List;

import com.gruppomcr.dao.model.LoginDAOModel;


//ABSTRACT DAO
public interface ILoginDAO {

    public void eseguiDelete(int id) throws Exception;

    public void eseguiInsert( String user, String password) throws Exception;

    public LoginDAOModel eseguiSelectById(int id) throws Exception;

    public LoginDAOModel checkLogin(String user, String password) throws Exception;

    public void eseguiUpdateById(int id, String user, String password) throws Exception;

    public List<LoginDAOModel> eseguiSelect() throws Exception;

}

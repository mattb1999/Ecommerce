package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.ILoginDAO;
import com.gruppomcr.dao.model.LoginDAOModel;
import com.gruppomcr.persistence.ConnectionManager;


public class LoginDAO implements ILoginDAO {


    LoginDAOModel userbean;

    @Override

    public List<LoginDAOModel> eseguiSelect() throws Exception {

        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        List<LoginDAOModel> lista = new ArrayList<LoginDAOModel>();

        try {

            conn = connM.getConnection();


            java.sql.PreparedStatement query = conn.prepareStatement("select * from login ");


            ris = query.executeQuery();


            while (ris.next()) {
                userbean = new LoginDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setPassword(ris.getString("password"));
                userbean.setUser(ris.getString("user"));
                userbean.setIdProfilo(ris.getInt("id_profilo"));
                lista.add(userbean);
            }


            query.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }

        }

        return lista;
    }

    @Override
    // metodo che mi restituisce un oggetto di tipo UserBean
    public LoginDAOModel eseguiSelectById(int id) throws Exception {
        // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        LoginDAOModel resultBean = new LoginDAOModel();
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from login where id = ?");
            query.setInt(1, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

                resultBean.setId(ris.getInt("id"));
                resultBean.setPassword(ris.getString("password"));
                resultBean.setUser(ris.getString("user"));
                resultBean.setIdProfilo(ris.getInt("id_profilo"));
            }


            query.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }

        }

        return resultBean;
    }

    

    @Override

    public LoginDAOModel checkLogin(String user, String password) throws Exception {

        // creo un oggetto della classe ConnectionManager

        String sql = "select * from login where user=? and password=?";

        ConnectionManager connM = new ConnectionManager();

        ResultSet ris;

        LoginDAOModel loginModel = new LoginDAOModel();

        try (Connection conn = connM.getConnection();

             PreparedStatement query = conn.prepareStatement(sql)){



            query.setString(1, user);

            query.setString(2, password);

            

           //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL

            ris = query.executeQuery();





            if (ris.next()) {

                loginModel.setId(ris.getInt("id"));

                loginModel.setPassword(ris.getString("password"));

                loginModel.setUser(ris.getString("user"));
                
                loginModel.setIdProfilo(ris.getInt("id_profilo"));

            }
            





            query.close();

        } catch (Exception ex) {

            ex.printStackTrace();

            throw new Exception(ex.getMessage());

        }



        return loginModel;

    }


    @Override
    // Update login
    public void eseguiUpdateById(int id, String user, String password) throws Exception {
        // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE login SET user=? , password=? WHERE id = ?");
            query.setString(1, user);
            query.setString(2, password);
            query.setInt(3, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            int y = query.executeUpdate();

            if (y == 0) {
                System.out.println("ATTENZIONE Update non riuscito");
            } else if(y > 1) {
                System.out.println("ATTENZIONE Update non riuscito riscontrati multirecord");
            }



            query.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }

        }
    }

    @Override
    // Update login
    public void eseguiInsert( String user, String password) throws Exception {
        // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO login VALUES ((SELECT MAX(id)+1 FROM login as log),?,?,true,99)");
            
            query.setString(1, user);
            query.setString(2, password);


            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            int y = query.executeUpdate();

            if (y == 0) {
                System.out.println("ATTENZIONE Inserimento non riuscito");
            }

            query.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }

        }

    }

    @Override
    // Update login
    public void eseguiDelete(int id) throws Exception {
        // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE login SET isOn=0 WHERE id = ?");
            
            query.setInt(1, id);


            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            int y = query.executeUpdate();

            if (y == 0) {
                System.out.println("ATTENZIONE Delete non riuscito");
            }

            query.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }

        }

    }




}

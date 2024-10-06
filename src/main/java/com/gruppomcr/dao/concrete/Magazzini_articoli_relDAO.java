 package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IMagazzini_articoli_relDAO;
import com.gruppomcr.dao.model.Magazzini_articoli_relDAOModel;
import com.gruppomcr.persistence.ConnectionManager;

public class Magazzini_articoli_relDAO implements IMagazzini_articoli_relDAO {
	Magazzini_articoli_relDAOModel userbean;
	@Override
	public void eseguiDelete(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE magazzini_articoli_rel  SET  isValid=0 WHERE id = ?");
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
            }}

	}

	@Override
	public void eseguiInsert( int id_magazzini, int id_articoli) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO magazzini_articoli_rel VALUES ((SELECT MAX(id)+1 FROM magazzini_articoli_rel as magart),?,?)");
           
            query.setInt(1, id_magazzini);
            query.setInt(2, id_articoli);
            
            


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
	public Magazzini_articoli_relDAOModel eseguiSelectById(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from magazzini_articoli_rel where id = ?");
            query.setInt(1, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

            	userbean = new Magazzini_articoli_relDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setId_magazzini(ris.getInt("id_magazzini"));;
                userbean.setId_articoli(ris.getInt("id_articoli"));
                
                
                
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

        return userbean;
	}

	@Override
	public void eseguiUpdateById(int id, int id_magazzini, int id_articoli) throws Exception {
		/// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE magazzini_articoli_rel  SET  id_magazzini=?, id_articoli=? WHERE id = ?");
            
            
            query.setInt(1, id_magazzini);
            query.setInt(2, id_articoli);
            
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
	public List<Magazzini_articoli_relDAOModel> eseguiSelect() throws Exception {
		ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<Magazzini_articoli_relDAOModel> lista = new ArrayList<Magazzini_articoli_relDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from magazzini_articoli_rel ");


	            ris = query.executeQuery();


	            while (ris.next()) {
	                userbean = new Magazzini_articoli_relDAOModel();
	                userbean.setId(ris.getInt("id"));
	                userbean.setId_magazzini(ris.getInt("id_magazzini"));;
	                userbean.setId_articoli(ris.getInt("id_articoli"));
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

}

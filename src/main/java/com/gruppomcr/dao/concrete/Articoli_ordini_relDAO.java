package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IArticoli_ordini_RelDAO;
import com.gruppomcr.dao.model.Articoli_ordini_relDAOModel;
import com.gruppomcr.persistence.ConnectionManager;

public class Articoli_ordini_relDAO implements IArticoli_ordini_RelDAO {
	Articoli_ordini_relDAOModel userbean;
	@Override
	public void eseguiDelete(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE articolo_ordini_rel  SET  isValid=0 WHERE id = ?");
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
	public void eseguiInsert(int...articoli ) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            for(int a:articoli) {
            	java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO articoli_ordini_rel VALUES ((SELECT MAX(id)+1 FROM articolo_ordini_rel as artord),?,(SELECT MAX(id) FROM ordini as ord))");
            	query.setInt(1, a);
            	int y = query.executeUpdate();
            	query.close();
            	 if (y == 0) {
                     System.out.println("ATTENZIONE Inserimento non riuscito");
                 }
            }
            


            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            

           

            
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
	public Articoli_ordini_relDAOModel eseguiSelectById(int id) throws Exception {
		 // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from articoli_ordini_rel where id = ?");
            query.setInt(1, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

            	userbean = new Articoli_ordini_relDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setId_articolo(ris.getInt("id_articoli"));;
                userbean.setId_ordini(ris.getInt("id_ordini"));
                
                
                
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
	public void eseguiUpdateById(int id, int id_ordini, int id_articoli) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE articoli_ordini_rel  SET  id_ordini=?, id_articoli=? WHERE id = ?");
            
            
            query.setInt(1, id_ordini);
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
	public List<Articoli_ordini_relDAOModel> eseguiSelect() throws Exception {
		 ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<Articoli_ordini_relDAOModel> lista = new ArrayList<Articoli_ordini_relDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from articoli_ordini_rel ");


	            ris = query.executeQuery();


	            while (ris.next()) {
	                userbean = new Articoli_ordini_relDAOModel();
	                userbean.setId(ris.getInt("id"));
	                userbean.setId_articolo(ris.getInt("id_articoli"));;
	                userbean.setId_ordini(ris.getInt("id_ordini"));
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

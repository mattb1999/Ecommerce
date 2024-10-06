package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IMagazzini;
import com.gruppomcr.dao.model.MagazziniDAOModel;
import com.gruppomcr.persistence.ConnectionManager;

public class MagazziniDAO implements IMagazzini{
	MagazziniDAOModel userbean;
	@Override
	public void eseguiDelete(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE magazzini SET isValid=0 WHERE id = ?");
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
	public void eseguiInsert( String citta, String indirizzo, String tipologia,
			boolean parcheggio_aziendale) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO magazzini VALUES ((SELECT MAX(id)+1 FROM magazzini as mag),?,?,?,?)");
            
            query.setString(1, citta);
            query.setString(2, indirizzo);
            query.setString(3, tipologia);
            query.setBoolean(4, parcheggio_aziendale);
            
            
            


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
	public MagazziniDAOModel eseguiSelectById(int id) throws Exception {
		 // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from magazzini where id = ?");
            query.setInt(1, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

            	userbean = new MagazziniDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setCitta(ris.getString("citta"));
                userbean.setTipologia(ris.getString("tipologia"));
                userbean.setParcheggio_aziendale(ris.getBoolean("parcheggio_aziendale"));
             ;
                
                
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
	public void eseguiUpdateById(int id, String citta, String indirizzo, String tipologia,
			boolean parcheggio_aziendale) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE magazzini SET  citta=?, indirizzo=?, id_tipologia_magazino=?, parcheggio_aziendale=? WHERE id = ?");
            
            
            query.setString(1, citta);
            query.setString(2, indirizzo);
            query.setString(3, tipologia);
            query.setBoolean(4, parcheggio_aziendale);
            query.setInt(5,id);

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
	public List<MagazziniDAOModel> eseguiSelect() throws Exception {
		 ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<MagazziniDAOModel> lista = new ArrayList<MagazziniDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from magazzini ");


	            ris = query.executeQuery();


	            while (ris.next()) {
	                userbean = new MagazziniDAOModel();
	                userbean.setId(ris.getInt("id"));
	                userbean.setCitta(ris.getString("citta"));
	                userbean.setTipologia(ris.getString("tipologia"));
	                userbean.setParcheggio_aziendale(ris.getBoolean("parcheggio_aziendale"));
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

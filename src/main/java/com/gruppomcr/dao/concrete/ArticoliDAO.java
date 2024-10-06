package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IArticoliDAO;
import com.gruppomcr.dao.model.ArticoliDAOModel;

import com.gruppomcr.persistence.ConnectionManager;

public class ArticoliDAO implements IArticoliDAO {
	ArticoliDAOModel userbean;
	@Override
	public void eseguiDelete(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE articoli SET  isValid=0 WHERE id = ?");
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
	public void eseguiInsert( String nome_commerciale, String codice, double prezzo, String articolo)
			throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO articoli VALUES ((SELECT MAX(id)+1 FROM articoli as art),?,?,?,?, isValid=true,id_fatture=0)");
            
            query.setString(1, nome_commerciale);
            query.setString(2, codice);
            query.setDouble(3, prezzo);
            query.setString(4, articolo);
            
            
            


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
	public ArticoliDAOModel eseguiSelectById(String codice) throws Exception {
		 // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from articoli where codice = ?");
            query.setString(1, codice);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

            	userbean = new ArticoliDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setNome_commerciale(ris.getString("nome_commerciale"));
                userbean.setPrezzo(ris.getDouble("prezzo"));
                userbean.setCodice(ris.getString("codice"));
                userbean.setArticolo(ris.getString("articolo"));
                
                
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
	public void eseguiUpdateById(int id, String nome_commerciale, String codice, double prezzo, String articolo)
			throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE articoli SET  nome_commerciale=?, codice=?, prezzo=?, articolo=? WHERE id = ?");
            
            
            query.setString(1, nome_commerciale);
            query.setString(2, codice);
            query.setDouble(3, prezzo);
            query.setString(4, articolo);
            query.setInt(5, id);
           

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
	public List<ArticoliDAOModel> eseguiSelect() throws Exception {
		 ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<ArticoliDAOModel> lista = new ArrayList<ArticoliDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from articoli");


	            ris = query.executeQuery();


	            while (ris.next()) {
	                userbean = new ArticoliDAOModel();
	                userbean.setId(ris.getInt("id"));
	                userbean.setNome_commerciale(ris.getString("nome_commerciale"));
	                userbean.setPrezzo(ris.getDouble("prezzo"));
	                userbean.setCodice(ris.getString("codice"));
	                userbean.setArticolo(ris.getString("articolo"));
	                userbean.setIsvalid(ris.getBoolean("isValid"));
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

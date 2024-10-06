package com.gruppomcr.dao.concrete;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IAnagraficaDAO;
import com.gruppomcr.dao.model.AnagraficaDAOModel;

import com.gruppomcr.persistence.ConnectionManager;

public class AnagraficaDAO implements IAnagraficaDAO{
	  AnagraficaDAOModel userbean;

	@Override
	public void eseguiDelete(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE anagrafica SET  isOn=0 WHERE id = ?");
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
	public void eseguiInsert( String nome, String cognome, String indirizzo, String citta, String via,
			String mail, String telefono) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO anagrafica VALUES ((SELECT MAX(id)+1 FROM anagrafica as ana),?,?,?,?,?,?,?,(SELECT MAX(id) FROM login as log),1)");
            query.setString(1, nome);
            query.setString(2, cognome);
            query.setString(3, indirizzo);
            query.setString(4, citta);
            query.setString(5, via);
            query.setString(6, mail);
            query.setString(7, telefono);
            


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
	public AnagraficaDAOModel eseguiSelectById(int id) throws Exception {
	    // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from anagrafica where id = ?");
            query.setInt(1, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

            	userbean = new AnagraficaDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setNome(ris.getString("nome"));
                userbean.setCognome(ris.getString("cognome"));;
                userbean.setIndirizzo(ris.getString("indirizzo"));;
                userbean.setCitta(ris.getString("citta"));;
                userbean.setVia(ris.getString("via"));;
                userbean.setMail(ris.getString("mail"));;
                userbean.setTelefono(ris.getString("telefono"));;
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
	public void eseguiUpdateById(int id, String nome, String cognome, String indirizzo, String citta, String via,
			String mail, String telefono,int idlogin) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE anagrafica SET  nome=? , cognome=?, indirizzo=?, citta=?, via=?, mail=?, telefono=?,idlogin? WHERE id = ?");
            
            query.setString(1, nome);
            query.setString(2,cognome);
            query.setString(3,indirizzo);
            query.setString(4,citta);
            query.setString(5,via);
            query.setString(6,mail);
            query.setString(7,telefono);
            query.setInt(8, idlogin);
            query.setInt(9, id);

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
	public List<AnagraficaDAOModel> eseguiSelect() throws Exception {
		 ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<AnagraficaDAOModel> lista = new ArrayList<AnagraficaDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from anagrafica ");


	            ris = query.executeQuery();


	            while (ris.next()) {
	            	userbean = new AnagraficaDAOModel();
	                userbean.setId(ris.getInt("id"));
	                userbean.setNome(ris.getString("nome"));
	                userbean.setCognome(ris.getString("cognome"));;
	                userbean.setIndirizzo(ris.getString("indirizzo"));;
	                userbean.setCitta(ris.getString("citta"));;
	                userbean.setVia(ris.getString("via"));;
	                userbean.setMail(ris.getString("mail"));;
	                userbean.setTelefono(ris.getString("telefono"));;
	                userbean.setIdlogin(ris.getInt("idlogin"));
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

package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IDipartimento;

import com.gruppomcr.dao.model.DipartimentoDAOModel;
import com.gruppomcr.persistence.ConnectionManager;

public class DipartimentoDAO implements IDipartimento {
	DipartimentoDAOModel userbean;

	@Override
	public void eseguiDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("DELETE FROM dipartimenti WHERE id=?");
            java.sql.PreparedStatement query2 = conn.prepareStatement("UPDATE impiegati SET id_dipartimento=0 as iddip,isValid=0 WHERE id_dipartimento=?");
            query2.setInt(1, id);
            query.setInt(1, id);


            
            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            int x=query2.executeUpdate();
            int y = query.executeUpdate();

            if (y == 0 && x==0) {
                System.out.println("ATTENZIONE Delete non riuscito");
            }

            query.close();
            query2.close();
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
	public void eseguiInsert( String nome) throws Exception {
		// TODO Auto-generated method stub
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO dipartimenti VALUES ((SELECT MAX(id)+1 FROM dipartimenti as dip),?)");
            
            query.setString(1, nome);
            
            


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
	public DipartimentoDAOModel eseguiSelectById(int id) throws Exception {
		ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from dipartimenti where id = ?");
            query.setInt(1, id);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            if (ris.next()) {

            	userbean = new DipartimentoDAOModel();
                userbean.setId(ris.getInt("id"));
                userbean.setNome(ris.getString("nome"));
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
	public void eseguiUpdateById(int id, String nome) throws Exception {
		// TODO Auto-generated method stub
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE dipartimenti SET  nome=? WHERE id = ?");
            
            query.setString(1, nome);
            query.setInt(2, id);

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
	public List<DipartimentoDAOModel> eseguiSelect() throws Exception {
		ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<DipartimentoDAOModel> lista = new ArrayList<DipartimentoDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from dipartimenti ");


	            ris = query.executeQuery();


	            while (ris.next()) {
	                userbean = new DipartimentoDAOModel();
	                userbean.setId(ris.getInt("id"));
	                userbean.setNome(ris.getString("nome"));
	                
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

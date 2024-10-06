package com.gruppomcr.dao.concrete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gruppomcr.dao.interfacce.IFattureDAO;
import com.gruppomcr.dao.model.FattureDAOModel;
import com.gruppomcr.persistence.ConnectionManager;

public class FattureDAO implements IFattureDAO{
	FattureDAOModel userbean;

	@Override
	public void eseguiDelete(int id) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE fatture SET  isValid=0 WHERE id = ?");
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
	public void eseguiInsert(double importo, int iva, int idCliente,
			Date dataFattura, int numeroFornitore) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("INSERT INTO fatture(NumeroFattura,Importo,Iva,IdCliente,DataFattura,NumeroFornitore,isValid,id_ordini) VALUES ((SELECT MAX(numeroFattura)+1 FROM fatture as fat),?,?,?,?,?,1,(SELECT MAX(ord.id)FROM ordini as ord))");
            
            
            query.setDouble(1, importo);
            query.setInt(2, iva);
            query.setInt(3, idCliente);
            query.setDate(4, dataFattura);
            query.setInt(5,numeroFornitore);
            
            
            


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
	public List<FattureDAOModel> eseguiSelectById(int idCliente) throws Exception {
		  // creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        ResultSet ris;
        List<FattureDAOModel> lista = new ArrayList<FattureDAOModel>();
        
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("select * from fatture where idCliente = ?");
            query.setInt(1, idCliente);

            //restituisci un insieme di risultati(ResultSet) contenente le righe della tabella che soddisfano la condizione specificata dall'interrogazione SQL
            ris = query.executeQuery();


            while (ris.next()) {
            	userbean = new FattureDAOModel();
                userbean.setNumeroFattura(ris.getInt("NumeroFattura"));
                userbean.setImporto(ris.getDouble("Importo"));
                userbean.setIva(ris.getInt("Iva"));
                userbean.setIdCliente(ris.getInt("IdCliente"));
                userbean.setDataFattura(ris.getDate("DataFattura"));
                userbean.setNumeroFornitore(ris.getInt("NumeroFornitore"));
                userbean.setId_ordine(ris.getInt("id_ordini"));
                lista.add(userbean);
                
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

        return lista;
	}

	@Override
	public void eseguiUpdateById(int numeroFattura, double importo, int iva, int idCliente,
			Date dataFattura, int numeroFornitore,int id_ordine) throws Exception {
		// creo un oggetto della classe ConnectionManager
        ConnectionManager connM = new ConnectionManager();
        Connection conn = null;
        try {
            // richiamo il metodo che ho create per la connessione
            conn = connM.getConnection();

            // crea un istanza della classe PreparedStatament che � una sottoclasse di Statament per eseguire istruzioni sql
            java.sql.PreparedStatement query = conn.prepareStatement("UPDATE fatture SET Importo=?, Iva=?, IdCliente=?, DataFattura=?, NumeroFornitore=?, id_ordine=? WHERE NumeroFattura = ?");
            
            
            
            query.setDouble(1, importo);
            query.setInt(2, iva);
            query.setInt(3, idCliente);
            query.setDate(4, dataFattura);
            query.setInt(5, numeroFornitore);
            
            query.setInt(6,id_ordine );
            query.setInt(7, numeroFattura);

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
	public List<FattureDAOModel> eseguiSelect() throws Exception {
		 ConnectionManager connM = new ConnectionManager();
	     Connection conn = null;
	     ResultSet ris;
	     List<FattureDAOModel> lista = new ArrayList<FattureDAOModel>();
	     try {

	            conn = connM.getConnection();


	            java.sql.PreparedStatement query = conn.prepareStatement("select * from fatture ");


	            ris = query.executeQuery();


	            while (ris.next()) {
	                userbean = new FattureDAOModel();
	                userbean.setNumeroFattura(ris.getInt("NumeroFattura"));
	                
	                userbean.setImporto(ris.getDouble("Importo"));
	                userbean.setIva(ris.getInt("Iva"));
	                userbean.setIdCliente(ris.getInt("IdCliente"));
	                userbean.setDataFattura(ris.getDate("DataFattura"));
	                userbean.setNumeroFornitore(ris.getInt("NumeroFornitore"));
	                userbean.setId_ordine(ris.getInt("id_ordini"));
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



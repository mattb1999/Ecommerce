package com.gruppomcr.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

    public Connection getConnection() throws Exception {
        Connection connection = null;// creo un oggetto di tipo connection
        String db_url = "jdbc:mysql://localhost:3306/laboratorio?serverTimezone=UTC";
        String user = "root";
        String psw = "m1234b56";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(db_url, user, psw);//identifica il db attraverso il protocollo jdbc perch� richiama il concetto di indirizzo IP
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return connection;
    }
}


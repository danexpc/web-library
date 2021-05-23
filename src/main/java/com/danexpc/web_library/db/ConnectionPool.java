package com.danexpc.web_library.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static final ConnectionPool instance = new ConnectionPool();

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Context cxt = new InitialContext();

            DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/library");
            con = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return con;
    }
}

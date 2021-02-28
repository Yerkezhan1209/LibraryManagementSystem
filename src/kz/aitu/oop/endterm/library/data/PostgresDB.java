package kz.aitu.oop.endterm.library.data;

import kz.aitu.oop.endterm.library.data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/library";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "dwrlwine20022E");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
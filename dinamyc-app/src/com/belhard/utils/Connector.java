package com.belhard.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost/Forum";

    private  Connection connection;

     {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(url, user, password);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  Connection getConnection() {
        return connection;
    }

    public  void setConnection(Connection connection) {
        this.connection = connection;
    }
}

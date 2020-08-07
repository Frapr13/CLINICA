package com.mysql.conexion;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.*;

public class conexion {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "paco";
    private static String URL = "jdbc:mysql://localhost:3306/db";

    static {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE DRIVER: " + e);
        }
    }

    @SuppressWarnings("NonPublicExported")
    public Conecction getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "CONECCION EXITOSA");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONECCION: " + e);
        }
        return (Conecction) con;
    }

    private static class Conecction {

        public Conecction() {
        }
    }

}

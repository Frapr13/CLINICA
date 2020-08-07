    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysql.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ele
 */
public class Connect {
       public static void Connect(){
    String url = "jdbc:mysql://localhost:3306/db";
    String user = "root";
    String pass = "paco";
    System.out.println("Conectando...");
    try(Connection connection = DriverManager.getConnection(url, user,pass)){
    System.out.println("Conectado!!");
    // vamos a insertar un registro
    System.out.println("Insertando ...");
    Statement s = connection.createStatement();
    String query1 = "insert into user (username,password,created_at) value (\"user1\",\"mypassword\",NOW())";
    s.executeUpdate(query1);
    
    // vamos a recorrer
    String query2 = "select * from user";
    ResultSet r = s.executeQuery(query2);
    
    while(r.next()){
        System.out.println(r.getObject("id") +" - " +r.getObject("username") + " - " +r.getObject("password"));
    }
    
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Connect();
    }
    
}
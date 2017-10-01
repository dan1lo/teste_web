/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author danilomonteiro
 */
public class FactoryConnection {
    
   // Connection con;
    PreparedStatement stmt;  
    
    String url =  "jdbc:mysql://localhost/teste";
    String user = "root";
    String senha = "";
    

   
    public Connection getConnection() throws ClassNotFoundException {
     try {
         Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection(
 url, user, senha);
         
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ice
 */
public  class OuterFactoryConnection {
    
    public static class InnerFactoryConnection{
        static Connection c;
        static ResultSet r;
        static Statement s;
        static String driver = "org.apache.derby.jdbc.ClientDriver";
        static String url = "jdbc:derby://localhost:1527/LabWeb192";
        static String user = "caio";
        static String senha = "admin";
        
        public static Connection getConnection() throws ClassNotFoundException, SQLException{
            Class.forName(driver);
            return DriverManager.getConnection(url, user, senha);
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controllers.OuterFactoryConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ice
 */
public abstract class GenericoDAO {
    Connection c = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        if(c == null){
            c = OuterFactoryConnection.InnerFactoryConnection.getConnection();
        }
        else{
            if(c.isClosed()){
                c = OuterFactoryConnection.InnerFactoryConnection.getConnection();
            }
        }
        return c;
    }
}

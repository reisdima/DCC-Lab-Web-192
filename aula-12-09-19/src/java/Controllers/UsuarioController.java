/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ice
 */
public class UsuarioController {
    Connection c;
    ResultSet r;
    Statement s;
    String driver = "org.apache.derby.jdbc.ClientDriver";
    String url = "jdbc:derby://localhost:1527/LabWeb192";
    String user = "caio";
    String senha = "admin";
    
    public List<Usuario> leBanco(){
        List<Usuario> usuarios = null;
        try{
            usuarios = new ArrayList();
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, senha);
            s = c.createStatement();
            r = s.executeQuery("select * from USUARIO");
            while(r.next()){
                Usuario usuario = new Usuario();
                usuario.setMatricula(r.getInt("MATRICULA"));
                usuario.setNome(r.getString("NOME"));
                usuario.setSenha(r.getString("SENHA"));
                usuarios.add(usuario);
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("e");
        }
        return usuarios;
    }
}

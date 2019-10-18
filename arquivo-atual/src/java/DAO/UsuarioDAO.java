/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ice
 */
public class UsuarioDAO extends GenericoDAO{
    
    public List<Usuario> getAll(){
        List<Usuario> usuarios = null;
        try{
            usuarios = new ArrayList();
            Statement s = getConnection().createStatement();
            ResultSet r = s.executeQuery("select * from USUARIO");
            while(r.next()){
                Usuario usuario = new Usuario();
                usuario.setMatricula(r.getInt("MATRICULA"));
                usuario.setNome(r.getString("NOME"));
                usuario.setSenha(r.getString("SENHA"));
                usuarios.add(usuario);
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("erro getAll");
        }
        return usuarios;
    }
    
    public Usuario getUsuario(int matricula) throws ClassNotFoundException{
        Usuario usuario = null;
        try{
            Statement s = getConnection().createStatement();
            ResultSet r = s.executeQuery("select * from USUARIO where matricula = " + matricula);
            if(r.next()){
                usuario = new Usuario();
                usuario.setMatricula(r.getInt("MATRICULA"));
                usuario.setNome(r.getString("NOME"));
                usuario.setSenha(r.getString("SENHA"));
            }
        }catch (SQLException e){
            System.out.println("erro getUsuario");
        }
        return usuario;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import DAO.Usuario;
import java.io.File;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ice
 */

public class s1 extends HttpServlet {
    Connection c;
    ResultSet r;
    Statement s;
    String driver = "org.apache.derby.jdbc.ClientDriver";
    String url = "jdbc:derby://localhost:1527/LabWeb192";
    String user = "caio";
    String senha = "admin";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        
        String origem = request.getParameter("origem");
        HttpSession session = request.getSession(true);
        
        if(session.getAttribute("ativo") == null && !origem.equals("login")){
            request.getSession().setAttribute("erro", "Sua sessão deve ter expirado");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        if("login".equals(origem)){
            //String senha = request.getServletContext().getInitParameter("senha");
            //String login = request.getServletContext().getInitParameter("login");
            
            String matriculaFormulario = request.getParameter("login");
            String senhaFormulario = request.getParameter("senha");
            Usuario u = this.leBanco(Integer.parseInt(matriculaFormulario));
            
            if(u != null){
                String senhaUsuario = u.getSenha();
                if(senhaUsuario.equals(senhaFormulario)){
                    request.getSession().setAttribute("ativo", "esta ativo");
                    request.getRequestDispatcher("menu.jsp").forward(request, response); //mudar de página
                }else{
                    // incluir o atributo erro no objeto session
                    request.getSession().setAttribute("erro", "senha errada");
                    request.getRequestDispatcher("login.jsp").forward(request, response); //mudar de página
                }
            }
            else{
                request.getSession().setAttribute("erro", "usuario nao existe");
                request.getRequestDispatcher("login.jsp").forward(request, response); //mudar de página
            }
        }
        else if(origem.equals("menu")){
            session.removeAttribute("ativo");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else if(origem.equals("lista") || origem.equals("rotator") || origem.equals("upload")){
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        }
        else if(origem.equals("upload_arquivo")){
            String file_name = "local.pdf";
            File file = null;
            int maxxFileSize = 10000*1024;
            int maxMemSize = 1000 *1024;
            ServletContext servletContext = getServletContext();
            String filePath = "/ice/NetBeansProjects/DCC-Lab-Web-192/arquivo-atual/web/docs";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Configure a repository (to ensure a secure temp location is used)
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File(filePath));
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(maxxFileSize);
            // Parse the request
            List fileItems = null;
            try{
                fileItems = upload.parseRequest((RequestContext) request);
            } catch(FileUploadException e){
                
            }
            
            Iterator i = fileItems.iterator();
            if(i.hasNext()){
                FileItem fi = (FileItem) i.next();
                if(!fi.isFormField()){
                    String fileName = fi.getFieldName();
                    if(fileName.lastIndexOf("\\") >= 0){
                        file = new File(filePath + fileName);
                    }
                    else{
                        file = new File(filePath + fileName);
                    }
                    try{
                        fi.write(file);
                    }catch(Exception ex){
                        Logger.getLogger(s1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }
        
        response.setContentType("text/html;charset=UTF-8");
    }
    
    public Usuario leBanco(int matricula){
        Usuario usuario = null;
        try{
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, senha);
            s = c.createStatement();
            r = s.executeQuery("select * from USUARIO where matricula = " + matricula);
            if(r.next()){
                usuario = new Usuario();
                usuario.setMatricula(r.getInt("MATRICULA"));
                usuario.setNome(r.getString("NOME"));
                usuario.setSenha(r.getString("SENHA"));
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("e");
        }
        return usuario;
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(s1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(s1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(s1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(s1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

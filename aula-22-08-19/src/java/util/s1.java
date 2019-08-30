/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ice
 */

public class s1 extends HttpServlet {
    
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
            throws ServletException, IOException {
        String origem = request.getParameter("origem");
        
        HttpSession session = request.getSession(true);
        if(session.getAttribute("ativo") == null && !origem.equals("login")){
            request.getSession().setAttribute("erro", "Sua sessão deve ter expirado");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        if("login".equals(origem)){
            String senha = request.getServletContext().getInitParameter("senha");
            String login = request.getServletContext().getInitParameter("login");
            String u_login = request.getParameter("login");
            String u_senha = request.getParameter("senha");
            if(login.equals(u_login) && senha.equals(u_senha)){
                request.getSession().setAttribute("ativo", "esta ativo");
                request.getRequestDispatcher("menu.jsp").forward(request, response); //mudar de página
            }else{
                // incluir o atributo erro no objeto session
                request.getSession().setAttribute("erro", "senha errada");
                request.getRequestDispatcher("login.jsp").forward(request, response); //mudar de página
            }
        }
        else if(origem.equals("menu")){
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        response.setContentType("text/html;charset=UTF-8");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

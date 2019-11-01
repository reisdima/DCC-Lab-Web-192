<%-- 
    Document   : index
    Created on : 31/10/2019, 21:56:45
    Author     : ice
--%>

<%@page import="javax.persistence.Persistence"%>
<%@page import="DAO.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="DAO.UsuarioJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadePersistencia");
            UsuarioJpaController usuc = new UsuarioJpaController(emf);
            List<Usuario> lu = usuc.findUsuarioEntities();
            for(Usuario u : lu){%>
            <p>Nome do usuario: <%= u.getNome() %></p>
        <%  }%>
        <h1>Hello World!</h1>
    </body>
</html>

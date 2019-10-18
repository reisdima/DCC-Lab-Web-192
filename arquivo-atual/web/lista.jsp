<%-- 
    Document   : lista
    Created on : 05/09/2019, 21:12:39
    Author     : ice
--%>

<%@page import="Model.Usuario"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="java.util.List"%>
<%@page import="Controllers.UsuarioController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "cabecalho.jsp" %>
<!DOCTYPE html>
<%
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    List<Usuario> usuarios = usuarioDAO.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="s1?origem=lista"><button class="btn btn-info">Voltar</button></a>
        <br>
        <ul class="list-group col-md-4">
            <li class="list-group-item">
                Usuario
            </li>
            <%for (Usuario u : usuarios){%>
            <li class="list-group-item">
                <%=u.getNome()%>
            </li>
            <%}%>
        </ul>
    </body>
</html>

<%-- 
    Document   : menu
    Created on : 15/08/2019, 21:55:26
    Author     : ice
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "cabecalho.jsp" %>
<!DOCTYPE html>
<%//throw new ServletException("teste"); %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        button{
            position: absolute;
            left: 50%;
            border: solid 1px black;
            text-align: center; 
        }
    </style>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="s1?origem=menu">Sair do sistema |</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="paginaNaoExistente">Link que não existe |</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="lista.jsp">Exibir usuários |</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="adrotator.jsp">Rotator |</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="upload_de_arquivo.jsp">Upload de arquivo</a>
              </li>
            </ul>
         </nav>
        <h2>Numero de usuarios: <%= request.getServletContext().getAttribute("userCounter")%></h2>
    </body>
</html>

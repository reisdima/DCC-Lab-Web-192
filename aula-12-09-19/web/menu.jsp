<%-- 
    Document   : menu
    Created on : 15/08/2019, 21:55:26
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%//throw new ServletException("teste"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                <a class="nav-link" href="s1?origem=menu">Sair do sistema</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="paginaNaoExistente">Link que não existe</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="lista.jsp">Exibir usuários</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="adrotator.jsp">Rotator</a>
              </li>
            </ul>
         </nav>
            
    </body>
</html>

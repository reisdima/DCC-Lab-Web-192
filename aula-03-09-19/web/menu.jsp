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
        
        <a href="s1?origem=menu">Sair do sistema</a>
        <br>
        <a href="paginaNaoExistente">Link que nao existe</a>
            
    </body>
</html>

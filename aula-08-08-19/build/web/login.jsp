<%-- 
    Document   : login
    Created on : 15/08/2019, 21:23:11
    Author     : ice
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
   <head>
        <title>Tela de login jsp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        .tempo{
            position: absolute;
            right: 20px;
            
        }
    </style>
    <body>
        <div class="tempo">
            <%= new Date() %>
        </div>
        <% if(session.getAttribute("erro") != null){%>
        <p> <%= session.getAttribute("erro") %>
            <% session.removeAttribute("erro");%>
        <%}%>
    <center>
        <h1>Tela de Login</h1>
        <form method=POST ACTION='s1'>
            <input type="text" placeholder="login" name="nome"><br><br>
            <input type="password" placeholder="senha" name="senha"><br><br>
            <input type="submit" value="Enviar">
        </form>
    </center>
    </body>
</html>

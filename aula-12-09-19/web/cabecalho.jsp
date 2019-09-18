<%-- 
    Document   : cabecalho
    Created on : 17/09/2019, 22:35:37
    Author     : ice
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page info="Escrito por: Caio Vincenzo Reis Dima"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>
            <%= getServletInfo() %>
            <br>
            IP: <%= request.getRemoteAddr() %>
            <br>
            <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date())    %>
        </h2>
    </body>
</html>

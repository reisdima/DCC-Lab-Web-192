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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container col-md-12">
            <h2>
                <%= getServletInfo() %>
                <br>
                IP: <%= request.getRemoteAddr() %>
                <br>
                <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date())    %>        
            </h2>
        </div>
    </body>
</html>

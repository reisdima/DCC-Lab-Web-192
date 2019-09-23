<%-- 
    Document   : login
    Created on : 15/08/2019, 21:23:11
    Author     : ice
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "cabecalho.jsp" %>
<!DOCTYPE html>
<html>
   <head>
        <title>Tela de login jsp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <style>
        .tempo{
            position: absolute;
            right: 20px;
            
        }
    </style>
    <body>
        
        <div class="tempo">
            
            <%--<%= // new Date() %>--%>
        </div>
        <% if(session.getAttribute("erro") != null){%>
        <p> <%= session.getAttribute("erro") %>
            <% session.removeAttribute("erro");%>
        <%}%>
    <center>
        <h1><span class="badge badge-secondary">Tela de Login</span></h1>
        <div class="container col-md-12">
            <form method=POST ACTION='s1'>
                <div class="form-group col-md-4">
                    <input class="form-control" type="text" placeholder="login" name="login">
                </div>
                <div class="form-group col-md-4">
                    <input class="form-control" type="password" placeholder="senha" name="senha">
                </div>
                <input type="hidden" value="login"name="origem">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </center>
<!--    <a>
        <img src="https://images-na.ssl-images-amazon.com/images/I/71wlUrbx68L._SY606_.jpg">
    </a>-->
    </body>
</html>

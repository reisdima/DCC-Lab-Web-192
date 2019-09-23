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
            <%= new Date() %>
        </div>
        <% if(session.getAttribute("erro") != null){%>
        <p> <%= session.getAttribute("erro") %>
            <% session.removeAttribute("erro");%>
        <%}%>
    <center>
        <h1>Tela de Login</h1>
        <div class="container">
            <form method=POST ACTION='s1'>
                <div class="form-group">
                    <input class="form-control" type="text" placeholder="login" name="login"><br><br>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" placeholder="senha" name="senha"><br><br>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
<!--                <div class="form-group">
                    <input class="form-control"type="submit" value="Enviar">
                </div>-->
                <input type="hidden" value="login" name="origem"><br><br>
            </form>
        </div>
    </center>
<!--    <a>
        <img src="https://images-na.ssl-images-amazon.com/images/I/71wlUrbx68L._SY606_.jpg">
    </a>-->
    </body>
</html>

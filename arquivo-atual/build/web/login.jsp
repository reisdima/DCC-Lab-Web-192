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
    </head>
    <style>
        
    </style>
    <body>
        <div class="container col-md-12">
            <div class="jumbotron" align="center">
                <% if(session.getAttribute("erro") != null){%>
                <p> <%= session.getAttribute("erro") %>
                    <% session.removeAttribute("erro");%>
                </p>
                <%}%>
                <h1>Tela de Login</h1>
                <form method=POST ACTION='s1'>
                    <div class="form-group col-md-4">
                        <input class="form-control" type="text" placeholder="login" name="login">
                    </div>
                    <div class="form-group col-md-4">
                        <input class="form-control" type="password" placeholder="senha" name="senha">
                    </div>
                    <input type="hidden" value="login" name="origem">
                    <button type="submit" class="btn btn-info">Submit</button>
                </form>
            </div>
        </div>
<!--    <a>
        <img src="https://images-na.ssl-images-amazon.com/images/I/71wlUrbx68L._SY606_.jpg">
    </a>-->
    </body>
</html>

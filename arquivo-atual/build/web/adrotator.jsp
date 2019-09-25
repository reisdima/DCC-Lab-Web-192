<%-- 
    Document   : adrotator
    Created on : 17/09/2019, 21:24:24
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "cabecalho.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="rotator" scope="session" class="util.Rotator" />
        <meta http-equiv="refresh" content="5">
        <title>AdRotator Example</title>
        <style>
            img{
                width: 500px;
                height: 700px;
            }
        </style>
        <% rotator.nextAd(); %>
    </head>
    <body>
        <a class="nav-link" href="s1?origem=rotator"><button class="btn btn-info">voltar</button></a>
        <div class="container col-md-12">
            <p class="big">AdRotator Example</p>
            <div >
                <a href="<jsp:getProperty name = "rotator" property = "link"/>">
                    <img src = "<jsp:getProperty name = "rotator" property = "image"/>"
                         alt="advertisement">
                </a>
            </div>
        </div>
    </body>
</html>

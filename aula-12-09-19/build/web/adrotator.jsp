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
        <% rotator.nextAd(); %>
    </head>
    <body>
        <p class="big">AdRotator Example</p>
        <button><a class="nav-link" href="s1?origem=menu">Sair do sistema</a></button>
        <p>
            <a href="<jsp:getProperty name = "rotator" property = "link"/>">
                <img src = "<jsp:getProperty name = "rotator" property = "image" />"
                     alt="advertisement">
            </a>
        </p>
    </body>
</html>

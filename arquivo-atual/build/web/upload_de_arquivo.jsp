<%-- 
    Document   : upload_de_arquivo
    Created on : 24/09/2019, 21:28:39
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "cabecalho.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de upload</title>
    </head>
    <body>
        <div class="container col-md-12">
            <a class="nav-link" href="s1?origem=upload"> <button class="btn btn-info">Voltar</button></a>
            <div class="jumbotron">
                <h2>Formulário de envio de arquivo</h2>
                <form method=POST action="s1">
                    <div class="form-group col-md-4">
                        <input class="form-control-file border" type="file" name="upfile">
                    </div>
                    <button type="submit" class="btn btn-info">Submit</button>
                    <input type="hidden" value="upload" name="origem">
                </form> 
            </div>
        </div>
    </body>
</html>

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
        <a class="nav-link" href="s1?origem=upload"> <button class="btn btn-info">Voltar ao menu</button></a>
        <div class="container col-md-12">
            <div class="jumbotron">
                <h3>Formulário de envio de arquivo</h3>
                <div class="col-md-4" style="padding: 0px;">
                    <form method=POST action='teste' enctype="multipart/form-data">
                        <div class="form-group">
                            <input class="form-control-file border" type="file" name="upfile">
                        </div>
                        <input type="hidden" value="upload_arquivo" name="origem">
                        <button type="submit" class="btn btn-info">Submit</button>
                    </form> 
                </div>
                <div>
                    <% String tmp = (String) session.getAttribute("file");
                       if(tmp != null){
                           session.removeAttribute("file");
                    %>
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-10">
                            <a href="uploads/local.pdf" download>Download do arquivo</a>
                        </div>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </body>
</html>

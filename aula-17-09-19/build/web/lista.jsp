<%-- 
    Document   : lista
    Created on : 05/09/2019, 21:12:39
    Author     : ice
--%>

<%@page import="java.util.List"%>
<%@page import="DAO.Usuario"%>
<%@page import="Controllers.UsuarioController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    UsuarioController controlador = new UsuarioController();
    List<Usuario> usuarios = controlador.leBanco();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="s1?origem=lista">Voltar ao menu</a>
        <br>
        <table>
            <tr>
                <th>Usuario</th>
            </tr>
            <%for (Usuario u : usuarios){%>
                <tr>
                    <td>oi</td>
                    <td><%=u.getNome()%></td>
                </tr>
            <%}%>
            <tr>
                <td></td>
            </tr>
        </table>
    </body>
</html>

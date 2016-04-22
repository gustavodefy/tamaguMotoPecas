<%-- 
    Document   : listaClientes
    Created on : 18/03/2016, 20:05:57
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Lista de Clientes</title>
        
        <link rel="stylesheet" href="./css/lista.css" type="text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">
        
    </head>
    <body>
        <h1 align="center">Listas de Clientes</h1>
        <table border=1 >
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Contato</th>
                    <th>Telefone</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="linCliente" items="${tabCliente}">
                    <tr>
                        <td><a class="btoAlterar" href="./ServletCliente?action=editar&idCliente=<c:out value="${linCliente.idCliente}"/>"><c:out value="${linCliente.idCliente}"/></a></td>
                        <td><c:out value="${linCliente.nome}" /></td>
                        <td><c:out value="${linCliente.contato}" /></td>
                        <td><c:out value="${linCliente.telefone}" /></td>
                        <td><c:out value="${linCliente.email}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a class="btoIncluir" href="./ServletCliente?action=inserir">Incluir</a></p>
    </body>
</html>

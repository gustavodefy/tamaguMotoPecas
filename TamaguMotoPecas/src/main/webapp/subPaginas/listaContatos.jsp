<%-- 
    Document   : listaContatos
    Created on : 16/05/2016, 19:28:44
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Lista de Contatos</title>

        <link rel="stylesheet" href="./css/lista.css" type="text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">

    </head>
    <body>
        <h1 class="titulo" align="center">Lista Mensagens de Contatos</h1>
        <div align="center" class="dv_pedidos">
            <table border=1 width="800px" align="center" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Assunto</th>
                        <th>Telefone</th>
                        <th>Mensagem</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="linContato" items="${tabContato}">
                        <tr>
                            <td><a class="btoAlterar" href="./ServletContato?action=editar&idContato=<c:out value="${linContato.idContato}"/>"><c:out value="${linContato.idContato}"/></a></td>
                            <td><c:out value="${linContato.nome}" /></td>
                            <td><c:out value="${linContato.email}" /></td>
                            <td><c:out value="${linContato.assunto}" /></td>
                            <td><c:out value="${linContato.telefone}" /></td>
                            <td><c:out value="${linContato.mensagem}" /></td>
                            <td><a class="deletar" href="./ServletContato?action=deletar&idContato=<c:out value="${linContato.idContato}"/>"> <img src="./img/x.png" width="25" height="23" alt="x"/></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

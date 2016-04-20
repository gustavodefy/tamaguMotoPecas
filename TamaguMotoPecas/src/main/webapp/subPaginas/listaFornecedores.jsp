<%-- 
    Document   : listaFornecedores
    Created on : 21/03/2016, 19:13:27
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Lista de Fornecedores</title>
        
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
    </head>
    <body>
        <h1 align="center">Lista Fornecedores</h1>
        <table border=1>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>Telefone</th>
                    <th>Contato</th>
                    <th>Email</th>
                    <th colspan=2>Ação</th>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="linFornecedor" items="${tabFornecedor}">
                <tr>
                <td><c:out value="${linFornecedor.idFornecedor}" /></td>
                <td><c:out value="${linFornecedor.nome}" /></td>
                <td><c:out value="${linFornecedor.cpf_cnpj}" /></td>
                <td><c:out value="${linFornecedor.telefone}" /></td>
                <td><c:out value="${linFornecedor.contato}" /></td>
                <td><c:out value="${linFornecedor.email}" /></td>
                <td><a class="alterar" href="./FornecedorServlet?action=editar&idFornecedor=<c:out value="${linFornecedor.idFornecedor}"/>">Alterar</a></td>
                <td><a class="deletar" href="./FornecedorServlet?action=deletar&idFornecedor=<c:out value="${linFornecedor.idFornecedor}"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <p><a class="cadastro" href="./FornecedorServlet?action=inserir">Novo Cadastro</a></p>
</body>
</html>

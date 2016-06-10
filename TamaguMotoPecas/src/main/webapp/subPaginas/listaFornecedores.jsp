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
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">
    </head>
    <body>
        <h1 class="titulo" align="center" >Lista de Fornecedores</h1>
        <div align="center" class="dv_pedidos">
            <table border=1 width="800px" align="center">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>CPF/CNPJ</th>
                        <th>Telefone</th>
                        <th>Contato</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="linFornecedor" items="${tabFornecedor}">
                        <tr>
                            <td><a class="btoAlterar" href="./ServletFornecedor?action=editar&idFornecedor=<c:out value="${linFornecedor.idFornecedor}"/>"><c:out value="${linFornecedor.idFornecedor}"/></a></td>
                            <td><c:out value="${linFornecedor.nome}" /></td>
                            <td><c:out value="${linFornecedor.cpf_cnpj}" /></td>
                            <td><c:out value="${linFornecedor.telefone}" /></td>
                            <td><c:out value="${linFornecedor.contato}" /></td>
                            <td><c:out value="${linFornecedor.email}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <p><a class="btoIncluir" href="./ServletFornecedor?action=inserir">Incluir</a></p>
    </body>
</html>

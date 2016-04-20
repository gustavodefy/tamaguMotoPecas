<%-- 
    Document   : listaProdutos
    Created on : 21/03/2016, 19:06:49
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Lista de Produtos</title>
        
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
    </head>
    <body>
        <h1 align="center">Lista Produtos</h1>
        <table border=1>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descrição</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Preço de Venda</th>
                    <th colspan=2>Ação</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="linProduto" items="${tabProduto}">
                    <tr>
                        <td><c:out value="${linProduto.idProduto}" /></td>
                        <td><c:out value="${linProduto.descricao}" /></td>
                        <td><c:out value="${linProduto.marca}" /></td>
                        <td><c:out value="${linProduto.modelo}" /></td>
                        <td><c:out value="${linProduto.precoVenda}" /></td>
                        <td><a class="alterar" href="./ProdutoServlet?action=editar&idProduto=<c:out value="${linProduto.idProduto}"/>">Alterar</a></td>
                        <td><a class="deletar" href="./ProdutoServlet?action=deletar&idProduto=<c:out value="${linProduto.idProduto}"/>">Deletar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a class="cadastro" href="./ProdutoServlet?action=inserir">Novo Cadastro</a></p>
    </body>
</html>

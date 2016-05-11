<%-- 
    Document   : catalagoProdutos
    Created on : 10/05/2016, 19:46:59
    Author     : ResVUT42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Lista de Produtos</title>

        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>
        <h1 align="center">Lista de Produtos</h1>
        <table border=1>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descrição</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Valor Unitario</th>
                    <th>Quantidade</th>
                    <th>Valor Total</th>
                    <th>Adicionar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="linProduto" items="${tabProduto}">
                    <tr>
                        <td><a class="btoAlterar" href="./ServletCatalogo?action=editar&idProduto=<c:out value="${linProduto.idProduto}"/>"><c:out value="${linProduto.idProduto}"/></a></td>
                        <td><c:out value="${linProduto.descricao}" /></td>
                        <td><c:out value="${linProduto.marca}" /></td>
                        <td><c:out value="${linProduto.modelo}" /></td>
                        <td><c:out value="${linProduto.precoVenda}" /></td>
                        <td><input type ="number" name="nomeCampo" style="width: 5em"/></td>
                        <td><c:out value="${linProduto.estoque}" /></td>
                        <td><img src="./img/carrinho.png" width="25" height="23" alt="carrinho"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

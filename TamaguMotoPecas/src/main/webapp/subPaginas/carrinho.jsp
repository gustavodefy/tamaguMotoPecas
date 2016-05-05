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

        <link rel="stylesheet" href="../css/lista.css" type= "text/css">
        <link rel="stylesheet" href="../css/botoes.css" type= "text/css">        
    </head>
    <body>
        <h1 align="center">Carrinho Compras</h1>
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
                    <th>Remover</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="linProduto" items="${tabProduto}">
                    <tr>
                        <td><a class="btoAlterar" href="./ServletProduto?action=editar&idProduto=<c:out value="${linProduto.idProduto}"/>"><c:out value="${linProduto.idProduto}"/></a></td>
                        <td><c:out value="${linProduto.descricao}" /></td>
                        <td><c:out value="${linProduto.marca}" /></td>
                        <td><c:out value="${linProduto.modelo}" /></td>
                        <td><c:out value="${linProduto.precoVenda}" /></td>
                        <td><input type ="number" name="nomeCampo" style="width: 5em"/></td>
                        <td><c:out value="${linProduto.precoVenda}" /></td>
                        <td><img src="./img/x.png" width="25" height="23" alt="x"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a class="btoIncluir" href="./ServletProduto?action=inserir">Finalizar Venda</a></p>
    </body>
</html>

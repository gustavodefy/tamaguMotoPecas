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
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>
        <h1 class="titulo" align="center">Lista de Produtos</h1>
        <table border=1 width="800px" align="center">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descrição</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Valor Unitario</th>
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a class="btoIncluir" href="./ServletProduto?action=inserir">Incluir</a></p>
    </body>
</html>

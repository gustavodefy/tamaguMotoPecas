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

        <title>Todos os Pedidos Compras</title>

        <script src="./js/catalogo.js"></script>
        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>

        <h1 class="titulo" align="center">Lista de Todos os Pedidos de Compras</h1>

        <div class="mensagem">
            <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
        </div>
        <br>
        <div align="center" class="dv_pedidos">
            <table border=1 align="center" >
                <thead>
                    <tr>
                        <th>Nº Pedido</th>
                        <th>Data Pedido</th>
                        <th>Fornecedor</th>
                        <th>Produto</th>  
                        <th>Quantidade</th>
                        <th>Valor Unit</th>
                        <th>Valor Total</th>
                    </tr>
                </thead>
                <tbody>  
                    <c:forEach var="headerCompra" items="${tabPCompra}">
                        <tr>
                            <td> <a class="btoAlterar" href="./ServletPedidos?action=itens&idPedido=<c:out value="${headerCompra.tabPCompra.idPedido}"/>"><c:out value="${linHeader.tabPCompra.idPedido}"/></a></td>
                            <td> <c:out value="${headerCompra.data}"/>      </td>
                            <td> <c:out value="${headerCompra.fornecedor}"/> </td>
                            <td> <c:out value="${headerCompra.produto}"/>   </td>
                            <td><c:out value="${headerCompra.header.quantidade}"/></td>
                            <td> <c:out value="${headerCompra.header.vlorUnit}"/>   </td>
                            <td><c:out value="${headerCompra.totalPedido}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

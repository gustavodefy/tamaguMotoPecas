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

        <title>Todos os Pedidos</title>

        <script src="./js/catalogo.js"></script>
        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>

        <h1 class="titulo" align="center">Lista de Pedidos</h1>

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
                        <th>Total Pedido</th>
                        <th>Pagamento</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>  
                    <c:forEach var="linHeader" items="${tabHeader}">
                        <tr>
                            <td> <a class="btoAlterar" href="./ServletMeusPedidos?action=itens&idPedido=<c:out value="${linHeader.header.idPedido}"/>"><c:out value="${linHeader.header.idPedido}"/></a></td>
                            <td> <c:out value="${linHeader.header.dtLcto}"/>      </td>
                            <td> <c:out value="${linHeader.header.totalPedido}"/> </td>
                            <td> <c:out value="${linHeader.header.formaPgto}"/>   </td>
                            <td> <c:out value="${linHeader.header.status}"/>      </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

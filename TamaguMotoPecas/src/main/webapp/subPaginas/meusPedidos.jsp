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

        <title>Meus Pedidos</title>

        <script src="./js/catalogo.js"></script>
        <script type="text/javascript" src="./jquery/jquery.min.js"></script> 
        <script type="text/javascript" src="./js/tabela.js"></script>
        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>
        <div id="box-toggle">
            <h1 align="center">Meus Pedidos</h1>

            <br>
            <table border=1 width="855" align="CENTER" >
                <thead>
                    <tr>
                        <th>Pedido</th>
                        <th>Data Pedido</th>
                        <th>Total Pedido</th>
                        <th>Pagamento</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>            
                    <c:forEach var="linHeader" items="${tabHeader}">
                        <tr id="<c:out value="${linHeader.header.idPedido}"/>" name="<c:out value="${linHeader.header.idPedido}"/>">
                            <td> <a class="btoAlterar" href="./ServletMeusPedidos?action=itens&idPedido=<c:out value="${linHeader.header.idPedido}"/>"><c:out value="${linHeader.header.idPedido}"/></a></td>
                            <td> <c:out value="${linHeader.header.dtLcto}"/>      </td>
                            <td> <c:out value="${linHeader.header.totalPedido}"/> </td>
                            <td> <c:out value="${linHeader.header.formaPgto}"/>   </td>
                            <td><c:out value="${linHeader.header.status}"/></td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                <table width="800" align="center" class="tgl">
                                    <thead>
                                        <td class="tgl2"><img src="./img/st1.png" width="799" height="74" alt="st1"/></td>
                                    </thead>
                                </table>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

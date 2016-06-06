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

        <title>Itens pedido <c:out value="${idPedido}" /> </title>
        
        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>

        <br><h1 class="titulo" align="center">Itens pedido <c:out value="${idPedido}" /> </h1>

        <div class="mensagem">
            <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
        </div>

        <form action="./ServletCarrinho?action=finalizarCompra" target="_parent" method="POST">            
            <br><table border=1 align="center" >
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Descrição</th>
                        <th>Valor Unitario</th>
                        <th>Quantidade</th>
                        <th>Valor Total</th>
                    </tr>
                </thead>
                <tbody id="tabelaItens">            
                    <c:forEach var="linItens" items="${tabItens}">
                        <tr id="<c:out value="${linItens.produto.idProduto}"/>" name="<c:out value="${linItens.produto.idProduto}"/>">
                            <td> <a class="btoAlterar" href="./ServletMeusPedidos?action=consultar&idProduto=<c:out value="${linItens.produto.idProduto}"/>"><c:out value="${linItens.produto.idProduto}"/></a></td>
                            <td> <c:out value="${linItens.produto.descricao}"/>  </td>
                            <td> <c:out value="${linItens.vlrUnitario}"/>      </td>
                            <td> <c:out value="${linItens.quantidade}"/>     </td>
                            <td> <c:out value="${linItens.vlrTotal}"/>        </td>
                        </tr>
                    </c:forEach>

                    <tr class="valorTotal">
                        <td colspan="4">Total Pedido</td>
                        <td id="totalPedido"> <c:out value="${totalPedido}"/></td>
                    </tr>
                </tbody>
            </table>
            <br><br>
            <a class="btoIncluir" href="./ServletMeusPedidos?action=voltar">Voltar</a>                    
        </form>    
    </body>
</html>

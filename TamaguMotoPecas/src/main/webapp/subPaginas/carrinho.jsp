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

        <title>Catalogo</title>

        <script src="./js/catalogo.js"></script>
        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">        
    </head>
    <body>

        <br><h1 class="titulo" align="center">Carrinho Compras</h1>

        <div class="mensagem">
            <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
        </div>

        <form action="./ServletCarrinho?action=finalizarCompra" target="_parent" method="POST">            
            <br><table border=1 align="center" >
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
                        <tr id="<c:out value="${linProduto.produto.idProduto}"/>" name="<c:out value="${linProduto.produto.idProduto}"/>">
                            <td> <a class="btoAlterar" href="./ServletCarrinho?action=consulta&idProduto=<c:out value="${linProduto.produto.idProduto}"/>"><c:out value="${linProduto.produto.idProduto}"/></a></td>
                            <td> <c:out value="${linProduto.produto.descricao}"/>  </td>
                            <td> <c:out value="${linProduto.produto.marca}"/>      </td>
                            <td> <c:out value="${linProduto.produto.modelo}"/>     </td>
                            <td> <c:out value="${linProduto.vlrUnitario}"/> </td>
                            <td> <input type="number" name="qtd<c:out value="${linProduto.produto.idProduto}"/>" id="qtd<c:out value="${linProduto.produto.idProduto}"/>"  value="<c:out value="${linProduto.quantidade}"/>" style="width: 5em" min="0" onchange="calcularTotal(<c:out value="${linProduto.produto.idProduto}"/>)"/></td>
                            <td> <c:out value="${linProduto.vlrTotal}"/> </td>
                            <td> <a href="./ServletCarrinho?action=remover&idProduto=<c:out value="${linProduto.produto.idProduto}"/>"><img src="./img/x.png" width="25" height="23" alt="excluir"/></a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="6">Total Pedido</td>
                        <td> <c:out value="${totalPedido}"/></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <br><br><input class="btoIncluir" type="submit" value="Finalizar Compra">
        </form>    
    </body>
</html>

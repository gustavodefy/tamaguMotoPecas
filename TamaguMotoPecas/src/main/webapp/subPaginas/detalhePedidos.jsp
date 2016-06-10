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

        <br><h1 class="titulo" align="center">Itens do Pedido <c:out value="${idPedido}" /> </h1>

        <div class="mensagem">
            <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
        </div>

        <form action="./ServletTodosPedidos?action=gravar" method="POST">           
            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="cidade">Data</label>
                        <input type="text" id="data" name="data" readonly="readonly" style="width: 10em" value="<c:out value="${linHeader.dtLcto}"/>">
                    </div>
                    <div class="campo">
                        <label for="nome">Cliente</label>
                        <input type="text" id="cliente" name="cliente" readonly="readonly" required="required" style="width: 30em" value="<c:out value="${linHeader.cliente.nome}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="statusPedido">Status Pedido</label>
                        <select name="statusPedido" id="statusPedido" required="required" style="width: 10.5em">
                            <option value="ABERTO" ${linHeader.status ==  "ABERTO" ? 'selected' : ''} >ABERTO</option>
                            <option value="CANCELADO" ${linHeader.status ==  "CANCELADO" ? 'selected' : ''} >CANCELADO</option>
                            <option value="ENVIADO" ${linHeader.status ==  "ENVIADO" ? 'selected' : ''} >ENVIADO</option>
                            <option value="CONCLUIDO" ${linHeader.status ==  "CONCLUIDO" ? 'selected' : ''} >CONCLUIDO</option>
                        </select>
                    </div>
                    <div class="campo">
                        <label for="nome">Forma de Pagamento</label>
                        <input type="text" id="formaPgto" readonly="readonly" name="formaPgto" required="required" style="width: 12em" value="<c:out value="${linHeader.formaPgto}" />" />
                    </div>
                </fieldset>
            </fieldset>
            <div align="center">
                <br><table border=1 width="800px" >
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
                                <td> <a class="btoAlterar" href="./ServletTodosPedidos?action=consultar&idProduto=<c:out value="${linItens.produto.idProduto}"/>"><c:out value="${linItens.produto.idProduto}"/></a></td>
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
            </div> 
            <div align="center">
                <a class="btoExcluir" href="./ServletTodosPedidos?action=voltar">Voltar</a>
                <input class="btoAlterar" type="submit" value="Gravar"/>
            </div>
        </form>    
    </body>
</html>

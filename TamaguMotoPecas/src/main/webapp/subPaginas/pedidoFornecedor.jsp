<%-- 
    Document   : pedido de compra
    Created on : 15/03/2016, 14:02:08
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Pedido de Compra</title>

        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type="text/css">
        <script type="text/javascript" src="./jquery/jquery.js"></script>
        <script type="text/javascript" src="./jquery/jquery.maskedinput.js"></script>          
        <script type="text/javascript" src="./jquery/jquery.maskMoney.js"></script>        
        <script type="text/javascript" src="./js/mascaras.js"></script>
        <script type="text/javascript" src="./js/pedidoFornecedor.js"></script>

    </head>
    <body>
        <br><h1 class="titulo" align="center">Pedido de Compra</h1>
        <form action="ServletPedidos?action=fechar" method="post">
            <div class="mensagem">
                <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
            </div>

            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="data">Data*</label>
                        <input type="text" id="data" name="data" readonly="readonly" style="width: 10em">
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="fornecedor">Fornecedor*</label>
                        <select name="fornecedor" id="fornecedor" required="required" style="width: 44em">
                            <c:forEach items="${tabForn}" var="fornecedor">
                                <option value="${fornecedor.idFornecedor}">${fornecedor.idFornecedor} - ${fornecedor.nome}</option >
                            </c:forEach>
                        </select>
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="produto">Produtos</label>
                        <select name="produto" id="produto" required="required" style="width: 25em">
                            <c:forEach items="${tabProd}" var="produto">
                                <c:forEach items="${tabProd}" var="produto">
                                    <option value="${produto.idProduto}">${produto.idProduto} - ${produto.descricao}</option >
                                </c:forEach>
                            </c:forEach>
                        </select>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="campo">
                        <label for="quantidade">Quantidade*</label>
                        <input type="text" id="quantidade" name="quantidade" required="required" style="width: 5em" value="<c:out value="${linPedidos.quantidade}" />" onblur="calculaTotal()"/>
                    </div>
                    <div class="campo">
                        <label for="unitario">Valor Unitario*</label>
                        <input type="text" id="unitario" name="unitario" required="required" style="width: 10em" value="<c:out value="${linPedidos.valorUnit}" />" onblur="calculaTotal()"/>
                    </div>
                    <div class="campo">
                        <label for="total">Valor Total</label>
                        <input type="text" id="total" name="total" readonly="readonly" style="width: 10em" value="<c:out value="${linPedidos.valorUnit}" />" />
                    </div>                    
                </fieldset>


                <p align="right">
                    <label class="obg">Todos os Campos (*) Obrigatórios</label>
                </p>
                <p align="center">                    
                    <a class="btoGravar" href="javascript:void(0);" onclick="adicionarItem()">Adicionar</a>
                </p>

                <br><br><table align="center" border="1">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Descrição</th>
                            <th>Quantidade</th>
                            <th>Valor Unit.</th>
                            <th>Valor Total</th>
                            <th>Remover</th>
                        </tr>
                    </thead>
                    <tbody id="tabelaPedido">
                        
                    </tbody>

                </table>
                <br><br><input class="btoIncluir" type="submit" value="Fechar Pedido" id="fechar" name="fechar"/>
            </fieldset>
        </form>
    </body>
</html>

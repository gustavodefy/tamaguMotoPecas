<%-- 
    Document   : cadastroClientes
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

        <title>Cadastro de Clientes</title>

        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">
        <link rel="stylesheet" href="./css/lista.css" type="text/css">
        <script type="text/javascript" src="./js/mascaras.js"></script>

    </head>
    <body>
        <br><h1 class="titulo" align="center">Pedidos</h1>
        <form action="ServletPedidos" method="post">
            <div class="mensagem">
                <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
            </div>

            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="idCliente">Codigo</label>
                        <input type="text" id="idPedido" name="idPedido" readonly="readonly" style="width: 5em" value="<c:out value="${linPedidos.idPedido}" />" />
                    </div>
                    <div class="campo">
                        <label for="cidade">Data*</label>
                        <input type="text" id="data" name="data" required="required" style="width: 10em" onclick="time()">
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="nome">Fornecedor*</label>
                        <select name="fornecedor" id="fornecedor" required="required" style="width: 44em">
                            <c:forEach items="${tabForn}" var="fornecedor">
                                <option value="${fornecedor.idFornecedor}">${fornecedor.nome}</option >
                            </c:forEach>
                        </select>
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="logradouro">Produtos</label>
                        <select name="produto" id="produto" required="required" style="width: 25em">
                            <c:forEach items="${tabProd}" var="produto">
                                <c:forEach items="${tabProd}" var="produto">
                                    <option value="${produto.idProduto}">${produto.descricao}</option >
                                </c:forEach>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="campo">
                        <label for="numero">Quantidade</label>
                        <input type="text" id="quantidade" name="quantidade" required="required" style="width: 5em" value="<c:out value="${linPedidos.quantidade}" />" />
                    </div>
                    <div class="campo">
                        <label for="complemento">Valor Unitario*</label>
                        <input type="text" id="valorUnit" name="valorUnit" required="required" style="width: 10em" value="<c:out value="${linPedidos.valorUnit}" />" />
                    </div>
                </fieldset>


                <p align="right">
                    <label class="obg">Todos os Campos (*) Obrigatórios</label>
                </p>
                <p align="center">                    
                    <input class="btoGravar"   type="submit" value="Adicionar"   id="gravar" name="gravar" onclick="validarAcao('gravar');" />
                </p>

                <br><br><table align="center" border="1">
                    <thead>
                        <tr>
                            <th>Nº Pedido</th>
                            <th>Cod. Produto</th>
                            <th>Descrição</th>
                            <th>Quantidade</th>
                            <th>Valor Unit.</th>
                            <th>Valor Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <br><br><input class="btoCancelar" type="submit" value="Fechar Pedido" id="cancelar" name="cancelar" onclick="validarAcao('cancelar');"/>
            </fieldset>
        </form>
    </body>
</html>

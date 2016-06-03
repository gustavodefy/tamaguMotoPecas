<%-- 
    Document   : cadastroProdutos
    Created on : 16/03/2016, 21:49:19
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Cadastro de Produtos</title>

        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">
        <script type="text/javascript" src="./jquery/jquery.js"></script>
        <script type="text/javascript" src="./jquery/jquery.maskedinput.js"></script>
        <script type="text/javascript" src="./js/mascaras.js"></script>
    </head>
    <body>
        <h1 align="center">Cadastro de Produtos</h1>
        <form action="<c:out value="${toservlet}"/>" method="post">
            <div class="mensagem">
                <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
            </div>
            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="idProduto">Codigo</label>
                        <input type="text" id="idProduto" name="idProduto" readonly="readonly" style="width: 5em" value="<c:out value="${linProduto.idProduto}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="descricao">Descrição</label>
                        <input type="text" id="descricao" name="descricao" style="width: 22em" value="<c:out value="${linProduto.descricao}" />" />
                    </div>
                    <div class="campo">
                        <label for="marca">Marca</label>
                        <input type="text" id="marca" name="marca" style="width: 10em" value="<c:out value="${linProduto.marca}" />" />
                    </div>
                    <div class="campo">
                        <label for="modelo">Modelo</label>
                        <input type="text" id="modelo" name="modelo" style="width: 15em" value="<c:out value="${linProduto.modelo}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="precoCompra">Preço de Compra</label>
                        <input type="text" id="precoCompra" name="precoCompra" style="width: 10em" value="<c:out value="${linProduto.precoCompra}" />" />
                    </div>
                    <div class="campo">
                        <label for="percentualVenda">Porcentual Venda</label>
                        <input type="text" id="percentualVenda" name="percentualVenda" style="width: 10em" value="<c:out value="${linProduto.percentualVenda}" />" />
                    </div>
                    <div class="campo">
                        <label for="precoVenda">Preço de Venda</label>
                        <input type="text" id="precoVenda" name="precoVenda" style="width: 10em" value="<c:out value="${linProduto.precoVenda}" />" />
                    </div>
                    <div class="campo">
                        <label for="estoque">Estoque</label>
                        <input type="text" id="estoque" name="estoque" style="width: 10em" value="<c:out value="${linProduto.estoque}" />" />
                    </div>
                    <div class="campo">
                        <label for="upload">Proucurar</label>
                        <input type="file" name="upload" id="upload" />
                    </div>
                </fieldset>

                <p align="center">
                    <c:if test="${gravar=='true'}">
                        <input class="btoGravar"   type="submit" value="Gravar"   id="gravar"   name="gravar"   onclick="validarAcao('gravar');" />
                    </c:if>                    
                    <c:if test="${excluir=='true'}">
                        <input class="btoExcluir"  type="submit" value="Excluir"  id="excluir"  name="excluir"  onclick="validarAcao('excluir');" />
                    </c:if>
                    <input class="btoCancelar" type="submit" value="Cancelar" id="cancelar" name="cancelar" onclick="validarAcao('cancelar');"/>
                </p>
            </fieldset>
        </form>
    </body>
</html>

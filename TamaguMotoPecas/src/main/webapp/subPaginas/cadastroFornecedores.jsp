<%-- 
    Document   : cadastroFornecedor
    Created on : 16/03/2016, 21:49:36
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Cadastro de Fornecedor</title>

        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">

        <script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-1.0-utf8.js"></script>
        <script src="./js/cpf_cnpj.js"></script>        
        <script src="./js/estados.js"></script>
        <script src="./js/validarFornecedor.js"></script>

    </head>
    <body>
        <h1 align="center">Cadastro de Fornecedores</h1>
        <form action="ServletFornecedor" method="post">
            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="idFornecedor">Codigo</label>
                        <input type="text" id="idFornecedor" name="idFornecedor" readonly="readonly" style="width: 5em" value="<c:out value="${linFornecedor.idFornecedor}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="nome">Nome</label>
                        <input type="text" id="nome" name="nome" style="width: 22em" value="<c:out value="${linFornecedor.nome}" />" />
                    </div>
                    <div class="campo">
                        <label for="cpf_cnpj">CPF/CNPJ</label>
                        <input type="text" id="cpf_cnpj" name="cpf_cnpj" style="width: 10em" onblur="return validarCpfCnpj();" value="<c:out value="${linFornecedor.cpf_cnpj}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="logradouro">Logradouro</label>
                        <input type="text" id="logradouro" name="logradouro" style="width: 15em" value="<c:out value="${linFornecedor.logradouro}" />" />
                    </div>
                    <div class="campo">
                        <label for="numero">Numero</label>
                        <input type="text" id="numero" name="numero" style="width: 5em" value="<c:out value="${linFornecedor.numero}" />" />
                    </div>
                    <div class="campo">
                        <label for="complemento">Complemento</label>
                        <input type="text" id="complemento" name="complemento" style="width: 10em" value="<c:out value="${linFornecedor.complemento}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="cep">CEP</label>
                        <input type="text" id="cep" name="cep" style="width: 10em" value="<c:out value="${linFornecedor.cep}" />" />
                    </div>
                    <div class="campo">
                        <label for="bairro">Bairro</label>
                        <input type="text" id="bairro" name="bairro" style="width: 21.5em" value="<c:out value="${linFornecedor.bairro}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="cidade">Cidade</label>
                        <input type="text" id="cidade" name="cidade" style="width: 10em" value="<c:out value="${linFornecedor.cidade}" />" />
                    </div>
                    <div class="campo">
                        <label for="estado">Estado</label>
                        <select id="estado" name="estado" value="<c:out value="${linFornecedor.estado}" />"></select>
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="telefone">Telefone</label>
                        <input type="tel" id="telefone" name="telefone" style="width: 10em" value="<c:out value="${linFornecedor.telefone}" />" />
                    </div>
                    <div class="campo">
                        <label for="contato">Contato</label>
                        <input type="text" id="contato" name="contato" style="width: 10em" value="<c:out value="${linFornecedor.contato}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" style="width: 21.5em" value="<c:out value="${linFornecedor.email}" />" />
                    </div>
                </fieldset>
                    
                <p align="center">                    
                    <input class="btoGravar"   type="submit" value="Gravar"   id="gravar"   name="gravar"   onclick="validarAcao('gravar');" />
                    <c:if test="${excluir=='true'}">
                        <input class="btoExcluir"  type="submit" value="Excluir"  id="excluir"  name="excluir"  onclick="validarAcao('excluir');" />
                    </c:if>
                    <input class="btoCancelar" type="submit" value="Cancelar" id="cancelar" name="cancelar" onclick="validarAcao('cancelar');"/>
                </p>
                
                <label>Mensagem:</label>
                <input id="mensagem" name="mensagem" value="${mensagem}" readonly="readonly">

            </fieldset>
        </form>
    </body>
</html>

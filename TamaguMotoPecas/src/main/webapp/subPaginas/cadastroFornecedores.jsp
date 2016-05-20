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
        <script type="text/javascript" src="./jquery/jquery.js"></script>
        <script type="text/javascript" src="./jquery/jquery.maskedinput.js"></script>
        <script type="text/javascript" src="./js/mascaras.js"></script>

    </head>
    <body>
        <h1 align="center">Cadastro de Fornecedores</h1>
        <form action="ServletFornecedor" method="post">
            <div class="mensagem">
                <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
            </div>
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
                        <label for="estado">Estado*</label>
                        <select name="estado" id="estado" required="required">
                            <option value="-" ${linFornecedor.estado ==  "-" ? 'selected' : ''} >-</option> 
                            <option value="AC" ${linFornecedor.estado ==  "AC" ? 'selected' : ''} >Acre</option> 
                            <option value="AL" ${linFornecedor.estado ==  "AL" ? 'selected' : ''} >Alagoas</option> 
                            <option value="AP" ${linFornecedor.estado ==  "AP" ? 'selected' : ''} >Amapá</option>                             
                            <option value="AM" ${linFornecedor.estado ==  "AM" ? 'selected' : ''} >Amazonas</option> 
                            <option value="BA" ${linFornecedor.estado ==  "BA" ? 'selected' : ''} >Bahia</option> 
                            <option value="CE" ${linFornecedor.estado ==  "CE" ? 'selected' : ''} >Ceará</option> 
                            <option value="DF" ${linFornecedor.estado ==  "DF" ? 'selected' : ''} >Distrito Federal</option> 
                            <option value="ES" ${linFornecedor.estado ==  "ES" ? 'selected' : ''} >Espírito Santo</option> 
                            <option value="GO" ${linFornecedor.estado ==  "GO" ? 'selected' : ''} >Goiás</option> 
                            <option value="MA" ${linFornecedor.estado ==  "MA" ? 'selected' : ''} >Maranhão</option> 
                            <option value="MT" ${linFornecedor.estado ==  "MT" ? 'selected' : ''} >Mato Grosso</option> 
                            <option value="MS" ${linFornecedor.estado ==  "MS" ? 'selected' : ''} >Mato Grosso do Sul</option> 
                            <option value="MG" ${linFornecedor.estado ==  "MG" ? 'selected' : ''} >Minas Gerais</option> 
                            <option value="PA" ${linFornecedor.estado ==  "PA" ? 'selected' : ''} >Pará</option> 
                            <option value="PB" ${linFornecedor.estado ==  "PB" ? 'selected' : ''} >Paraíba</option> 
                            <option value="PR" ${linFornecedor.estado ==  "PR" ? 'selected' : ''} >Paraná</option> 
                            <option value="PB" ${linFornecedor.estado ==  "PB" ? 'selected' : ''} >Pernambuco</option> 
                            <option value="PI" ${linFornecedor.estado ==  "PI" ? 'selected' : ''} >Piauí</option> 
                            <option value="RJ" ${linFornecedor.estado ==  "RJ" ? 'selected' : ''} >Rio de Janeiro</option> 
                            <option value="RN" ${linFornecedor.estado ==  "RN" ? 'selected' : ''} >Rio Grande do Norte</option>                             
                            <option value="RS" ${linFornecedor.estado ==  "RS" ? 'selected' : ''} >Rio Grande do Sul</option> 
                            <option value="RO" ${linFornecedor.estado ==  "RO" ? 'selected' : ''} >Rondônia</option> 
                            <option value="RR" ${linFornecedor.estado ==  "RR" ? 'selected' : ''} >Roraima</option> 
                            <option value="SC" ${linFornecedor.estado ==  "SC" ? 'selected' : ''} >Santa Catarina</option> 
                            <option value="SE" ${linFornecedor.estado ==  "SE" ? 'selected' : ''} >Sergipe</option> 
                            <option value="SP" ${linFornecedor.estado ==  "SP" ? 'selected' : ''} >São Paulo</option> 
                            <option value="TO" ${linFornecedor.estado ==  "TO" ? 'selected' : ''} >Tocantins</option> 
                        </select>
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
            </fieldset>
        </form>
    </body>
</html>

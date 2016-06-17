<%-- 
    Document   : cadastroClientes
    Created on : 15/03/2016, 14:02:08
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Cadastro de Clientes</title>

        <link rel="stylesheet" href="./css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="./css/botoes.css" type= "text/css">
        <script type="text/javascript" src="./jquery/jquery.js"></script>
        <script type="text/javascript" src="./jquery/jquery.maskedinput.js"></script>
        <script type="text/javascript" src="./js/mascaras.js"></script>
        <script src="./js/cpf_cnpj.js"></script>
        <script src="./js/validarCliente.js"></script>
        <script src="./js/login.js"></script>

    </head>
    <body>
        <h1 align="center">Cadastro de Clientes</h1>
        <form action="ServletCliente" target="_parent" method="post">
            <div class="mensagem">
                <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
            </div>

            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="idCliente">Codigo</label>
                        <input type="text" id="idCliente" name="idCliente" readonly="readonly" style="width: 5em" value="<c:out value="${linCliente.idCliente}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="nome">Nome*</label>
                        <input type="text" id="nome" name="nome" required="required" style="width: 22em" value="<c:out value="${linCliente.nome}" />" />
                    </div>
                    <div class="campo">
                        <label for="cpf_cnpj">CPF/CNPJ*</label>
                        <input type="text" id="cpf_cnpj" name="cpf_cnpj" required="required" style="width: 10em" onblur="return validarCpfCnpj();" value="<c:out value="${linCliente.cpf_cnpj}" />"/>
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="logradouro">Logradouro*</label>
                        <input type="text" id="logradouro" name="logradouro" required="required" style="width: 15em" value="<c:out value="${linCliente.logradouro}" />" />
                    </div>
                    <div class="campo">
                        <label for="numero">Numero*</label>
                        <input type="text" id="numero" name="numero" required="required" style="width: 5em" value="<c:out value="${linCliente.numero}" />" />
                    </div>
                    <div class="campo">
                        <label for="complemento">Complemento*</label>
                        <input type="text" id="complemento" name="complemento" required="required" style="width: 10em" value="<c:out value="${linCliente.complemento}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="cep">CEP*</label>
                        <input type="text" id="cep" name="cep" style="width: 10em" value="<c:out value="${linCliente.cep}" />" />
                    </div>
                    <div class="campo">
                        <label for="bairro">Bairro*</label>
                        <input type="text" id="bairro" name="bairro" required="required" style="width: 21.5em" value="<c:out value="${linCliente.bairro}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="cidade">Cidade*</label>
                        <input type="text" id="cidade" name="cidade" required="required" style="width: 21.5em" value="<c:out value="${linCliente.cidade}" />">
                    </div>
                    <div class="campo">
                        <label for="estado">Estado*</label>
                        <select name="estado" id="estado" required="required">
                            <option value="-" ${linCliente.estado ==  "-" ? 'selected' : ''} >-</option> 
                            <option value="AC" ${linCliente.estado ==  "AC" ? 'selected' : ''} >Acre</option> 
                            <option value="AL" ${linCliente.estado ==  "AL" ? 'selected' : ''} >Alagoas</option> 
                            <option value="AP" ${linCliente.estado ==  "AP" ? 'selected' : ''} >Amapá</option>                             
                            <option value="AM" ${linCliente.estado ==  "AM" ? 'selected' : ''} >Amazonas</option> 
                            <option value="BA" ${linCliente.estado ==  "BA" ? 'selected' : ''} >Bahia</option> 
                            <option value="CE" ${linCliente.estado ==  "CE" ? 'selected' : ''} >Ceará</option> 
                            <option value="DF" ${linCliente.estado ==  "DF" ? 'selected' : ''} >Distrito Federal</option> 
                            <option value="ES" ${linCliente.estado ==  "ES" ? 'selected' : ''} >Espírito Santo</option> 
                            <option value="GO" ${linCliente.estado ==  "GO" ? 'selected' : ''} >Goiás</option> 
                            <option value="MA" ${linCliente.estado ==  "MA" ? 'selected' : ''} >Maranhão</option> 
                            <option value="MT" ${linCliente.estado ==  "MT" ? 'selected' : ''} >Mato Grosso</option> 
                            <option value="MS" ${linCliente.estado ==  "MS" ? 'selected' : ''} >Mato Grosso do Sul</option> 
                            <option value="MG" ${linCliente.estado ==  "MG" ? 'selected' : ''} >Minas Gerais</option> 
                            <option value="PA" ${linCliente.estado ==  "PA" ? 'selected' : ''} >Pará</option> 
                            <option value="PB" ${linCliente.estado ==  "PB" ? 'selected' : ''} >Paraíba</option> 
                            <option value="PR" ${linCliente.estado ==  "PR" ? 'selected' : ''} >Paraná</option> 
                            <option value="PB" ${linCliente.estado ==  "PB" ? 'selected' : ''} >Pernambuco</option> 
                            <option value="PI" ${linCliente.estado ==  "PI" ? 'selected' : ''} >Piauí</option> 
                            <option value="RJ" ${linCliente.estado ==  "RJ" ? 'selected' : ''} >Rio de Janeiro</option> 
                            <option value="RN" ${linCliente.estado ==  "RN" ? 'selected' : ''} >Rio Grande do Norte</option>                             
                            <option value="RS" ${linCliente.estado ==  "RS" ? 'selected' : ''} >Rio Grande do Sul</option> 
                            <option value="RO" ${linCliente.estado ==  "RO" ? 'selected' : ''} >Rondônia</option> 
                            <option value="RR" ${linCliente.estado ==  "RR" ? 'selected' : ''} >Roraima</option> 
                            <option value="SC" ${linCliente.estado ==  "SC" ? 'selected' : ''} >Santa Catarina</option> 
                            <option value="SE" ${linCliente.estado ==  "SE" ? 'selected' : ''} >Sergipe</option> 
                            <option value="SP" ${linCliente.estado ==  "SP" ? 'selected' : ''} >São Paulo</option> 
                            <option value="TO" ${linCliente.estado ==  "TO" ? 'selected' : ''} >Tocantins</option> 
                        </select>
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="telefone">Telefone*</label>
                        <input type="tel" id="telefone" required="required" name="telefone" style="width: 10em" value="<c:out value="${linCliente.telefone}" />" />
                    </div>
                    <div class="campo">
                        <label for="contato">Contato*</label>
                        <input type="text" id="contato" required="required" name="contato" style="width: 10em" value="<c:out value="${linCliente.contato}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="email">Email*</label>
                        <input type="email" id="email" placeholder="contato@mail.com" required="required" name="email" style="width: 21.5em" value="<c:out value="${linCliente.email}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="limitecredito">Limite Credito*</label>
                        <input type="text" id="limitecredito" required="required" name="limitecredito" style="width: 10em" value="<c:out value="${linCliente.limiteCredito}" />" />
                    </div>
                </fieldset>
                <fieldset class="grupo">                   
                    <div class="campo">
                        <label for="senha">Senha*</label>
                        <input type="password" id="senha" name="senha" required="required" style="width: 10em" value="<c:out value="${linCliente.senha}" />" />
                    </div>

                    <div class="campo">
                        <label for="confirmasenha">Confirma Senha*</label>
                        <input type="password" id="confirmasenha" required="required" onblur="confirma_senha()" name="confirmasenha" style="width: 10em" value="<c:out value="${confirmasenha}" />"/>
                    </div>
                    <div class="campo">
                        <br><label for="confirmasenha"></label>
                        <img id="erroSenha" src="./img/ajuda.png" width="27" height="27" alt="ajuda"/>
                    </div>

                </fieldset>

                <fieldset class="grupo">                   
                    <div id="perfilCliente" class="campo">
                        <label for="perfil">Tipo de Acesso*</label>
                        <select name="perfil" required="required">
                            <option value="C" ${linCliente.perfil ==  "C" ? 'selected' : ''}>Cliente</option> 
                            <option value="F" ${linCliente.perfil ==  "F" ? 'selected' : ''}>Funcionario</option>
                        </select>
                    </div>
                </fieldset>
                <p align="right">
                    <label class="obg">Todos os Campos (*) Obrigatórios</label>
                </p>
                <p align="center">                    
                    <input class="btoGravar"   type="submit" value="Gravar"   id="gravar" name="gravar" onclick="validarAcao('gravar');" />
                    <c:if test="${excluir=='true'}">
                        <a target="_parent" href="index.jsp"><input class="btoCancelar" type="submit" value="Excluir" id="excluir" name="excluir"/></a>
                            <%--<input class="btoExcluir"  type="submit" value="Excluir"  id="excluir"  name="excluir"  onclick="validarAcao('excluir');" /> --%>
                        </c:if>
                    <a target="InlineFrame1" href="ServletCliente?action=listar"><input class="btoCancelar" type="button" value="Cancelar" id="cancelar" name="cancelar"/></a>
                </p>
            </fieldset>
        </form>
    </body>
</html>

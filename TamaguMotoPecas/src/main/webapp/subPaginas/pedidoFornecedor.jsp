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

        <link rel="stylesheet" href="../css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="../css/botoes.css" type= "text/css">
        <link rel="stylesheet" href="../css/lista.css" type="text/css">

    </head>
    <body>
        <br><h1 class="titulo" align="center">Pedidos</h1>
        <form action="ServletCliente" method="post">
            <div class="mensagem">
                <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
            </div>

            <fieldset class="grupo">
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="idCliente">Codigo</label>
                        <input type="text" id="idCliente" name="idCliente" readonly="readonly" style="width: 5em" value="<c:out value="${linCliente.idCliente}" />" />
                    </div>
                    <div class="campo">
                        <label for="cidade">Data*</label>
                        <input type="text" id="cidade" name="cidade" required="required" style="width: 10em" value="<c:out value="${linCliente.cidade}" />">
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="nome">Fornecedor*</label>
                        <select name="estado" id="estado" required="required" style="width: 35em">
                            <c:forEach items="${fornecedor}" var="fornecedor">
                                <option value="<c:out value="${fornecedor.codigo}"/>" 
                                        ${fornecedor.codigo ==  pi.pedido.cliente.codigo ? 'selected' : ''}>
                                    <c:out value="${fornecedor.nome}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>
                </fieldset>
                <fieldset class="grupo">
                    <div class="campo">
                        <label for="logradouro">Produtos</label>
                        <select name="estado" id="estado" required="required" style="width: 25em">
                            <option value="-" ${linCliente.estado ==  "-" ? 'selected' : ''} >-</option> 
                            <option value="AC" ${linCliente.estado ==  "AC" ? 'selected' : ''} >Acre</option> 
                            <option value="AL" ${linCliente.estado ==  "AL" ? 'selected' : ''} >Alagoas</option> 
                            <option value="AP" ${linCliente.estado ==  "AP" ? 'selected' : ''} >Amapá</option>                             
                            <option value="AM" ${linCliente.estado ==  "AM" ? 'selected' : ''} >Amazonas</option> 
                        </select>
                    </div>
                    <div class="campo">
                        <label for="numero">Quantidade</label>
                        <input type="text" id="numero" name="numero" required="required" style="width: 5em" value="<c:out value="${linCliente.numero}" />" />
                    </div>
                    <div class="campo">
                        <label for="complemento">Valor Unitario*</label>
                        <input type="text" id="complemento" name="complemento" required="required" style="width: 10em" value="<c:out value="${linCliente.complemento}" />" />
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

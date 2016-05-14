<%-- 
    Document   : contato
    Created on : 16/03/2016, 21:19:43
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="../css/botoes.css" type= "text/css">
    </head>
    <body>
        <form action="./ServletContato?action=gravar" method="post">
            <fieldset class="grupo">
                
                <div class="mensagem">
                    <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
                </div>
                
                <div class="campo">


                    <br><div class="campo"><p><label for="idCliente">Nome</label>
                            <input type=text name="nome" required="required" size="45"></p></div>

                    <div class="campo"><p><label for="email">Email</label>
                            <input type=text placeholder="contato@mail.com" required="required" name="email" size="45"></p>
                    </div>

                    <div class="campo"><p><label for="text">Assunto</label>
                            <input type=text name="assunto" size="45"></p></div>

                    <div class="campo"><p><label for="text">Telefone</label>
                            <input type=text placeholder="(xx)xxxx-xxxx" name="telefone" size="45"></p></div>

                    <div class="campo"><p><label for="text">Mensagem</label>
                            <textarea name="observacao" placeholder="Deixe sua opnião..." required="required" rows="10" cols="60"></textarea></p></div>

                </div>
                <input class="btoGravar" type="submit" value="Enviar"> 
                <input class="btoCancelar" type="reset" value="Limpar">
            </fieldset>
        </form>
    </body>
</html>

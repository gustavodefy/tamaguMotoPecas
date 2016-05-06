<%-- 
    Document   : contato
    Created on : 16/03/2016, 21:19:43
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="formulario" action="http://scripts.redehost.com.br/formmail.aspx" method="post">
            <input type=hidden name="destino" value="thayro.ads@gmail.com">
            <input type=hidden name="enviado" value="http://www.tamagu.com.br/enviado.htm">
            <br>Nome:</br>
            <input type=text name="nome" required="required" size="45">
            <br>Email:</br>
            <input type=text placeholder="contato@mail.com" required="required" name="email" size="45">
            <br>Assunto:</br>
            <input type=text name="assunto" size="45">
            <br>Telefone:</br>
            <input type=text placeholder="(xx)xxxx-xxxx" name="assunto" size="45">
            <br>Mensagem:</br>
            <textarea name="Mensagem" placeholder="Deixe sua opnião" required="required" rows="10" cols="60"></textarea>
            <p><input type="submit" value="Enviar"> <input type="reset" value="Limpar"></p>
        </form>
    </body>
</html>

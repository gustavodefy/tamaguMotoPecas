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
        <form name="formulario" action="#" method="post">
            <input type=hidden name="destino" value="EmailQueVaiReceberAsMensagens">
            <input type=hidden name="enviado" value="http://www.seudominio.xxx.yy/enviado.htm">
            <br>Nome:</br>
            <input type=text name="nome" size="45">
            <br>Email:</br>
            <input type=text name="email" size="45">
            <br>Assunto:</br>
            <input type=text name="assunto" size="45">
            <br>Mensagem:</br>
            <textarea name="Mensagem" rows="10" cols="60"></textarea>
            <p><input type="submit" value="Enviar"> <input type="reset" value="Limpar"></p>
        </form>
    </body>
</html>

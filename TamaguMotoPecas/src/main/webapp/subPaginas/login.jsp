<%-- 
    Document   : login
    Created on : 18/04/2016, 20:48:36
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="../css/login.css" type= "text/css">
        <script src="../js/login.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="login-page" id="white_content">
            <div class="form">
                <form class="login-form" name="formuLogin" action="../ServletLogin?action=acessar" method="post">
                    <input  type="text" id="email" name="email" style="width: 20em"/>
                    <input  type="password" id="senha" name="senha" style="width: 20em"/>
                    <button type="submit" class="logarEntrar" value="Ok" onclick="window.open('../ServletLogin?action=acessar')">login</button>
                    <p class="message">Não tenho Cadastro? <a href="../ServletCliente?action=inserir">Criar Conta</a></p>
                </form>
            </div>
        </div>
    </body>
</html>

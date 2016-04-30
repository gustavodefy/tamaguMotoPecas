<%-- 
    Document   : principal
    Created on : 14/03/2016, 20:48:04
    Author     : Thayro.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TAMAGU Moto Peças</title>
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" />
        <link rel = "stylesheet" href="css/principal.css" type= "text/css" >
        <script src="./js/login.js"></script>
    </head>
    <body>
        <form name=login>
            <table class="menuTopo">
                <tr>

                    <td>
                        <div class="topoLogar" align="left">
                            <li> <img src="./img/carrinho.png" width="25" height="23" alt="carrinho"/>
                                <a class="textoLogar" target="InlineFrame1">Carrinho: </a>
                                <a class="textoLogar" target="InlineFrame1">0 </a>
                                <a class="textoLogar" target="InlineFrame1">Item</a>
                            </li>
                        </div>
                    </td>
                    <td>
                        <div class="topoLogar" align="right">
                            <li><a class="textoLogar" target="InlineFrame1">Usuário  </a>
                                <img id="img" src="./img/user.png" width="25" height="23" alt="user"/>
                                <input  type="text" id="username" name="username" style="width: 10em" value="<c:out value="${linCliente.email}" />"/>

                                <a class="textoLogar" target="InlineFrame1">Senha</a>
                                <img id="img" src="./img/senha.png" width="25" height="23" alt="senha"/>
                                <input  type="password" id="password" name="password" style="width: 10em" value="<c:out value="${linCliente.senha}" />"/>

                                <a class="logarEntrar" target="InlineFrame1" onclick="Login()">Entrar</a>
                            </li>
                        </div>
                    </td>
                </tr>
        </form>
    </table>
    <table width="auto" border="0">
        <tr>
            <td><div align="center" class="logo">
                    <img src="img/logoNova.png" width="757" height="154" alt="logoNova"/>

                </div>
                <div align="center" class="menu">
                    <li><a href="subPaginas/home.jsp" target="InlineFrame1">Home</a></li>
                    <li><a href="subPaginas/sobre.jsp" target="InlineFrame1">Sobre</a></li>
                    <li><a href="#">Catalogo</a>
                        <ul>
                            <li><a href="./ServletCliente?action=listar" target="InlineFrame1">Produtos</a></li>
                        </ul>
                    </li>
                    <li><a href="subPaginas/contato.jsp" target="InlineFrame1">Contato</a></li>
                </div></td>
        </tr>
    </table>
    <div  class="paginaPrincipal">
        <table width="800">
            <nav>
                <tr class="menu">
                    <td><iframe class="iframePrincipal" name= "InlineFrame1" id= "InlineFrame1" width="900" height="700" src="subPaginas/home.jsp" frameborder="0"></iframe></td>
                </tr>
            </nav>
        </table>   
    </div>
    <footer class="rodape"><p align="center"><strong>Posted by: TAMAGU WEBSITES</strong></p>   
        <p align="center"><strong>Contato Informação: contato@tamagu.com.br </strong></p></footer>
</body>
</html>

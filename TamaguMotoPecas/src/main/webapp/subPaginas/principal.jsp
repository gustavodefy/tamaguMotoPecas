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
        <form name="formuLogin" action="./ServletLogin?action=acessar" method="post">
            <table class="menuTopo">
                <tr>

                    <td>
                        <div class="topoLogar" align="left">
                            <c:if test="${cliente=='true'}">
                                <li> <img src="./img/carrinho.png" width="25" height="23" alt="carrinho"/>
                                    <a class="textoLogar" target="InlineFrame1">Carrinho: </a>
                                    <a class="textoQtd" target="InlineFrame1" href="./subPaginas/carrinho.jsp"> 0 </a>
                                    <a class="textoLogar" target="InlineFrame1">Item</a>
                                </li>
                            </c:if>
                        </div>
                    </td>
                    <td>
                        <div class="mensagem">
                            <input type="text" readonly="readonly" id="mensagem" name="mensagem" style="width: 20em"value="<c:out value="${mensagem}" />" />
                        </div>                        
                    </td>
                    <td>
                        <div class="topoLogar" align="right">
                            <li>
                                <c:if test="${logado=='false'}">
                                    <a class="textoLogar">Usuário</a>
                                    <img id="img" src="./img/user.png" width="25" height="23" alt="user"/>
                                    <input class="campoEmail"  type="email" id="email" placeholder="contato@mail.com" name="email" style="width: 15em"/>

                                    <a class="textoLogar">Senha</a>
                                    <img id="img" src="./img/senha.png" width="25" height="23" alt="senha"/>
                                    <input class="campoEmail" type="password" id="senha" name="senha" style="width: 10em"/>

                                    <input type="submit" class="logarEntrar" value="Ok" onclick="return validar_Login()"/>
                                    <a class="criarConta" href="./ServletCliente?action=inserir" target="InlineFrame1" >Não tenho cadastro</a>
                                </c:if>

                                <c:if test="${logado=='true'}">
                                    <div class="logado" align="right">
                                        <a class="idLogado" href="./ServletCliente?action=editar&idCliente=<c:out value="${sessaoCliente.idCliente}"/>" target="InlineFrame1"> Bem vindo <c:out value="${sessaoCliente.nome}"/> </a>
                                        <a class="idSair" href="./ServletLogin?action=logout">Sair</a>
                                    </div>
                                </c:if>
                            </li>
                        </div>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="action" value="login" />
        </form>
        <table width="auto" border="0">
            <tr>
                <td><div align="center" class="logo">
                        <a href="./index.jsp"><img src="img/logoNova.png" width="757" height="154" alt="logoNova"/></a>
                    </div>
                    <div align="center" class="menu">
                        <li><a href="subPaginas/home.jsp" target="InlineFrame1">Home</a></li>
                        <li><a href="subPaginas/sobre.jsp" target="InlineFrame1">Sobre</a></li>
                            <c:if test="${funcionario=='true'}">
                            <li><a href="#">Cadastro</a>
                                <ul>
                                    <li><a href="./ServletCliente?action=listar" target="InlineFrame1">Clientes</a></li>
                                    <li><a href="./ServletFornecedor?action=listar" target="InlineFrame1">Fornecedores</a></li>
                                    <li><a href="./ServletProduto?action=listar" target="InlineFrame1">Produtos</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${funcionario=='false'}">
                            <li><a href="#">Catalogo</a>
                                <ul>
                                    <li><a href="./ServletCatalogo?action=listar" target="InlineFrame1">Produtos</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li><a href="./ServletContato?action=inicio" target="InlineFrame1">Contato</a></li>
                    </div></td>
            </tr>
        </table>
        <div  class="paginaPrincipal">
            <table width="800">
                <nav>
                    <tr class="menu">
                        <td><iframe class="iframePrincipal" name= "InlineFrame1" id= "InlineFrame1" width="900" height="750" src="subPaginas/home.jsp" frameborder="0"></iframe></td>
                    </tr>
                </nav>
            </table>   
        </div>  
        <footer class="rodape"><p align="center"><strong>Posted by: TAMAGU WEBSITES</strong></p>   
            <p align="center"><strong>Contato Informação: contato@tamagu.com.br </strong></p>
                        <p align="center"><strong>© 2016 Helizabeth Hato - Dens. Sistema Web e Banco Dados All Rights Reserved  </strong></p></footer>
        <br><div align="center"><img src="./img/rodape.png" width="901" height="66" alt="rodape"/></div>
    </body>
</html>

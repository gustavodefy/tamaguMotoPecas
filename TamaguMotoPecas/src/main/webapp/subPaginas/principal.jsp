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
        <link rel = "stylesheet" href="./css/principal.css" type= "text/css" >
        <script src="./js/login.js"></script>
    </head>
    <body>
        <form name="formuLogin" action="./ServletLogin?action=acessar" method="post" target="_parent">
            <table class="menuTopo">
                <tr>

                    <td>
                        <div class="topoLogar" align="left">
                            <c:if test="${cliente=='true'}">
                                <li><img src="./img/carrinho.png" class="carrinho" width="25" height="23" alt="carrinho"/>
                                    <a class="textoLogar" target="InlineFrame1">Carrinho: </a>
                                    <c:if test="${qtdItCar <= 0}">
                                    <a class="textoQtd"  href="./ServletCarrinho?action=listar"> <c:out value="${qtdItCar}"/> </a>
                                    </c:if>
                                    <c:if test="${qtdItCar > 0}">
                                    <a class="textoQtd"  href="./ServletCarrinho?action=listar" target="InlineFrame1"> <c:out value="${qtdItCar}"/> </a>
                                    </c:if>
                                    <a class="textoLogar" target="InlineFrame1">Item</a>
                                </li>
                            </c:if>
                        </div>
                    </td>
                    <td>
                        <div class="mensagem">
                            <input type="text" readonly="readonly" id="mensagem" name="mensagem" style="width: 20em" value="<c:out value="${mensagem}" />" />
                        </div>                        
                    </td>
                    <td>
                        <div class="topoLogar" align="right">
                            <li>
                                <c:if test="${logado=='false'}">
                                    <a class="textoLogar">Usuário</a>

                                    <img id="img" src="./img/user.png" width="25" height="23" alt="user"/>
                                    <input class="campoEmail"  type="text" id="email" placeholder="contato@mail.com" name="email" style="width: 15em"/>

                                    <a class="textoLogar">Senha</a>
                                    <img class="carrinho" id="img" src="./img/senha.png" width="25" height="23" alt="senha"/>
                                    <input class="campoEmail" type="password" id="senha" name="senha" style="width: 10em"/>

                                    <input type="submit" class="logarEntrar" value="Ok" onclick="return validar_Login()"/>
                                    <a class="criarConta" href="./ServletCliente?action=inserirNovo" target="InlineFrame1" >Não tenho cadastro</a>
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
                        <c:if test="${funcionario=='false'}">
                            <li><a href="subPaginas/home.jsp" target="InlineFrame1">Home</a></li>
                            <li><a href="subPaginas/sobre.jsp" target="InlineFrame1">Sobre</a></li>
                            </c:if>
                            <c:if test="${funcionario=='true'}">
                            <li><a href="#">Cadastro</a>
                                <ul>
                                    <li><a href="./ServletCliente?action=inserir" target="InlineFrame1">Clientes</a></li>
                                    <li><a href="./ServletFornecedor?action=inserir" target="InlineFrame1">Fornecedores</a></li>
                                    <li><a href="./ServletProduto?action=inserir" target="InlineFrame1">Produtos</a></li>
                                    <li><a href="./ServletPedidos?action=inicio" target="InlineFrame1">Pedido Compra</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${funcionario=='true'}">
                            <li><a href="subPaginas/home.jsp" target="InlineFrame1">Consultar</a>
                                <ul>
                                    <li><a href="./ServletCliente?action=listar" target="InlineFrame1">Clientes</a></li>
                                    <li><a href="./ServletFornecedor?action=listar" target="InlineFrame1">Fornecedor</a></li>                                    
                                    <li><a href="./ServletProduto?action=listar" target="InlineFrame1">Produtos</a></li>
                                    <li><a href="./ServletTodosPedidos?action=listar" target="InlineFrame1">Pedido Venda</a></li>                                    
                                </ul>
                            </li>
                            <li><a href="subPaginas/sobre.jsp" target="InlineFrame1">Relatorio</a>
                                <ul>
                                    <li><a href="./ServletPedidos?action=listar" target="InlineFrame1">Pedido Compra</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${funcionario=='false'}">
                            <li><a href="#">Catalogo</a>
                                <ul>
                                    <li><a href="./ServletCatalogo?action=listar" target="InlineFrame1">Produtos</a></li>
                                        <c:if test="${logado=='true'}">
                                        <li><a href="./ServletMeusPedidos?action=listar" target="InlineFrame1">Meus Pedidos</a></li>
                                        </c:if>
                                        <c:if test="${logado=='false'}">
                                        <li><a href="subPaginas/home.jsp" target="InlineFrame1">Meus Pedidos</a></li>
                                        </c:if>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${funcionario=='true'}">
                            <li><a><img class="msg" src="./img/msg.png" width="30" height="20" alt="msg"/></a><a href="#"> Mensagens</a>
                                <ul>
                                    <li><a href="./ServletContato?action=listar" target="InlineFrame1">Mensagens</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${funcionario=='false'}">
                            <li><a href="./ServletContato?action=inicio" target="InlineFrame1">Contato</a></li>
                            </c:if>
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
            <p align="center"><strong>© 2016 Elisabete Hato - Dens. Sistema Web e Banco Dados All Rights Reserved  </strong></p></footer>
        <br><div align="center"><img src="./img/rodape.png" width="901" height="66" alt="rodape"/></div>
    </body>
</html>

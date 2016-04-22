<%-- 
    Document   : principal
    Created on : 14/03/2016, 20:48:04
    Author     : Thayro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TAMAGU Moto Peças</title>
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" />
        <link rel = "stylesheet" href="css/principal.css" type= "text/css" >
    </head>
    <body>
        <div align="center" class="logo">
            <img src="img/logoNova.png" width="757" height="154" alt="logoNova"/>

        </div>
        <div align="center" class="menu">
            <li><a href="subPaginas/home.jsp" target="InlineFrame1">Home</a></li>
            <li><a href="subPaginas/sobre.jsp" target="InlineFrame1">Sobre</a></li>
            <li><a href="#">Cadastro</a>
                <ul>
                    <li><a href="./ServletCliente?action=listar" target="InlineFrame1">Clientes</a></li>
                    <li><a href="./ServletFornecedor?action=listar" target="InlineFrame1">Fornecedores</a></li>
                    <li><a href="./ServletProduto?action=listar" target="InlineFrame1">Produtos</a></li>
                </ul>
            </li>
            <li><a href="subPaginas/contato.jsp" target="InlineFrame1">Contato</a></li>
        </div>
        <div  class="paginaPrincipal">
            <table width="1024">
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

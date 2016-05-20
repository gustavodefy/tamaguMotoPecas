<%-- 
    Document   : catalagoProdutos
    Created on : 10/05/2016, 19:46:59
    Author     : ResVUT42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Catalogo</title>

        <script src="./js/catalogo.js"></script>
        <link rel="stylesheet" href="../css/cadastro.css" type= "text/css">
        <link rel="stylesheet" href="../css/lista.css" type= "text/css">
        <link rel="stylesheet" href="../css/botoes.css" type= "text/css">        
    </head>
    <body>

        <br><h1 class="titulo" align="center">Carrinho Compras</h1>

        <div class="mensagem">
            <input type="text" id="mensagem" name="mensagem" readonly="readonly" style="width: 20em" value="<c:out value="${mensagem}" />" />
        </div>

        <form action="./ServletCatalogo?action=addCarrinho" target="_parent" method="POST">            
            <br><table border=1 align="center" >
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Descrição</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Valor Unitario</th>
                        <th>Quantidade</th>
                        <th>Valor Total</th>
                    </tr>
                </thead>
                <tbody>            
                    <c:forEach var="linCliente" items="${tabCliente}">
                        <tr>
                            <td><input class="preTabela" type="text" value="Teste"></td>
                            <td><input class="preTabela" type="text" value="Teste"></td>
                            <td><input class="preTabela" type="text" value="Teste"></td>
                            <td><input class="preTabela" type="text" value="Teste"></td>
                            <td><input class="preTabela" type="text" value="Teste"></td>
                            <td><input class="preTabela" type="number"></td>
                            <td><input class="preTabela" type="text" value="Teste"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br><input class="btoIncluir" type="submit" value="Finalizar Compra">
        </form>    
    </body>
</html>

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calcularTotal(id) {

//    var tabela = document.getElementById("tabelaItens");
//    var linhas = tabela.getElementsByTagNameNS("tr");
    

    var linha = document.getElementById(id);
    var coluna = linha.getElementsByTagName("td");

    var unit = coluna[4].firstChild.nodeValue;
    var qtd = coluna[5].firstElementChild.value;
    var aux = coluna[6].firstChild.nodeValue;
    var total = unit * qtd;
    coluna[6].innerHTML = total;
    
    
    
    var totalPedido = document.getElementById("totalPedido");
    var totGeral = totalPedido.firstChild.nodeValue - aux + total;
    totalPedido.innerHTML = totGeral;

}

function validarCarrinho(id, logado) {

    if (logado !== true) {

        alert("Cliente ainda não logado!");

    } else {
        
        var linha = document.getElementById(id);
        var coluna = linha.getElementsByTagName("td");
        var qtd = coluna[5].firstElementChild.value;
        
        if(qtd === ""){
            alert("Quantidade não informada!");                
        }

    }

}

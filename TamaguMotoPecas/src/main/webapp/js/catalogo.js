/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calcularTotal(id) {

    var linha = document.getElementById(id);
    var coluna = linha.getElementsByTagName("td");

    var unit = coluna[4].firstChild.nodeValue;
    var qtd = coluna[5].firstElementChild.value;
    var total = unit * qtd;

    coluna[6].innerHTML = total;

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
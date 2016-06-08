/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calculaTotal() {
    var qtde = document.getElementById("quantidade").value;
    var vlrUnit = document.getElementById("unitario").value;

    if (qtde !== "" && vlrUnit !== "") {

        var qtdReal = qtde;
        qtdReal = qtdReal.replace(".", "");
        qtdReal = qtdReal.replace(",", ".");
        qtdReal = parseInt(qtdReal);

        var vlrReal = vlrUnit;
        vlrReal = vlrReal.replace(".", "");
        vlrReal = vlrReal.replace(",", ".");
        vlrReal = parseFloat(vlrReal);

        var vlrTotal = qtdReal * vlrReal;
        vlrTotal = parseFloat(vlrTotal.toFixed(2));

        document.getElementById("total").value = vlrTotal;
    }
}

function adicionarItem() {

//Pega os dados a serem adicionados
    var produto = document.getElementById("produto");
    var idProduto = produto.value;
    var descProduto = produto.options[produto.selectedIndex].text;
    var qtde = document.getElementById("quantidade").value;
    var vlrUnit = document.getElementById("unitario").value;
    var vlrTotal = document.getElementById("total").value;


    var linha = document.getElementById(idProduto);
    if (linha == null) {

//Cria linha na tabela
        var table = document.getElementById("tabelaPedido");
        var row = table.insertRow(-1);
        row.id = idProduto;

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell();

//Adiciona a imagem de remover
        var img = document.createElement("IMG");
        img.src = "./img/x.png";
        img.width = "25";
        img.height = "23";
        img.onclick = function () {
            removerItem(idProduto);
        };

//insere as colunas na linha
        cell1.innerHTML = idProduto;
        cell2.innerHTML = descProduto;
        cell3.innerHTML = qtde;
        cell4.innerHTML = vlrUnit;
        cell5.innerHTML = vlrTotal;
        cell6.appendChild(img);
        
    } else {
        alert("Produto já na lista!");
    }
}

function removerItem(rowid) {
    var row = document.getElementById(rowid);
    row.parentNode.removeChild(row);
}


window.onload = function () {

    var dt = new Date();
    var month = (dt.getMonth() + 1);
    var day = dt.getDate();
    var year = dt.getFullYear();

    month = zeroaesquerda(month, 2);
    day = zeroaesquerda(day, 2);

    var data = window.document.getElementById('data').value = (day + '/' + month + '/' + year);

};

function zeroaesquerda(valor, tamanho) {

    var valorStr = valor.toString();
    var adicionar = tamanho - valorStr.length;

    for (var i = 0; i < adicionar; i++) {
        valorStr = '0' + valorStr;
    }

    return valorStr;

}


jQuery(function ($) {
    $("#quantidade").maskMoney({symbol: 'R$ ', precision: 0, thousands: '.', decimal: ',', symbolStay: true});
    $("#unitario").maskMoney({symbol: 'R$ ', thousands: '.', decimal: ',', symbolStay: true});
    $("#total").maskMoney({symbol: 'R$ ', thousands: '.', decimal: ',', symbolStay: true});

});
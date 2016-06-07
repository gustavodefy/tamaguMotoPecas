/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function adicionarPedido() {
    var produto = document.getElementById("produto");
    var idProduto = produto.value;
    var descProduto = produto.options[produto.selectedIndex].text;
    var qtde = document.getElementById("quantidade").value;
    var vlorUnit = document.getElementById("valorUnit").value;
    var vlotTotalItens = qtde * vlorUnit;

    var table = document.getElementById("tabelaPedido");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);


    var img = document.createElement("IMG");  
    img.src = "../img/x.png";  
    img.width="25"; 
    img.height="23"; 
    img.alt="excluir";    


    cell1.innerHTML = idProduto;
    cell2.innerHTML = descProduto;
    cell3.innerHTML = qtde;
    cell4.innerHTML = vlorUnit;
    cell5.innerHTML = vlotTotalItens;    
    

}

window.onload = function (){
    
    var dt = new Date();
    var month = (dt.getMonth() + 1);
    var day = dt.getDate();
    var year = dt.getFullYear();
    
    month = zeroaesquerda(month,2);
    day   = zeroaesquerda(day,2);

    
    var data = window.document.getElementById('data').value = (day + '/' + month + '/' + year);
    
};

function zeroaesquerda(valor,tamanho) {
    
  var valorStr = valor.toString();
  
  var adicionar = tamanho - valorStr.length;
  
  
  for (var i = 0; i < adicionar; i++){      
      valorStr = '0' + valorStr;
  } 
  
  return valorStr;
  
}
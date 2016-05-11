/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calcularTotal(){
    
    	var linha = document.getElementById("linProduto");
	var colunas = linha.getElementsByTagName('td');
	
	for (i=0;i<colunas.length;i++)
	{
	alert("conteudo da coluna"+i+" ->"+colunas[i].firstChild.nodeValue);
	}
    
}
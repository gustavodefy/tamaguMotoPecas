/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function mascara(t, mask) {
    var i = t.value.length;
    var saida = mask.substring(1, 0);
    var texto = mask.substring(i)
    if (texto.substring(0, 1) != saida) {
        t.value += texto.substring(0, 1);
    }
}

jQuery(function ($) {
    $("#modelo").mask("9999/9999");
    $("#cep").mask("99.999-999");
    $("#telefone").mask("(99)9999-9999");
});
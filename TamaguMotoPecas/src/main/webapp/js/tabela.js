/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery.fn.toggleText = function (a, b) {
    return   this.html(this.html().replace(new RegExp("(" + a + "|" + b + ")"), function (x) {
        return(x == a) ? b : a;
    }));
}

$(document).ready(function () {
    $('.tgl').before('<span><img src="./img/detalhes.png" width="149" height="21" alt="detalhes"/></span>');
    $('.tgl').css('display', 'none')
    $('span', '#box-toggle').click(function () {
        $(this).next().slideToggle('slow')
                .siblings('.tgl:visible').slideToggle('fast');

        $(this).toggleText('Revelar', 'Esconder')
                .siblings('span').next('.tgl:visible').prev()
                .toggleText('Revelar', 'Esconder')
    });
});
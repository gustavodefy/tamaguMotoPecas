/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
*/

function validar_Login() {
    if (document.getElementById("email").value == "" || document.getElementById("senha").value == "") {
        alert('Por favor, preencha o campo Email e Senha');
        document.getElementById("email").focus();
        return false;
    }
}

window.onload(function () {
    
    var men = document.getElementById("mensagem").value;
        
        alert(men);        
        return false;

});

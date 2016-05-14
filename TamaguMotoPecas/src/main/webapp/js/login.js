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

function confirma_senha() {
    if (document.getElementById("senha").value != document.getElementById("confirmasenha").value) {
        document.getElementById('erroSenha').src = "./img/erro.png";
        document.getElementById("senha").focus();
        return false;
    } else {
        document.getElementById('erroSenha').src = "./img/ok.png";
    }
}

//function ativa() {
//    var ativar = document.getElementById("perfilClienteSELECT").selected = "Cliente";
//    var desativar = document.getElementById("perfilClienteSELECT").selected = "Funcionario";
//
//    if (ativa) {
//        document.getElementById("perfilClienteFIELDSET").style.display = "none";
//    } else {
//        if (desativar) {
//            document.getElementById("perfilClienteFIELDSET").style.display = "block";
//        }
//    }
//}

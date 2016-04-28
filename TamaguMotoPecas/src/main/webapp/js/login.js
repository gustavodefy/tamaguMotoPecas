/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function Login() {
    var done = 0;
    var username = document.login.username.value;
    username = username.toLowerCase();
    var password = document.login.password.value;
    password = password.toLowerCase();
    if (username == "thayro" && password == "123") {
        //document.getElementById("InlineFrame1").src = "./ServletFornecedor?action=listar";
        document.write("Você logou com Funcionario");
        
        done = 1;
    }
    if (username == "teste" && password == "123") {
        document.write("Você logou como Cliente");
        done = 1;
    }
    if (username == "outro" && password == "outrasenha") {
        window.location = "http://www.seu_site.com.br";
        done = 1;
    }
    if (done == 0) {
        alert("Senha ou Usuário inválido.");
    }
}



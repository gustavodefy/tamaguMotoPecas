/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * Valida CPF e ou CNPJ
 */


function validarCpfCnpj() {
    
    var cpfcnpj = document.getElementById("cpf_cnpj").value;
    
    if (cpfcnpj.length===0) {
        return true;
    }
    
    
    cpfcnpj = removeChar(cpfcnpj,".");
    cpfcnpj = removeChar(cpfcnpj,"-");
    cpfcnpj = removeChar(cpfcnpj,"/");
    
    if (!isNumber(cpfcnpj)){
        alert("CPF/CNPJ inválido!");
        document.getElementById("cpf_cnpj").onfocus;
        return false;
    }

    var len = cpfcnpj.length;
    if (len == 11) {

        if (!validarCpf(cpfcnpj)) {
            alert("CPF inválido!");
            document.getElementById("cpf_cnpj").onfocus;
            return false;
        }else{
            //012.345.678-90
           cpfcnpj = cpfcnpj.substring(0,3) + "." + 
                     cpfcnpj.substring(3,6) + "." +
                     cpfcnpj.substring(6,9) + "-" +
                     cpfcnpj.substring(9,11);            
        }

    } else if (len == 14) {

        if (!validarCnpj(cpfcnpj)) {
            alert("CNPJ inválido!");
            document.getElementById("cpf_cnpj").onfocus;
            return false;
        }else{
            //01.234.567/8901-23
           cpfcnpj = cpfcnpj.substring(0,2)  + "." + 
                     cpfcnpj.substring(2,5)  + "." +
                     cpfcnpj.substring(5,8)  + "/" +
                     cpfcnpj.substring(8,12) + "-" +
                     cpfcnpj.substring(12,14);                                    
        }

    } else {
        alert("CPF/CNPJ inválido!");
        document.getElementById("cpf_cnpj").onfocus;
        return false;
    }
    
    document.getElementById("cpf_cnpj").value = cpfcnpj;    
    return cpfcnpj;    
}

/* *******************************
 * Valida CPF
 * *******************************/

function validarCpf(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;

    if (strCPF == "00000000000" ||
            strCPF == "11111111111" ||
            strCPF == "22222222222" ||
            strCPF == "33333333333" ||
            strCPF == "44444444444" ||
            strCPF == "55555555555" ||
            strCPF == "66666666666" ||
            strCPF == "77777777777" ||
            strCPF == "88888888888" ||
            strCPF == "99999999999") {

        return false;

    }

    for (i = 1; i <= 9; i++) {
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
        Resto = (Soma * 10) % 11;
    }

    if ((Resto == 10) || (Resto == 11)) {
        Resto = 0;
    }

    if (Resto != parseInt(strCPF.substring(9, 10))) {
        return false;
    }

    Soma = 0;
    for (i = 1; i <= 10; i++) {
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
        Resto = (Soma * 10) % 11;
    }

    if ((Resto == 10) || (Resto == 11)) {
        Resto = 0;
    }

    if (Resto != parseInt(strCPF.substring(10, 11))) {
        return false;
    }

    return true;
}

/* *******************************
 * Valida CNPJ
 * *******************************/
function validarCnpj(strCnpj) {

    if (strCnpj == "00000000000000" ||
            strCnpj == "11111111111111" ||
            strCnpj == "22222222222222" ||
            strCnpj == "33333333333333" ||
            strCnpj == "44444444444444" ||
            strCnpj == "55555555555555" ||
            strCnpj == "66666666666666" ||
            strCnpj == "77777777777777" ||
            strCnpj == "88888888888888" ||
            strCnpj == "99999999999999") {

        return false;

    }

    var tamanho = strCnpj.length - 2;
    var numeros = strCnpj.substring(0, tamanho);
    var digitos = strCnpj.substring(tamanho);
    var soma = 0;
    var pos = tamanho - 7;

    for (i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) {
            pos = 9;
        }
    }

    var resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(0)) {
        return false;
    }

    tamanho = tamanho + 1;
    numeros = strCnpj.substring(0, tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) {
            pos = 9;
        }
    }

    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(1)) {
        return false;
    }

    return true;
   
}

function isNumber(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function removeChar(str,de){
    var pos = str.indexOf(de);
    while (pos > -1){
		str = str.replace(de, "");
		pos = str.indexOf(de);
	}
    return (str);
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.biblioteca;

import java.util.InputMismatchException;

/**
 *
 * @author ResVUT42
 */
public class Lib {

    /*Valida CPF e CNPJ*/
    public static void validarCpfCnpj(String CPF_CNPJ) throws Exception {
        try {
            
            String cpf_cnpj = CPF_CNPJ;
            cpf_cnpj = cpf_cnpj.replaceAll("\\.", "");
            cpf_cnpj = cpf_cnpj.replaceAll("-", "");
            cpf_cnpj = cpf_cnpj.replaceAll("/", "");

            if (cpf_cnpj.length() == 11) {
                if (!isCPF(cpf_cnpj)) {
                    throw new Exception("CPF inválido");
                }
            } else if (cpf_cnpj.length() == 14) {
                if (!isCNPJ(cpf_cnpj)) {
                    throw new Exception("CNPJ inválido");
                }
            } else {
                throw new Exception("CPF/CNPJ inválido");
            }
                        
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    /* 
    VALIDAR CPF
     */
    public static boolean isCPF(String CPF) {

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if ((CPF.length() != 11)
                || CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222")
                || CPF.equals("33333333333")
                || CPF.equals("44444444444")
                || CPF.equals("55555555555")
                || CPF.equals("66666666666")
                || CPF.equals("77777777777")
                || CPF.equals("88888888888")
                || CPF.equals("99999999999")) {

            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    /* 
    VALIDAR CNPJ
     */
    public static boolean isCNPJ(String CNPJ) {

        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if ((CNPJ.length() != 14)
                || CNPJ.equals("00000000000000")
                || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222")
                || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444")
                || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666")
                || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888")
                || CNPJ.equals("99999999999999")) {

            return false;
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException erro) {
            return false;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author ResVUT42
 */
public class Range {

    private String atributo;
    private tpRelacao relacao;
    private ArrayList conteudo;

    public Range() {
        this.atributo = "";
        this.relacao = null;
        this.conteudo = new ArrayList();
    }

    public Range(String atributo, tpRelacao relacao, String conteudo) {
        this.atributo = atributo;
        this.relacao = relacao;
        this.conteudo.add(conteudo);
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public tpRelacao getRelacao() {
        return relacao;
    }

    public void setRelacao(tpRelacao relacao) {
        this.relacao = relacao;
    }

    public ArrayList getConteudo() {
        return conteudo;
    }

    public void setConteudo(ArrayList conteudo) {
        this.conteudo = conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo.add(conteudo);
    }

    //Monta uma relação por atributo
    public String getWhere() {
        String where = "(";

        for (int i = 0; i < conteudo.size(); i++) {

            if (i > 0) {
                where = where + " or ";
            }

            where = where + this.atributo;

            where = where + getOperador((String)this.conteudo.get(i));

        }

        where = where + ")";

        return where;

    }
    
    public enum tpRelacao {
        IGUAL, DIFERENTE;
    }

    //Monta condição de comparação
    private String getOperador(String txtPesq) {
        
        String operador = "";
        String texto = txtPesq;
        
        //Verifica se o conteudo tem * no where de pesquisa
        if(texto.indexOf("*") >= 0){
            switch (this.relacao) {
                case IGUAL:
                    operador = " LIKE ";
                    break;
                case DIFERENTE:
                    operador = " NOT LIKE ";
                    break;            
            }
            texto.replaceAll("*", "%");
            operador = operador + "'"+texto+"'";
        }else{
            switch (this.relacao) {
                case IGUAL:
                    operador = " = ";
                    break;
                case DIFERENTE:
                    operador = " <> ";
                    break;            
            }            
            operador = operador + "'"+texto+"'";
        }
                
        return operador;
    }

    //Transformar Array de Range em String do select
    public static String RangeToString(ArrayList<Range> arrayRange) {

        String retorno = "";
        if (arrayRange != null) {

            for (int i = 0; i < arrayRange.size(); i++) {

                Range range = arrayRange.get(i);

                if (i == 0) {
                    retorno = "where ";
                } else {
                    retorno = retorno + " and ";
                }

                retorno = retorno + range.getWhere();
            }

        }

        return retorno;
    }
}

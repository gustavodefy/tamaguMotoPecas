/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.Map;

/**
 *
 * @author Gustavo
 */
public class Contato {
    
    private int idContato;
    private String nome ;
    private String email;
    private String assunto;
    private String telefone;
    private String mensagem;
    
    public Contato(Map<String,Object> values){

        this.setIdContato(Integer.parseInt(values.get("idContato").toString()));
        this.setNome( values.get("nome").toString());
        this.setEmail( values.get("email").toString());
        this.setAssunto(values.get("assunto").toString());
        this.setTelefone( values.get("telefone").toString());
        this.setMensagem(values.get("mensagem").toString());
    }    
       
    
    public Contato(){
        idContato = 0;
        nome = "";
        email = "";
        assunto = "";
        telefone = "";
        mensagem = "";
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }
    
    
}

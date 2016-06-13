/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.Map;

/**
 *
 * @author ResVUT42
 */
public class Fornecedor {

    private int idFornecedor;
    private String nome;
    private String cpf_cnpj;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    private String contato;

    
    public Fornecedor(Map<String,Object> values){
                       
        this.setIdFornecedor(Integer.parseInt(values.get("idCliente").toString()));
        this.setNome( values.get("nome").toString());
        this.setCpf_cnpj( values.get("cpf_cnpj").toString());
        this.setLogradouro( values.get("logradouro").toString());
        this.setNumero( values.get("numero").toString());
        this.setComplemento( values.get("complemento").toString());
        this.setCep( values.get("cep").toString());
        this.setBairro( values.get("bairro").toString());
        this.setCidade( values.get("cidade").toString());
        this.setEstado( values.get("estado").toString());
        this.setTelefone( values.get("telefone").toString());
        this.setEmail( values.get("email").toString());
        this.setContato( values.get("contato").toString());
        
    }
    
    public Fornecedor() {
        this.idFornecedor = 0;
        this.nome = "";
        this.cpf_cnpj = "";
        this.logradouro = "";
        this.numero = "";
        this.complemento = "";
        this.cep = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.telefone = "";
        this.email = "";
        this.contato = "";
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getCpf_cnpjMask() {
        
        String cpfcnpj = "";

        if (cpf_cnpj.length() == 11) {
            
            cpfcnpj = cpf_cnpj.substring(0, 3) + "."
                    + cpf_cnpj.substring(3, 6) + "."
                    + cpf_cnpj.substring(6, 9) + "-"
                    + cpf_cnpj.substring(9, 11);
            
        } else if (cpf_cnpj.length() == 14) {
            
            cpfcnpj = cpf_cnpj.substring(0, 2) + "."
                    + cpf_cnpj.substring(2, 5) + "."
                    + cpf_cnpj.substring(5, 8) + "/"
                    + cpf_cnpj.substring(8, 12) + "-"
                    + cpf_cnpj.substring(12, 14);
        }else{
            cpfcnpj = cpf_cnpj;
        }

        return cpfcnpj;
    }
    
    public void setCpf_cnpj(String cpf_cnpj) {

        cpf_cnpj = cpf_cnpj.replaceAll("\\.", "");
        cpf_cnpj = cpf_cnpj.replaceAll("-", "");
        cpf_cnpj = cpf_cnpj.replaceAll("/", "");

        this.cpf_cnpj = cpf_cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}

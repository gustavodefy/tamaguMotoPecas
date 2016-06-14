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
public class Produto {

    private int idProduto;
    private String descricao;
    private String marca;
    private String modelo;
    private double percentualVenda;
    private double precoCompra;
    private double precoVenda;
    private double estoque;

    public Produto(Map<String,Object> values){
        this.setIdProduto(Integer.parseInt(values.get("idProduto").toString()));
        this.setDescricao(values.get("descricao").toString());
        this.setMarca(values.get("marca").toString());
        this.setModelo(values.get("modelo").toString());
        this.setPercentualVenda(Double.parseDouble(values.get("percentualVenda").toString()));
        this.setPrecoVenda(Double.parseDouble(values.get("precoVenda").toString()));
        this.setEstoque(Double.parseDouble(values.get("estoque").toString()));        
    }
    
    public Produto() {
        this.idProduto = 0;
        this.descricao = "";
        this.marca = "";
        this.modelo = "";
        this.percentualVenda = 0;
        this.precoVenda = 0;
        this.estoque = 0;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPercentualVenda() {
        return percentualVenda;
    }

    public void setPercentualVenda(double percentualVenda) {
        this.percentualVenda = percentualVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
    
    public void consomeEstoque(double quantidade){
        this.estoque = this.estoque - quantidade;
    }
    
    public void somaEstoque(double quantidade){
        this.estoque = this.estoque + quantidade;
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import br.com.tmgmotopeca.dao.SelecionaDao.ListaDaos;
import java.util.Map;

/**
 *
 * @author ResVUT42
 */
public class PCItem {

    private int idPedido;
    private Produto produto;
    private double quantidade;
    private double vlrUnitario;
    private double vlrTotal;

    public PCItem(Map<String,Object> values) throws Exception{
        this.setIdPedido(Integer.parseInt(values.get("idPedido").toString()));
        this.setProduto(Integer.parseInt(values.get("produto").toString()));
        this.setQuantidade(Double.parseDouble(values.get("quantidade").toString()));
        this.setVlrUnitario(Double.parseDouble(values.get("vlrUnitario").toString()));
        this.setVlrTotal(Double.parseDouble(values.get("vlrTotal").toString()));
    }
    
    public PCItem() {
        idPedido = 0;
        produto = null;
        quantidade = 0;
        vlrUnitario = 0;
        vlrTotal = 0;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setProduto(int idProduto) throws Exception {
        try {
            Dao daoProduto = SelecionaDao.Selecionar(ListaDaos.PRODUTO);
            this.produto = (Produto) daoProduto.buscaUnica((Integer) idProduto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

}

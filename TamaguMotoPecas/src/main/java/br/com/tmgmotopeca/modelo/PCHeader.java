/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..
 */
package br.com.tmgmotopeca.modelo;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class PCHeader {

    private int idPedido;
    private Fornecedor fornecedor;
    private Date dtLcto;
    private double totalPedido;
    private eStatus status;

    
    public static enum eStatus{
        ABERTO, 
        CANCELADO, 
        CONCLUIDO;
    }
            
    public PCHeader() {
        idPedido = 0;
        fornecedor = null;
        dtLcto = null;
        totalPedido = 0;
        status = eStatus.ABERTO;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDtLcto() {
        return dtLcto;
    }

    public void setDtLcto(Date dtLcto) {
        this.dtLcto = dtLcto;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public eStatus getStatus() {
        return status;
    }

    public void setStatus(eStatus status) {
        this.status = status;
    }           
}

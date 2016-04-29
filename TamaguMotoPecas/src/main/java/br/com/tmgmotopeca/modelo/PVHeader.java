/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class PVHeader {
    
    private int idPedido;
    private Cliente cliente;
    private Date dtLcto;
    private double totalPedido;
    private eStatus status;

    
    public static enum eStatus{
        ABERTO, 
        CANCELADO, 
        CONCLUIDO;
    }

    public PVHeader() {
     idPedido = 0;
        cliente = null;
        dtLcto = new Date();
       totalPedido = 0;
       status = eStatus.ABERTO;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

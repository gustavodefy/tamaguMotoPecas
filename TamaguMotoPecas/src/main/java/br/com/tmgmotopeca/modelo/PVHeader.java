/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
    private eForma formaPgto;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
     public PVHeader(Map<String,Object> values) throws Exception{
        this.setIdPedido(Integer.parseInt(values.get("idPedido").toString()));
        this.setCliente(Integer.parseInt(values.get("idCliente").toString()));
        this.setDtLcto(formato.parse(values.get("dtLcto").toString()));
        this.setTotalPedido(Double.parseDouble(values.get("totalPedido").toString()));
        this.setStatus(PVHeader.eStatus.valueOf(values.get("status").toString()));
        this.setFormaPgto(PVHeader.eForma.valueOf(values.get("formaPgto").toString()));
    }
    
    public static enum eStatus {
        ABERTO,
        CANCELADO,
        ENVIADO,
        CONCLUIDO;
    }
    
    public static enum eForma{
        BOLETO,
        CARTAO;        
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
    
     public void setCliente(int idCliente) throws Exception{
        
        try {
            Dao daoCliente = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.CLIENTE);
            this.cliente = (Cliente) daoCliente.buscaUnica((Integer)idCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }        
    
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

    public eForma getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(eForma formaPgto) {
        this.formaPgto = formaPgto;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package br.com.tmgmotopeca.modelo;

import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import br.com.tmgmotopeca.dao.SelecionaDao.ListaDaos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public static enum eStatus{
        ABERTO, 
        CANCELADO, 
        CONCLUIDO;
    }
     
    public PCHeader(Map<String,Object> values) throws Exception{
        this.setIdPedido(Integer.parseInt(values.get("idPedido").toString()));
        this.setFornecedor(Integer.parseInt(values.get("idFornecedor").toString()));
        this.setDtLcto(formato.parse(values.get("dtLcto").toString()));
        this.setTotalPedido(Double.parseDouble(values.get("totalPedido").toString()));
        this.setStatus(eStatus.valueOf(values.get("status").toString()));
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
    
    public void setFornecedor(int idFornecedor) throws Exception{
        
        try {
            Dao daoFornecedor = SelecionaDao.Selecionar(ListaDaos.FORNECEDOR);
            this.fornecedor = (Fornecedor) daoFornecedor.buscaUnica((Integer)idFornecedor);
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
}

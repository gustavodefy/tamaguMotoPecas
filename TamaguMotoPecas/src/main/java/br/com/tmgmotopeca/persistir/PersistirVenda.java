/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import br.com.tmgmotopeca.modelo.PedidoVenda;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ResVUT42
 */
public class PersistirVenda implements Persistir{

    private PedidoVenda pedidoVenda;
    private Dao daoPVHeader;
    private Dao daoPVItem;
    
    public PersistirVenda(PedidoVenda pedidoVenda) {
        this.pedidoVenda = pedidoVenda;
        this.daoPVHeader = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PVHEADER);
        this.daoPVItem   = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PVITEM);
    }       
    
    @Override
    public Object getEntidade() throws Exception {
        return this.pedidoVenda;
    }

    @Override
    public void setEntidade(Object entidade) throws Exception {
        this.pedidoVenda = (PedidoVenda) entidade;
    }

    @Override
    public int gravar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validarInformacoes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator buscarLista(ArrayList<Range> arrayRange) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
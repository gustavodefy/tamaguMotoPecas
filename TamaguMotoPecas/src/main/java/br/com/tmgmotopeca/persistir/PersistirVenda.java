/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import br.com.tmgmotopeca.modelo.PVItem;
import br.com.tmgmotopeca.modelo.PedidoVenda;
import br.com.tmgmotopeca.modelo.Produto;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ResVUT42
 */
public class PersistirVenda implements Persistir {

    private PedidoVenda pedidoVenda;
    private Dao daoPVHeader;
    private Dao daoPVItem;
    private Dao daoProduto;

    public PersistirVenda(PedidoVenda pedidoVenda) {
        this.pedidoVenda = pedidoVenda;
        this.daoPVHeader = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PVHEADER);
        this.daoPVItem = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PVITEM);
        this.daoProduto = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PRODUTO);
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
        try {
            int id = 0;

            validarInformacoes();

            
            if (pedidoVenda.getHeader().getIdPedido() == 0) {
                //Se estiver incluindo
                id = daoPVHeader.inserir(pedidoVenda.getHeader());
                Iterator<PVItem> listaItem = pedidoVenda.getItens();

                while (listaItem.hasNext()) {
                    PVItem pvItem = listaItem.next();
                    pvItem.setIdPedido(id);
                    daoPVItem.inserir(pvItem);
                    
                    //Atualiza estoque do produto
                    Produto produto = pvItem.getProduto();
                    produto.consomeEstoque(pvItem.getQuantidade());
                    daoProduto.alterar(produto);                    
                }
                
            } else {
                //Se estiver alterando
                id = pedidoVenda.getHeader().getIdPedido();
                daoPVHeader.alterar(pedidoVenda.getHeader());
                
                Iterator<PVItem> listaItem = pedidoVenda.getItens();
                while (listaItem.hasNext()) {
                    PVItem pvItem = listaItem.next();
                    daoPVItem.alterar(pvItem);
                    
                    //Atualiza estoque do produto
                    Produto produto = pvItem.getProduto();
                    produto.consomeEstoque(pvItem.getQuantidade());
                    daoProduto.alterar(produto);                    
                }                
            }

            return id;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator buscarLista(ArrayList<Range> arrayRange) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

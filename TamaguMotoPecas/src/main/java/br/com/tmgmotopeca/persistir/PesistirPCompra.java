/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.PCHeader;
import br.com.tmgmotopeca.modelo.PCItem;
import br.com.tmgmotopeca.modelo.PedidoCompra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class PesistirPCompra implements Persistir {

    private PedidoCompra pedidoCompra;
    private PCItem item;
    private PCHeader header;
    private Dao DaoHeader;
    private Dao DaoItem;

    public PesistirPCompra() {
        pedidoCompra = null;
        item = null;
        header = null;
        DaoItem = null;
        DaoHeader = null;
    }

    @Override
    public Object getEntidade() throws Exception {
        return this.pedidoCompra;
    }

    @Override
    public void setEntidade(Object entidade) throws Exception {
        this.pedidoCompra = (PedidoCompra) entidade;
    }

    @Override
    public int gravar() throws Exception {
        int id = 0;

        try {
            if (pedidoCompra.getPCHeader().getIdPedido() == 0) {
                id = DaoHeader.inserir(this.pedidoCompra.getPCHeader());
                ArrayList<PCItem> listaPcitem = pedidoCompra.getArrayPCItem();
                for (PCItem p : listaPcitem) {
                    p.setIdPedido(id);
                    DaoItem.inserir(p);
                }
            } else {
                DaoHeader.alterar(this.pedidoCompra.getPCHeader());
                ArrayList<PCItem> listaPcitem = pedidoCompra.getArrayPCItem();
                for (PCItem p : listaPcitem) {
                    DaoItem.alterar(p);
                }
                id = pedidoCompra.getPCHeader().getIdPedido();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return id;
    }

    @Override
    public void excluir() throws Exception {
        try {
            DaoItem.deletar(this.item);
            DaoHeader.deletar(this.header);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void buscar(int id) throws Exception {
        try {

            ArrayList whereId = new ArrayList();
            Range rangeId = new Range();

            rangeId.setAtributo("idPedido");
            rangeId.setRelacao(Range.tpRelacao.IGUAL);
            rangeId.setConteudo(String.valueOf(id));

            whereId.add(rangeId);

            Iterator listheader = DaoHeader.getLista(whereId);

            if (listheader.hasNext()) {
                pedidoCompra.setPCHeader((PCHeader) listheader.next());                
                buscaItens(pedidoCompra);
            }

        } catch (Exception e) {
            throw new Exception("Item ou cabeçalho não encontrado!" + e.getMessage());
        }
    }

    @Override
    public void validarInformacoes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator buscarLista(ArrayList<Range> rangeCondicao) throws Exception {
        try {

            ArrayList<PedidoCompra> listapedido = new ArrayList<PedidoCompra>();

            Iterator listaHeader = DaoHeader.getLista(rangeCondicao);

            while (listaHeader.hasNext()) {
                
                PedidoCompra pedidoCompra = new PedidoCompra();
                pedidoCompra.setPCHeader((PCHeader) listaHeader.next());
                
                buscaItens(pedidoCompra);
                
                listapedido.add(pedidoCompra);

            }
            
            return listapedido.iterator();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void buscaItens(PedidoCompra pedidoCompra) throws Exception {

        ArrayList whereId2 = new ArrayList();
        Range rangeId2 = new Range();

        rangeId2.setAtributo("idPedido");
        rangeId2.setRelacao(Range.tpRelacao.IGUAL);
        rangeId2.setConteudo(String.valueOf(pedidoCompra.getPCHeader().getIdPedido()));
        whereId2.add(rangeId2);

        Iterator listaItens = DaoItem.getLista(whereId2);
        
        while (listaItens.hasNext()) {
            pedidoCompra.addPCItem((PCItem) listaItens.next());
        }

    }

}

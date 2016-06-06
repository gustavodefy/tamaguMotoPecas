/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import br.com.tmgmotopeca.modelo.PCHeader;
import br.com.tmgmotopeca.modelo.PCItem;
import br.com.tmgmotopeca.modelo.PedidoCompra;
import br.com.tmgmotopeca.modelo.Produto;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Gustavo
 */
public class PesistirPCompra implements Persistir {

    private PedidoCompra pedidoCompra;
    private PCItem item;
    private PCHeader header;
    private Dao daoHeader;
    private Dao daoItem;
    private Dao daoProduto;

    public PesistirPCompra(PedidoCompra pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
        this.daoHeader = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PCHEADER);
        this.daoItem = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PCITEM);
        this.daoProduto = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.PRODUTO);
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
        try {

            int id = 0;

            validarInformacoes();

            if (pedidoCompra.getPCHeader().getIdPedido() == 0) {

                id = daoHeader.inserir(this.pedidoCompra.getPCHeader());

                Iterator<PCItem> listaItem = pedidoCompra.getItens();
                while (listaItem.hasNext()) {
                    PCItem pcItem = listaItem.next();
                    pcItem.setIdPedido(id);
                    daoItem.inserir(pcItem);

                    //Atualiza estoque do produto
                    Produto produto = pcItem.getProduto();
                    produto.somaEstoque(pcItem.getQuantidade());
                    daoProduto.alterar(produto);
                }

            } else {

                id = pedidoCompra.getPCHeader().getIdPedido();
                daoHeader.alterar(this.pedidoCompra.getPCHeader());

                Iterator<PCItem> listaItem = pedidoCompra.getItens();
                while (listaItem.hasNext()) {
                    PCItem pcItem = listaItem.next();
                    daoItem.alterar(pcItem);

                    //Atualiza estoque do produto
                    Produto produto = pcItem.getProduto();
                    produto.somaEstoque(pcItem.getQuantidade());
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
        try {
            daoHeader.deletar(this.pedidoCompra.getPCHeader());
            Iterator<PCItem> listaItem = pedidoCompra.getItens();
            while (listaItem.hasNext()) {
                PCItem pcItem = listaItem.next();
                daoItem.deletar(pcItem);

                //Atualiza estoque do produto
                Produto produto = pcItem.getProduto();
                produto.consomeEstoque(pcItem.getQuantidade());
                daoProduto.alterar(produto);
            }

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

            Iterator listheader = daoHeader.getLista(whereId);

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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator buscarLista(ArrayList<Range> rangeCondicao) throws Exception {
        try {

            ArrayList<PedidoCompra> listapedido = new ArrayList<PedidoCompra>();

            Iterator listaHeader = daoHeader.getLista(rangeCondicao);

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

        Iterator listaItens = daoItem.getLista(whereId2);

        while (listaItens.hasNext()) {
            pedidoCompra.addPCItem((PCItem) listaItens.next());
        }

    }

}

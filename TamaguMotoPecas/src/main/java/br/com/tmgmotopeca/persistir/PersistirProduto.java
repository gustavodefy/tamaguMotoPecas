/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.biblioteca.Range.tpRelacao;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.DaoProduto;
import br.com.tmgmotopeca.modelo.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class PersistirProduto implements Persistir{
    
    private Produto produto;
    private Dao daoProduto;

    public PersistirProduto(Produto produto) {
        this.produto = produto;
        daoProduto = new DaoProduto();
    }

    @Override
    public Object getEntidade() throws Exception {
        return this.produto;
    }

    @Override
    public void setEntidade(Object entidade) throws Exception {
        this.produto = (Produto) entidade;
    }

    @Override
    public int gravar() throws Exception {

        int id = 0;

        try {

            validarInformacoes();

            if (produto.getIdProduto() == 0) {
                id = daoProduto.inserir(this.produto);
            } else {
                daoProduto.alterar(this.produto);
                id = this.produto.getIdProduto();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return id;
    }

    @Override
    public void excluir() throws Exception {
        try {
            daoProduto.deletar(this.produto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void buscar(int id) throws Exception {
        try {

            ArrayList whereId = new ArrayList();
            Range rangeId =  new Range();   
            
            rangeId.setAtributo("idProduto");
            rangeId.setRelacao(tpRelacao.IGUAL);
            rangeId.setConteudo(String.valueOf(id));
            
            whereId.add(rangeId);

            List lista = daoProduto.getLista(whereId);

            if (lista != null) {
                this.produto = (Produto) lista.get(0);
            } else {
                throw new Exception("Produto não encontrado!");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void validarInformacoes() throws Exception {

    }

    @Override
    public Iterator buscarLista(ArrayList<Range> rangeCondicao) throws Exception {

        try {
            List lista = daoProduto.getLista(rangeCondicao);
            return lista.iterator();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}

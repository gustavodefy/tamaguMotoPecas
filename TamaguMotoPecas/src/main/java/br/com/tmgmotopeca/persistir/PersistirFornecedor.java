/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Lib;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.biblioteca.Range.tpRelacao;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.DaoFornecedor;
import br.com.tmgmotopeca.modelo.Fornecedor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class PersistirFornecedor implements Persistir{

    private Fornecedor fornecedor;
    private Dao daoFornecedor;

    public PersistirFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        daoFornecedor = new DaoFornecedor();
    }

    @Override
    public Object getEntidade() throws Exception {
        return this.fornecedor;
    }

    @Override
    public void setEntidade(Object obj) throws Exception {
        this.fornecedor = (Fornecedor) obj;
    }

    @Override
    public int gravar() throws Exception {

        int id = 0;

        try {

            validarInformacoes();

            if (fornecedor.getIdFornecedor() == 0) {
                id = daoFornecedor.inserir(this.fornecedor);
            } else {
                daoFornecedor.alterar(this.fornecedor);
                id = this.fornecedor.getIdFornecedor();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return id;
    }

    @Override
    public void excluir() throws Exception {
        try {
            daoFornecedor.deletar(this.fornecedor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void buscar(int id) throws Exception {
        try {

            ArrayList whereId = new ArrayList();
            Range rangeId =  new Range();   
            
            rangeId.setAtributo("idFornecedor");
            rangeId.setRelacao(tpRelacao.IGUAL);
            rangeId.setConteudo(String.valueOf(id));
            
            whereId.add(rangeId);

            List lista = daoFornecedor.getLista(whereId);

            if (lista != null) {
                this.fornecedor = (Fornecedor) lista.get(0);
            } else {
                throw new Exception("Fornecedor não encontrado!");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void validarInformacoes() throws Exception {
        try {

            Lib.validarCpfCnpj(this.fornecedor.getCpf_cnpj());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterator buscarLista(ArrayList<Range> rangeCondicao) throws Exception {

        try {
            List lista = daoFornecedor.getLista(rangeCondicao);
            return lista.iterator();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }    
}
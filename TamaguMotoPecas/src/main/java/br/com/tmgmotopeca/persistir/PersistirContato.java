/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.dao.SelecionaDao;
import br.com.tmgmotopeca.modelo.Contato;
import br.com.tmgmotopeca.modelo.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class PersistirContato  implements Persistir {
    
    private Contato contato;
    private Dao daoContato;

    public PersistirContato(Contato contato) {
        this.contato = contato;
        daoContato = SelecionaDao.Selecionar(SelecionaDao.ListaDaos.CONTATO);
    }

    @Override
    public Object getEntidade() throws Exception {
        return this.contato;
    }

    @Override
    public void setEntidade(Object entidade) throws Exception {
        this.contato = (Contato) entidade;
    }

    @Override
    public int gravar() throws Exception {

        int id = 0;

        try {

            validarInformacoes();

            if (contato.getIdContato()== 0) {
                id = daoContato.inserir(this.contato);
            } else {
                daoContato.alterar(this.contato);
                id = this.contato.getIdContato();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return id;
    }

    @Override
    public void excluir() throws Exception {
        try {
            daoContato.deletar(this.contato);
        } catch (Exception e) {
            throw new Exception("Não foi possível excluir o registro !!!");
        }
    }

    @Override
    public void buscar(int id) throws Exception {
        try {

            ArrayList whereId = new ArrayList();
            Range rangeId =  new Range();   
            
            rangeId.setAtributo("idContato");
            rangeId.setRelacao(Range.tpRelacao.IGUAL);
            rangeId.setConteudo(String.valueOf(id));
            
            whereId.add(rangeId);

            Iterator lista = daoContato.getLista(whereId);

            if (lista.hasNext()) {
                this.contato = (Contato) lista.next();
            } else {
                throw new Exception("Contatos não encontrados!");
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
            Iterator lista = daoContato.getLista(rangeCondicao);
            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    
}

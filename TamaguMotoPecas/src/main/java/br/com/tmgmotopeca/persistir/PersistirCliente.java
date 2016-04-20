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
import br.com.tmgmotopeca.dao.DaoCliente;
import br.com.tmgmotopeca.modelo.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class PersistirCliente implements Persistir {

    private Cliente cliente;
    private Dao daoCliente;

    public PersistirCliente(Cliente cliente) {
        this.cliente = cliente;
        daoCliente = new DaoCliente();
    }

    @Override
    public Object getEntidade() throws Exception {
        return this.cliente;
    }

    @Override
    public void setEntidade(Object obj) throws Exception {
        this.cliente = (Cliente) obj;
    }

    @Override
    public int gravar() throws Exception {

        int id = 0;

        try {

            validarInformacoes();

            if (cliente.getIdCliente() == 0) {
                id = daoCliente.inserir(this.cliente);
            } else {
                daoCliente.alterar(this.cliente);
                id = this.cliente.getIdCliente();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return id;
    }

    @Override
    public void excluir() throws Exception {
        try {
            daoCliente.deletar(this.cliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void buscar(int id) throws Exception {
        try {

            ArrayList whereId = new ArrayList();
            Range rangeId =  new Range();   
            
            rangeId.setAtributo("idCliente");
            rangeId.setRelacao(tpRelacao.IGUAL);
            rangeId.setConteudo(String.valueOf(id));
            
            whereId.add(rangeId);

            List lista = daoCliente.getLista(whereId);

            if (lista != null) {
                this.cliente = (Cliente) lista.get(0);
            } else {
                throw new Exception("Cliente não encontrado!");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void validarInformacoes() throws Exception {
        try {

            Lib.validarCpfCnpj(this.cliente.getCpf_cnpj());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterator buscarLista(ArrayList<Range> rangeCondicao) throws Exception {

        try {
            List lista = daoCliente.getLista(rangeCondicao);
            return lista.iterator();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}

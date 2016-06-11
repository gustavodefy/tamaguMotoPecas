/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

/**
 *
 * @author ResVUT42
 */
public class DaoEsCliente implements Dao {

    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private Cliente obj;
    private Integer newId;
    private String indice = "cliente";
    private String tabela = "cliente";

    public DaoEsCliente() {
        conexaoES = ConexaoES.getInstance();
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        gNewId = GerarNewId.getInstance();

        this.obj = (Cliente) entidade;
        this.newId = gNewId.getNextNumber();

        Map<String, Object> values = new HashMap<String, Object>();

        values.put("idCliente",newId);
        values.put("nome", this.obj.getNome());
        values.put("cpf_cnpj", this.obj.getCpf_cnpj());
        values.put("logradouro", this.obj.getLogradouro());
        values.put("numero", this.obj.getNumero());
        values.put("complemento", this.obj.getComplemento());
        values.put("cep", this.obj.getCep());
        values.put("bairro", this.obj.getBairro());
        values.put("cidade", this.obj.getCidade());
        values.put("estado", this.obj.getEstado());
        values.put("telefone", this.obj.getTelefone());
        values.put("email", this.obj.getEmail());
        values.put("contato", this.obj.getContato());
        values.put("limiteCredito", this.obj.getLimiteCredito());
        values.put("senha", this.obj.getSenha());
        values.put("perfil", this.obj.getPerfil());

        conexaoES.add(values, indice, tabela, String.valueOf(newId));

        return newId;
    }

    @Override
    public void alterar(Object entidade) throws Exception {

        this.obj = (Cliente) entidade;
        this.newId = this.obj.getIdCliente();
        Map<String, Object> values = new HashMap<String, Object>();

        values.put("idCliente",this.obj.getIdCliente());
        values.put("nome", this.obj.getNome());
        values.put("cpf_cnpj", this.obj.getCpf_cnpj());
        values.put("logradouro", this.obj.getLogradouro());
        values.put("numero", this.obj.getNumero());
        values.put("complemento", this.obj.getComplemento());
        values.put("cep", this.obj.getCep());
        values.put("bairro", this.obj.getBairro());
        values.put("cidade", this.obj.getCidade());
        values.put("estado", this.obj.getEstado());
        values.put("telefone", this.obj.getTelefone());
        values.put("email", this.obj.getEmail());
        values.put("contato", this.obj.getContato());
        values.put("limiteCredito", this.obj.getLimiteCredito());
        values.put("senha", this.obj.getSenha());
        values.put("perfil", this.obj.getPerfil());

        conexaoES.add(values, indice, tabela, String.valueOf(newId));

    }

    @Override
    public void deletar(Object entidade) throws Exception {
        this.obj = (Cliente) entidade;
        conexaoES.delete(indice, tabela, String.valueOf(obj.getIdCliente()));
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) {
        List<Cliente> lista = new ArrayList();

        SearchHits boolQuery = conexaoES.boolQuery(indice, tabela, arrayRange);

        if (boolQuery != null) {
            
            for (SearchHit sh : boolQuery) {
                Cliente c = new Cliente(sh.sourceAsMap());
                lista.add(c);
            }

            return lista.iterator();
            
        } else {
            return null;
        }
        
    }

    @Override
    public Object buscaUnica(Integer id) throws Exception {

        Map<String, Object> values = conexaoES.get(indice, tabela, id + "");
        obj = new Cliente(values);
        return obj;

    }

}

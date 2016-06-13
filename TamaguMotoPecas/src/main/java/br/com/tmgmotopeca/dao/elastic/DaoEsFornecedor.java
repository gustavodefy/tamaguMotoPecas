/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Fornecedor;
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
public class DaoEsFornecedor implements Dao{

    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private Fornecedor obj;
    private Integer newId;
    private String indice = "motopeca";
    private String tabela = "fornecedor";

    public DaoEsFornecedor() {
        conexaoES = ConexaoES.getInstance();
    }
    
    @Override
    public int inserir(Object entidade) throws Exception {
        try {

            gNewId = GerarNewId.getInstance();

            this.obj = (Fornecedor) entidade;
            this.newId = gNewId.getNextNumber();

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idFornecedor", newId);
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


            conexaoES.add(values, indice, tabela, String.valueOf(newId));

            return newId;

        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        try {

            this.obj = (Fornecedor) entidade;
            this.newId = this.obj.getIdFornecedor();
            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idFornecedor", newId);
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


            conexaoES.add(values, indice, tabela, String.valueOf(newId));

        } catch (Exception e) {
            throw new Exception("Erro ao alterar o registro");
        }
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        try {
            this.obj = (Fornecedor) entidade;
            conexaoES.delete(indice, tabela, String.valueOf(obj.getIdFornecedor()));
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o registro");
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {
        try {

            List<Fornecedor> lista = new ArrayList();
            SearchHits boolQuery = conexaoES.boolQuery(indice, tabela, arrayRange);
            if (boolQuery != null) {

                for (SearchHit sh : boolQuery) {
                    Fornecedor c = new Fornecedor(sh.sourceAsMap());
                    lista.add(c);
                }

                return lista.iterator();

            } else {
                return null;
            }

        } catch (Exception e) {
            throw new Exception("Erro ao listar o registro");
        }
    }

    @Override
    public Object buscaUnica(Integer id) throws Exception {
        try {

            Map<String, Object> values = conexaoES.get(indice, tabela, id + "");
            obj = new Fornecedor(values);
            return obj;

        } catch (Exception e) {
            throw new Exception("Erro na busca do registro");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Produto;
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
public class DaoEsProduto implements Dao{

    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private Produto obj;
    private Integer newId;
    private String indice = "motopeca";
    private String tabela = "produto";    
    
    public DaoEsProduto() {
        conexaoES = ConexaoES.getInstance();
    }
        
    @Override
    public int inserir(Object entidade) throws Exception {
        try {

            gNewId = GerarNewId.getInstance();

            this.obj = (Produto) entidade;
            this.newId = gNewId.getNextNumber();

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idProduto", newId);
            values.put("descricao", this.obj.getDescricao());
            values.put("marca", this.obj.getMarca());
            values.put("modelo", this.obj.getModelo());
            values.put("percentualVenda", this.obj.getPercentualVenda());
            values.put("precoVenda", this.obj.getPrecoVenda());
            values.put("estoque", this.obj.getEstoque());

            conexaoES.add(values, indice, tabela, String.valueOf(newId));

            return newId;            
        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        try {

            gNewId = GerarNewId.getInstance();

            this.obj = (Produto) entidade;
            this.newId = obj.getIdProduto();
            
            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idProduto", newId);
            values.put("descricao", this.obj.getDescricao());
            values.put("marca", this.obj.getMarca());
            values.put("modelo", this.obj.getModelo());
            values.put("percentualVenda", this.obj.getPercentualVenda());
            values.put("precoVenda", this.obj.getPrecoVenda());
            values.put("estoque", this.obj.getEstoque());

            conexaoES.add(values, indice, tabela, String.valueOf(newId));

    
        } catch (Exception e) {
            throw new Exception("Erro ao alterar o registro");
        }
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        try {

            this.obj = (Produto) entidade;
            conexaoES.delete(indice, tabela, String.valueOf(obj.getIdProduto()));

        } catch (Exception e) {
            throw new Exception("Erro ao deletar o registro");
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {
        try {

            List<Produto> lista = new ArrayList();
            SearchHits boolQuery = conexaoES.boolQuery(indice, tabela, arrayRange);
            if (boolQuery != null) {

                for (SearchHit sh : boolQuery) {
                    Produto c = new Produto(sh.sourceAsMap());
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
            obj = new Produto(values);
            return obj;

        } catch (Exception e) {
            throw new Exception("Erro na busca do registro");
        }
    }
    
}

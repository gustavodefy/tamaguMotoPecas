/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.PVItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

/**
 *
 * @author Gustavo
 */
public class DaoEsPVItem implements Dao {
    
    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private PVItem obj;
    private Integer newId;
    private String indice = "motopeca";
    private String tabela = "pvitem";
    
    public DaoEsPVItem() {
        conexaoES = ConexaoES.getInstance();        
    }

    @Override
    public int inserir(Object entidade) throws Exception {
        try {
            this.obj = (PVItem) entidade;                                    
            this.newId = Integer.parseInt(obj.getIdPedido()+""+obj.getProduto().getIdProduto());

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idPedido",obj.getIdPedido());
            values.put("idProduto",obj.getProduto().getIdProduto());
            values.put("quantidade", obj.getQuantidade());
            values.put("vlrUnitario", obj.getVlrUnitario());
            values.put("vlrTotal", obj.getVlrTotal());

            conexaoES.add(values, indice, tabela, String.valueOf(newId));

            return newId;

        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }  
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        try {

            this.obj = (PVItem) entidade;                                    
            this.newId = Integer.parseInt(obj.getIdPedido()+""+obj.getProduto().getIdProduto());

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idPedido",obj.getIdPedido());
            values.put("idProduto",obj.getProduto().getIdProduto());
            values.put("quantidade", obj.getQuantidade());
            values.put("vlrUnitario", obj.getVlrUnitario());
            values.put("vlrTotal", obj.getVlrTotal());

            conexaoES.add(values, indice, tabela, String.valueOf(newId));

        } catch (Exception e) {
            throw new Exception("Erro ao alterar o registro");
        }   
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        
          try {
            this.obj = (PVItem) entidade;
            conexaoES.delete(indice, tabela, obj.getIdPedido()+""+obj.getProduto().getIdProduto());
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o registro");
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {
        try {

            List<PVItem> lista = new ArrayList();
            SearchHits boolQuery = conexaoES.boolQuery(indice, tabela, arrayRange);
            if (boolQuery != null) {

                for (SearchHit sh : boolQuery) {
                    PVItem c = new PVItem(sh.sourceAsMap());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.PVHeader;
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
public class DaoEsPVHeader implements Dao{
    
    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private PVHeader obj;
    private Integer newId;
    private String indice = "motopeca";
    private String tabela = "pvheader";
    
    public DaoEsPVHeader() {
        conexaoES = ConexaoES.getInstance();
    }
    
    @Override
    public int inserir(Object entidade) throws Exception {
        
        try {
            
            gNewId = GerarNewId.getInstance();
            
            this.obj = (PVHeader) entidade;
            this.newId = gNewId.getNextNumber();
            
            Map<String, Object> values = new HashMap<String, Object>();
            
            values.put("idPedido", newId);
            values.put("idCliente",obj.getCliente().getIdCliente());
            values.put("dtLcto", obj.getDtLcto());
            values.put("totalPedido", obj.getTotalPedido());
            values.put("status", obj.getStatus());
            values.put("formaPgto", obj.getFormaPgto());
            
            conexaoES.add(values, indice, tabela, String.valueOf(newId));
            
            return newId;
            
        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }
    }
    
    @Override
    public void alterar(Object entidade) throws Exception {
        
        try {
            
            this.obj = (PVHeader) entidade;
            this.newId = obj.getIdPedido();
            
            Map<String, Object> values = new HashMap<String, Object>();
            
            values.put("idPedido", newId);
            values.put("idCliente",obj.getCliente().getIdCliente());
            values.put("dtLcto", obj.getDtLcto());
            values.put("totalPedido", obj.getTotalPedido());
            values.put("status", obj.getStatus());
            values.put("formaPgto", obj.getFormaPgto());
            
            conexaoES.add(values, indice, tabela, String.valueOf(newId));
            
            
        } catch (Exception e) {
            throw new Exception("Erro ao alterar o registro");
        }
    }
    
    @Override
    public void deletar(Object entidade) throws Exception {
        try {
            this.obj = (PVHeader) entidade;
            conexaoES.delete(indice, tabela, String.valueOf(obj.getIdPedido()));
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o registro");
        }
    }
    
    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {
        
        try {
            
            List<PVHeader> lista = new ArrayList();
            SearchHits boolQuery = conexaoES.boolQuery(indice, tabela, arrayRange);
            if (boolQuery != null) {
                
                for (SearchHit sh : boolQuery) {
                    PVHeader c = new PVHeader(sh.sourceAsMap());
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
            obj = new PVHeader(values);
            return obj;
            
        } catch (Exception e) {
            throw new Exception("Erro na busca do registro");
        }
    }
    
}

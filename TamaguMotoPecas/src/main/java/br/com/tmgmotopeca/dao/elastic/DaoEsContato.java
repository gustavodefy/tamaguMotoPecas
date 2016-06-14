/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Contato;
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
public class DaoEsContato implements Dao{
    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private Contato obj;
    private Integer newId;
    private String indice = "motopeca";
    private String tabela = "contato";

    public DaoEsContato() {
        conexaoES = ConexaoES.getInstance();
    }    

    @Override
    public int inserir(Object entidade) throws Exception {
        try {

            gNewId = GerarNewId.getInstance();

            this.obj = (Contato) entidade;
            this.newId = gNewId.getNextNumber();

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idContato", newId);
            values.put("nome", this.obj.getNome());
            values.put("email", this.obj.getEmail());            
            values.put("assunto", this.obj.getAssunto());
            values.put("telefone", this.obj.getTelefone());            
            values.put("mensagem", this.obj.getMensagem());

            conexaoES.add(values, indice, tabela, String.valueOf(newId));

            return newId;

        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        try {

            this.obj = (Contato) entidade;
            this.newId = obj.getIdContato();

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idContato", newId);
            values.put("nome", this.obj.getNome());
            values.put("email", this.obj.getEmail());            
            values.put("assunto", this.obj.getAssunto());
            values.put("telefone", this.obj.getTelefone());            
            values.put("mensagem", this.obj.getMensagem());

            conexaoES.add(values, indice, tabela, String.valueOf(newId));


        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        try {
            this.obj = (Contato) entidade;
            conexaoES.delete(indice, tabela, String.valueOf(obj.getIdContato()));
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o registro");
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {
        try {

            List<Contato> lista = new ArrayList();
            SearchHits boolQuery = conexaoES.boolQuery(indice, tabela, arrayRange);
            if (boolQuery != null) {

                for (SearchHit sh : boolQuery) {
                    Contato c = new Contato(sh.sourceAsMap());
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

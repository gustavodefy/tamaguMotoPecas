/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.PCHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ResVUT42
 */
public class DaoEsPCHeader implements Dao{
    
    private ConexaoES conexaoES;
    private GerarNewId gNewId;
    private PCHeader obj;
    private Integer newId;
    private String indice = "motopeca";
    private String tabela = "pcheader";
    
    public DaoEsPCHeader() {
        conexaoES = ConexaoES.getInstance();
    }
        
    @Override
    public int inserir(Object entidade) throws Exception {
        try {

            gNewId = GerarNewId.getInstance();

            this.obj = (PCHeader) entidade;
            this.newId = gNewId.getNextNumber();

            Map<String, Object> values = new HashMap<String, Object>();

            values.put("idPedido", newId);
            values.put("fornecedor",obj.getFornecedor().getIdFornecedor());
            values.put("dtLcto", obj.getDtLcto());
            



            conexaoES.add(values, indice, tabela, String.valueOf(newId));

            return newId;

        } catch (Exception e) {
            throw new Exception("Erro ao inserir o registro");
        }        
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscaUnica(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

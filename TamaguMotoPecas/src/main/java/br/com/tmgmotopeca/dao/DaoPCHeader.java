/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.Fornecedor;
import br.com.tmgmotopeca.modelo.PCHeader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class DaoPCHeader implements Dao{

    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private PCHeader obj;
    private int newId;
    
    public DaoPCHeader() {
        this.connection = Conexao.conectar();
    }    
    
    private void setDadosQuery(int comId) throws Exception {

        int nx = 0;

        try {
            nx++;
            ps.setInt(nx, obj.getFornecedor().getIdFornecedor());

            nx++;
            ps.setDate(nx,  (java.sql.Date) obj.getDtLcto());

            nx++;
            ps.setDouble(nx, obj.getTotalPedido());

            nx++;
            ps.setString(nx, String.valueOf(obj.getStatus()));
            
            if (comId == 1) {
                //o id deve ser sempre o ultimo
                nx++;
                ps.setInt(nx, obj.getIdPedido());
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosQuery() throws Exception {

        try {
            DaoFornecedor daofornecedor = new DaoFornecedor();
            
            obj.setIdPedido(rs.getInt("idPedido"));                        
            obj.setFornecedor((Fornecedor)daofornecedor.buscaUnica(rs.getInt("idFornecedor")));                        
            obj.setDtLcto(rs.getDate("dtLcto"));
            obj.setTotalPedido(rs.getDouble("totalPedido"));
            obj.setStatus(PCHeader.eStatus.valueOf(rs.getString("status")));
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List getLista(ArrayList<Range> arrayRange) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscaUnica(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

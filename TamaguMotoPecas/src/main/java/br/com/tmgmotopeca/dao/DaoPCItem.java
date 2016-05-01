/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.PCItem;
import br.com.tmgmotopeca.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class DaoPCItem implements Dao {

    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private PCItem obj;
    private int newId;

    public DaoPCItem() {
        this.connection = Conexao.conectar();
    }

    private void setDadosQuery() throws Exception {

        int nx = 0;

        try {

            nx++;
            ps.setDouble(nx, obj.getQuantidade());

            nx++;
            ps.setDouble(nx, obj.getVlrUnitario());

            nx++;
            ps.setDouble(nx, obj.getVlrTotal());

            //o id deve ser sempre o ultimo
            nx++;
            ps.setInt(nx, obj.getIdPedido());

            nx++;
            ps.setInt(nx, obj.getProduto().getIdProduto());
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosQuery() throws Exception {

        try {
            DaoProduto daoproduto = new DaoProduto();

            obj.setIdPedido(rs.getInt("idPedido"));
            obj.setProduto((Produto) daoproduto.buscaUnica(rs.getInt("idProduto")));
            obj.setQuantidade(rs.getDouble("quantidade"));
            obj.setVlrUnitario(rs.getDouble("vlrUnitario"));
            obj.setVlrTotal(rs.getDouble("vlrTotal"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (PCItem) entidade;
        this.newId = 0;

        try {

            sql = "insert into pcItem (";
            sql += "quantidade,";
            sql += "vlrUnitario,";
            sql += "vlrTotal,";
            //o id deve ser sempre o ultimo, isso quando não for gerado automáticamente
            sql += "idPedido,";
            sql += "idProduto";            
            sql += ") values (?,?,?,?,?)";

            ps = connection.prepareStatement(sql);
            setDadosQuery();
            ps.executeUpdate();

            newId = obj.getIdPedido();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        ps.close();
        return newId;
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        
        this.obj = (PCItem) entidade;

        try {
            sql = "update pcItem set ";
            sql += "quantidade=?,";
            sql += "vltUnitario=?,";
            sql += "vlrTotal=?";
            sql += " where idPedido=?";
            sql += "   and idProduto=?";

            ps = connection.prepareStatement(sql);
            setDadosQuery();
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        
        this.obj = (PCItem) entidade;

        try {

            sql  = "delete from pcItem where idPedido  = ?";
            sql += "                     and idProduto = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdPedido());
            ps.setInt(2, this.obj.getProduto().getIdProduto());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void deletarTodosItens(Object entidade) throws Exception {
        
        this.obj = (PCItem) entidade;

        try {

            sql  = "delete from pcItem where idPedido  = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdPedido());
            ps.setInt(2, this.obj.getProduto().getIdProduto());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public List getLista(ArrayList<Range> arrayRange) throws Exception {
        
        List<PCItem> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from pcItem " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new PCItem();
                getDadosQuery();
                lista.add(obj);
            }
            
            return lista;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Object buscaUnica(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

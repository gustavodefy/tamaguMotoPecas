/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
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
public class DaoProduto implements Dao {

    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Produto obj;
    private int newId;

    public DaoProduto() {
        this.connection = Conexao.conectar();
    }

    private void setDadosQuery(int comId) throws Exception {
        int nx = 0;
        try {
            nx++;
            ps.setString(nx, obj.getDescricao());

            nx++;
            ps.setString(nx, obj.getMarca());

            nx++;
            ps.setString(nx, obj.getModelo());

            nx++;
            ps.setDouble(nx, obj.getPercentualVenda());

            nx++;
            ps.setDouble(nx, obj.getPrecoCompra());

            nx++;
            ps.setDouble(nx, obj.getPrecoVenda());
            
            nx++;
            ps.setDouble(nx, obj.getEstoque());

            //o id deve ser sempre o ultimo
            if (comId == 1) {
                nx++;
                ps.setInt(nx, obj.getIdProduto());
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosQuery() throws Exception {
        try {
            obj.setIdProduto(rs.getInt("idproduto"));
            obj.setDescricao(rs.getString("descricao"));
            obj.setMarca(rs.getString("marca"));
            obj.setModelo(rs.getString("modelo"));
            obj.setPercentualVenda(rs.getDouble("percentualvenda"));
            obj.setPrecoCompra(rs.getDouble("precocompra"));
            obj.setPrecoVenda(rs.getDouble("precovenda"));
            obj.setEstoque(rs.getDouble("estoque"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (Produto) entidade;
        this.newId = 0;

        try {

            sql = "insert into produto (";
            sql += "descricao,";
            sql += "marca,";
            sql += "modelo,";
            sql += "percentualvenda,";
            sql += "precocompra,";
            sql += "precovenda,";
            sql += "estoque";
            sql += ") values (?,?,?,?,?,?,?)";

            ps = connection.prepareStatement(sql);
            setDadosQuery(0);
            newId = ps.executeUpdate();

            //Verifica se inseriu algum registro
            if (newId > 0) {

                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    newId = (int) rs.getLong(1);
                }

            } else {
                newId = 0;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        ps.close();
        return newId;
    }

    @Override
    public void alterar(Object entidade) throws Exception {
        
        this.obj = (Produto) entidade;

        try {
            sql = "update produto set ";
            sql += "descricao=?,";
            sql += "marca=?,";
            sql += "modelo=?,";
            sql += "percentualvenda=?,";
            sql += "precocompra=?,";
            sql += "precovenda=?";
            sql += "estoque=?";
            sql += " where idproduto=?";

            ps = connection.prepareStatement(sql);
            setDadosQuery(1);
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deletar(Object entidade) throws Exception {
        
        this.obj = (Produto) entidade;

        try {

            sql = "delete from produto where idProduto = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdProduto());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List getLista(ArrayList<Range> arrayRange) throws Exception {
        
        List<Produto> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from produto " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Produto();
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
        try {

            sql = "select * from produto where idProduto = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Produto();
                getDadosQuery();
            }
            return obj;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

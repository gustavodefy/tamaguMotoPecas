/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.mysql;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Fornecedor;
import br.com.tmgmotopeca.modelo.PCHeader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class DaoPCHeader implements Dao {

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
            ps.setDate(nx, (java.sql.Date) obj.getDtLcto());

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
            obj.setFornecedor((Fornecedor) daofornecedor.buscaUnica(rs.getInt("idFornecedor")));
            obj.setDtLcto(rs.getDate("dtLcto"));
            obj.setTotalPedido(rs.getDouble("totalPedido"));
            obj.setStatus(PCHeader.eStatus.valueOf(rs.getString("status")));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (PCHeader) entidade;
        this.newId = 0;
        
        try {
            
            sql = "insert into PCHeader (";
            sql += "fornecedor,";
            sql += "dtLcto,";
            sql += "totalPedido,";
            sql += "status";
            sql += ") values (?,?,?,?)";

            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

        this.obj = (PCHeader) entidade;

        try {
            sql = "update PCHeader set ";
            sql += "fornecedor=?,";
            sql += "dtLcto=?,";
            sql += "totalPedido=?,";
            sql += "status=?";
            sql += " where idPedido=?";

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

        this.obj = (PCHeader) entidade;

        try {

            sql = "delete from pcHeader where idPedido = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdPedido());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {

        List<PCHeader> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from pcHeader " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new PCHeader();
                getDadosQuery();
                lista.add(obj);
            }
            return lista.iterator();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Object buscaUnica(Integer id) throws Exception {
        try {

            sql = "select * from pcHeader where idPedido = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new PCHeader();
                getDadosQuery();
            }
            return obj;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

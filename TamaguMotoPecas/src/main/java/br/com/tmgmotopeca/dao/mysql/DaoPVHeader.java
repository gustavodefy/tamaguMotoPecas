/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.mysql;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.dao.Dao;
import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.PVHeader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class DaoPVHeader implements Dao {

    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private PVHeader obj;
    private int newId;

    public DaoPVHeader() {
        this.connection = Conexao.conectar();
    }

    private void setDadosQuery(int comId) throws Exception {

        int nx = 0;

        try {
            nx++;
            ps.setInt(nx, obj.getCliente().getIdCliente());

            nx++;
            ps.setDate(nx, (java.sql.Date) new java.sql.Date(obj.getDtLcto().getTime()));

            nx++;
            ps.setDouble(nx, obj.getTotalPedido());

            nx++;
            ps.setString(nx, String.valueOf(obj.getStatus()));

            nx++;
            ps.setString(nx, String.valueOf(obj.getFormaPgto()));
            
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
            DaoCliente daocliente = new DaoCliente();

            obj.setIdPedido(rs.getInt("idPedido"));
            obj.setCliente((Cliente) daocliente.buscaUnica(rs.getInt("idCliente")));
            obj.setDtLcto(rs.getDate("dtLcto"));
            obj.setTotalPedido(rs.getDouble("totalPedido"));
            obj.setStatus(PVHeader.eStatus.valueOf(rs.getString("status")));
            obj.setFormaPgto(PVHeader.eForma.valueOf(rs.getString("formapgto")));
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (PVHeader) entidade;
        this.newId = 0;

        try {

            sql = "insert into pvHeader (";
            sql += "idCliente,";
            sql += "dtLcto,";
            sql += "totalPedido,";
            sql += "status,";
            sql += "formapgto";
            sql += ") values (?,?,?,?,?)";

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

        this.obj = (PVHeader) entidade;

        try {
            sql = "update pvHeader set ";
            sql += "idCliente=?,";
            sql += "dtLcto=?,";
            sql += "totalPedido=?,";
            sql += "status=?,";
            sql += "formapgto=?";
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

        this.obj = (PVHeader) entidade;

        try {

            sql = "delete from pvHeader where idPedido = ?";
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

        List<PVHeader> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from pvHeader " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new PVHeader();
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

            sql = "select * from pvHeader where idPedido = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new PVHeader();
                getDadosQuery();
            }
            return obj;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

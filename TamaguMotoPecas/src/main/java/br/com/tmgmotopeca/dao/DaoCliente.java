/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 42
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.Cliente;
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
public class DaoCliente implements Dao {

    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Cliente obj;
    private int newId;

    public DaoCliente() {
        this.connection = Conexao.conectar();
    }

    private void setDadosQuery(int comId) throws Exception {

        int nx = 0;

        try {
            nx++;
            ps.setString(nx, obj.getNome());

            nx++;
            ps.setString(nx, obj.getCpf_cnpj());

            nx++;
            ps.setString(nx, obj.getLogradouro());

            nx++;
            ps.setString(nx, obj.getNumero());

            nx++;
            ps.setString(nx, obj.getComplemento());

            nx++;
            ps.setString(nx, obj.getCep());

            nx++;
            ps.setString(nx, obj.getBairro());

            nx++;
            ps.setString(nx, obj.getCidade());

            nx++;
            ps.setString(nx, obj.getEstado());

            nx++;
            ps.setString(nx, obj.getTelefone());

            nx++;
            ps.setString(nx, obj.getEmail());

            nx++;
            ps.setString(nx, obj.getContato());

            nx++;
            ps.setDouble(nx, obj.getLimiteCredito());

            nx++;
            ps.setString(nx, obj.getSenha());

            nx++;
            ps.setString(nx, obj.getPerfil());
            
            if (comId == 1) {
                //o id deve ser sempre o ultimo
                nx++;
                ps.setInt(nx, obj.getIdCliente());
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosQuery() throws Exception {

        try {
            obj.setIdCliente(rs.getInt("idCliente"));
            obj.setNome(rs.getString("nome"));
            obj.setCpf_cnpj(rs.getString("cpf_cnpj"));
            obj.setLogradouro(rs.getString("logradouro"));
            obj.setNumero(rs.getString("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setCep(rs.getString("cep"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setEstado(rs.getString("estado"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setEmail(rs.getString("email"));
            obj.setContato(rs.getString("contato"));
            obj.setLimiteCredito(rs.getDouble("limiteCredito"));
            obj.setSenha(rs.getString("senha"));
            obj.setPerfil(rs.getString("perfil"));
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (Cliente) entidade;
        this.newId = 0;

        try {

            sql = "insert into cliente (";
            sql += "nome,";
            sql += "cpf_cnpj,";
            sql += "logradouro,";
            sql += "numero,";
            sql += "complemento,";
            sql += "cep,";
            sql += "bairro,";
            sql += "cidade,";
            sql += "estado,";
            sql += "telefone,";
            sql += "email,";
            sql += "contato,";
            sql += "limiteCredito,";
            sql += "senha,";
            sql += "perfil";
            sql += ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

        this.obj = (Cliente) entidade;

        try {
            sql = "update cliente set ";
            sql += "nome=?,";
            sql += "cpf_cnpj=?,";
            sql += "logradouro=?,";
            sql += "numero=?,";
            sql += "complemento=?,";
            sql += "cep=?,";
            sql += "bairro=?,";
            sql += "cidade=?,";
            sql += "estado=?,";
            sql += "telefone=?,";
            sql += "email=?,";
            sql += "contato=?,";
            sql += "limiteCredito=?,";
            sql += "senha=?,";
            sql += "perfil=?";
            sql += " where idCliente=?";

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

        this.obj = (Cliente) entidade;

        try {

            sql = "delete from cliente where idCliente = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdCliente());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {

        List<Cliente> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from cliente " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Cliente();
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

            sql = "select * from cliente where idCliente = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Cliente();
                getDadosQuery();
            }
            return obj;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

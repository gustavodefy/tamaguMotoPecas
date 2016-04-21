/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public class DaoFornecedor implements Dao {

    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Fornecedor obj;
    private int newId;

    public DaoFornecedor() {
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

            //o id deve ser sempre o ultimo
            if (comId == 1) {
                nx++;
                ps.setInt(nx, obj.getIdFornecedor());
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosQuery() throws Exception {
        try {
            obj.setIdFornecedor(rs.getInt("idFornecedor"));
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
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (Fornecedor) obj;
        this.newId = 0;
        try {

            sql = "insert into fornecedor (";
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
            sql += "contato";
            sql += ") values (?,?,?,?,?,?,?,?,?,?,?,?)";

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
        
        this.obj = (Fornecedor) obj;

        try {
            sql = "update fornecedor set ";
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
            sql += "contato=?";
            sql += " where idfornecedor=?";

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

        this.obj = (Fornecedor) obj;

        try {

            sql = "delete from fornecedor where idFornecedor = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdFornecedor());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List getLista(ArrayList<Range> arrayRange) throws Exception {
        
        List<Fornecedor> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from fornecedor " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Fornecedor();
                getDadosQuery();
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }   
    }
}

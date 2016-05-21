/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Conexao;
import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.Contato;
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
public class DaoContato implements Dao{
    
    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private Contato obj;
    private int newId;
    
        public DaoContato(){
         this.connection = Conexao.conectar();
        }
    
        private void setDadosQuery(int comId) throws Exception {
            int nx = 0;
         try {
            nx++;
            ps.setString(nx, obj.getNome());

            nx++;
            ps.setString(nx, obj.getEmail());

            nx++;
            ps.setString(nx, obj.getAssunto());
            
            nx++;
            ps.setString(nx, obj.getTelefone());
            
            nx++;
            ps.setString(nx, obj.getMensagem());

            //o id deve ser sempre o ultimo
            if (comId == 1) {
                nx++;
                ps.setInt(nx, obj.getIdContato());
            }

            } catch (Exception e) {
             throw new Exception(e.getMessage());
            }
        }
        
         private void getDadosQuery() throws Exception {
        try {
            obj.setIdContato(rs.getInt("idContato"));
            obj.setNome(rs.getString("nome"));
            obj.setEmail(rs.getString("email"));
            obj.setAssunto(rs.getString("assunto"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setMensagem(rs.getString("mensagem"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public int inserir(Object entidade) throws Exception {

        this.obj = (Contato) entidade;
        this.newId = 0;
        
        try {
            
            sql = "insert into Contato (";
            sql += "nome,";
            sql += "email,";
            sql += "assunto,";
            sql += "telefone,";
            sql += "mensagem";
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

        this.obj = (Contato) entidade;

        try {
            sql = "update Contato set ";
            sql += "nome=?,";
            sql += "email=?,";
            sql += "assunto=?,";
            sql += "telefone=?";
            sql += "mensagem=?";
            sql += " where idContato=?";

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

        this.obj = (Contato) entidade;

        try {

            sql = "delete from contato where idContato = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, this.obj.getIdContato());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Iterator getLista(ArrayList<Range> arrayRange) throws Exception {

        List<Contato> lista = new ArrayList();

        try {

            String condicao = Range.RangeToString(arrayRange);

            sql = "select * from contato " + condicao;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Contato();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

/**
 *
 * @author Gustavo
 */
public class SelecionaDao {
    
    public enum ListaDaos{
        CLIENTE,
        FORNECEDOR,
        PCHEADER,
        PVHEADER,
        CONTATO,
        PRODUTO;
    }
    
    public static Dao Selecionar(ListaDaos entidadeDao){
    
      if(entidadeDao == ListaDaos.CLIENTE){
         return new DaoCliente();
        }
      
      if(entidadeDao == ListaDaos.FORNECEDOR){
          return  new DaoFornecedor();
        }
      
      if(entidadeDao == ListaDaos.PCHEADER){
          return  new DaoPCHeader();
        }
      
      if(entidadeDao == ListaDaos.PVHEADER){
          return new DaoPVHeader();
        }
      
      if(entidadeDao == ListaDaos.CONTATO){
          return new DaoContato();
      }
      
      if(entidadeDao == ListaDaos.PRODUTO){
          return new DaoProduto();
        }
      
      return null;
    }
}
     
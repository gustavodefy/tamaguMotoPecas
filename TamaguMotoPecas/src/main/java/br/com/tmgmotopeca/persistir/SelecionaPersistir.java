/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.Contato;
import br.com.tmgmotopeca.modelo.Fornecedor;
import br.com.tmgmotopeca.modelo.PedidoVenda;
import br.com.tmgmotopeca.modelo.Produto;

/**
 *
 * @author Gustavo
 */
public class SelecionaPersistir {
    
    public enum ListaPersistir{
        PCliente,
        PFornecedor,
        PProduto,
        PContato,
        PVenda;
    }
    
    public static Persistir Selecionar(ListaPersistir persistir ,Object entidade){
        
        if(persistir == ListaPersistir.PCliente){
            return new PersistirCliente((Cliente) entidade);
        }   
        if(persistir == ListaPersistir.PFornecedor){
            return new PersistirFornecedor((Fornecedor) entidade);
        }
        if(persistir == ListaPersistir.PProduto){
            return new PersistirProduto((Produto) entidade);
        }
        if(persistir == ListaPersistir.PContato){
            return new PersistirContato((Contato)entidade);
        }
        if(persistir == ListaPersistir.PVenda){
            return new PersistirVenda((PedidoVenda)entidade);
        }
        
        return null;
    }
}

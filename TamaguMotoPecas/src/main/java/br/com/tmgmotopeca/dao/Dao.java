/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.biblioteca.Range;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ResVUT42
 */
public interface Dao {

     //Inserir novo registro, retorna o código gerado
     public int  inserir(Object entidade) throws Exception;
     
     //Altera o registro referente
     public void alterar(Object entidade) throws Exception;
     
     //Deleta o registro referente
     public void deletar(Object entidade) throws Exception;

     //Retorna lista da seleção, se o range vier null, busca tudo
     public List getLista(ArrayList<Range> arrayRange) throws Exception;
              
}

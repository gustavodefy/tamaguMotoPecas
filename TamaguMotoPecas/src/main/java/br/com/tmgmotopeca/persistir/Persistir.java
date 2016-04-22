/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

import br.com.tmgmotopeca.biblioteca.Range;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ResVUT42
 */
public interface Persistir {
    
    //Resgata Entidade selecionada
    public Object getEntidade() throws Exception;
    
    //Seta uma Entidade para ser manipulada
    public void setEntidade(Object entidade) throws Exception;
    
    //Grava a Entidade que está atribuida retorna o id (Incluir ou Alterar)
    public int gravar() throws Exception;
    
    //Excluir a Entidade que está atribuida
    public void excluir() throws Exception;
    
    //Seta/Atribui uma Entidade selecionando no BD pela chave
    public void buscar(int id) throws Exception;
    
    //Validar as informações da entidade, esse metodo deve ser sempre executando
    //no metodo gravar, para validar os dados antes de efetuar a gravação
    //Tambem servirá para validar os dados sem precisar gravar
    public void validarInformacoes() throws Exception;
   
    //Retorna lista de Entidades, esse metodo não atribui nenhuma informação 
    //a classe, só executa e devolve a lista
    //Usar a Classe Range para montar a seleção
    //se vier null, irá buscar tudo
    public Iterator buscarLista(ArrayList<Range> arrayRange) throws Exception;
                
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.dao.elastic.DaoEsCliente;
import br.com.tmgmotopeca.dao.mysql.DaoProduto;
import br.com.tmgmotopeca.dao.mysql.DaoContato;
import br.com.tmgmotopeca.dao.mysql.DaoPVItem;
import br.com.tmgmotopeca.dao.mysql.DaoCliente;
import br.com.tmgmotopeca.dao.mysql.DaoPVHeader;
import br.com.tmgmotopeca.dao.mysql.DaoPCHeader;
import br.com.tmgmotopeca.dao.mysql.DaoFornecedor;
import br.com.tmgmotopeca.dao.mysql.DaoPCItem;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class SelecionaDao {

    public enum ListaDaos {
        CLIENTE,
        FORNECEDOR,
        PCHEADER,
        PCITEM,
        PVHEADER,
        PVITEM,
        CONTATO,
        PRODUTO;
    }

    public static Dao Selecionar(ListaDaos entidadeDao){

        if (entidadeDao == ListaDaos.CLIENTE) {
            try {
                return new DaoCliente();
                //return new DaoEsCliente();
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.FORNECEDOR) {
            return new DaoFornecedor();
        }

        if (entidadeDao == ListaDaos.PCHEADER) {
            return new DaoPCHeader();
        }

        if (entidadeDao == ListaDaos.PCITEM) {
            return new DaoPCItem();
        }

        if (entidadeDao == ListaDaos.PVHEADER) {
            return new DaoPVHeader();
        }

        if (entidadeDao == ListaDaos.PVITEM) {
            return new DaoPVItem();
        }

        if (entidadeDao == ListaDaos.CONTATO) {
            return new DaoContato();
        }

        if (entidadeDao == ListaDaos.PRODUTO) {
            return new DaoProduto();
        }

        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao;

import br.com.tmgmotopeca.dao.elastic.DaoEsCliente;
import br.com.tmgmotopeca.dao.elastic.DaoEsContato;
import br.com.tmgmotopeca.dao.elastic.DaoEsFornecedor;
import br.com.tmgmotopeca.dao.elastic.DaoEsPCHeader;
import br.com.tmgmotopeca.dao.elastic.DaoEsPCItem;
import br.com.tmgmotopeca.dao.elastic.DaoEsPVHeader;
import br.com.tmgmotopeca.dao.elastic.DaoEsPVItem;
import br.com.tmgmotopeca.dao.elastic.DaoEsProduto;
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

    public static Dao Selecionar(ListaDaos entidadeDao) {

        //String baseDados = "MYSQL";
        String baseDados = "ES";

        if (entidadeDao == ListaDaos.CLIENTE) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoCliente();
                } else {
                    return new DaoEsCliente();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.FORNECEDOR) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoFornecedor();
                } else {
                    return new DaoEsFornecedor();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (entidadeDao == ListaDaos.PCHEADER) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoPCHeader();
                } else {
                    return new DaoEsPCHeader();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.PCITEM) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoPCItem();
                } else {
                    return new DaoEsPCItem();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.PVHEADER) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoPVHeader();
                } else {
                    return new DaoEsPVHeader();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.PVITEM) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoPVItem();
                } else {
                    return new DaoEsPVItem();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.CONTATO) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoContato();
                } else {
                    return new DaoEsContato();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (entidadeDao == ListaDaos.PRODUTO) {
            try {
                if (baseDados.equals("MYSQL")) {
                    return new DaoProduto();
                } else {
                    return new DaoEsProduto();
                }
            } catch (Exception ex) {
                Logger.getLogger(SelecionaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
}

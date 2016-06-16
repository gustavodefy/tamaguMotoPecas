/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.mysql;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thayro
 */
public class DaoClienteTest {

    public DaoClienteTest() {
    }

    /**
     * Test of inserir method, of class DaoCliente.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Cliente cliente = new Cliente();
        DaoCliente instance = new DaoCliente();
        int result = instance.inserir(cliente);
        if (cliente != null) {
            System.out.println(result);
        }

    }

    /**
     * Test of alterar method, of class DaoCliente.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Cliente cliente = new Cliente();
        DaoCliente instance = new DaoCliente();
        instance.alterar(cliente);

        if (cliente == null) {
            System.out.println("Erro alterar Registro");
        } else {
            System.out.println("Registro Alterado");
        }

    }

    /**
     * Test of deletar method, of class DaoCliente.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        Cliente cliente = new Cliente();
        DaoCliente instance = new DaoCliente();
        instance.deletar(cliente);

        if (cliente == null) {
            System.out.println("Erro deletar Registro");
        } else {
            System.out.println("Registro deletado");
        }

    }

    /**
     * Test of getLista method, of class DaoCliente.
     */
    @Test
    public void testGetLista() throws Exception {
        System.out.println("getLista");
        ArrayList<Range> arrayRange = null;
        DaoCliente instance = new DaoCliente();
        Iterator expResult = null;
        Iterator result = instance.getLista(arrayRange);

        if (arrayRange != null) {
            assertEquals(expResult, result);
        } else {
            System.out.println("Erro buscar a lista");
        }

    }

    /**
     * Test of buscaUnica method, of class DaoCliente.
     */
    @Test
    public void testBuscaUnica() throws Exception {
        System.out.println("buscaUnica");
        Cliente cliente = new Cliente();
        DaoCliente instance = new DaoCliente();
        Object expResult = null;
        Object result = instance.buscaUnica(cliente.getIdCliente());

        if (result != null) {
            assertEquals(expResult, result);
        } else {
            System.out.println("Erro buscar a lista");
        }
    }
}

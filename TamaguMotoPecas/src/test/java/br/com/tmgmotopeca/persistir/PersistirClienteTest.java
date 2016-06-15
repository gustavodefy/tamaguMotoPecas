/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.persistir;

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
public class PersistirClienteTest {

    public PersistirClienteTest() {
    }

    /**
     * Test of getEntidade method, of class PersistirCliente.
     */
    @Test
    public void testGetEntidade() throws Exception {
        System.out.println("getEntidade");
        Cliente cliente = new Cliente();
        PersistirCliente instance = new PersistirCliente(cliente);
        Boolean expResult = null;
        if (instance.getEntidade() != null) {
            expResult = true;
        } else {
            expResult = false;
        }
        System.out.println(expResult);
    }

    /**
     * Test of setEntidade method, of class PersistirCliente.
     */
    @Test
    public void testSetEntidade() throws Exception {
        System.out.println("setEntidade");
        Cliente cliente = new Cliente();
        PersistirCliente instance = new PersistirCliente(cliente);
        instance.setEntidade(cliente);

    }

    /**
     * Test of gravar method, of class PersistirCliente.
     */
    @Test
    public void testGravar() throws Exception {
        System.out.println("gravar");
        Cliente cliente = new Cliente();
        PersistirCliente instance = new PersistirCliente(cliente);
        int expResult = 0;
        int result = instance.gravar();
        assertEquals(expResult, result);

    }

    /**
     * Test of excluir method, of class PersistirCliente.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        PersistirCliente instance = null;
        instance.excluir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class PersistirCliente.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 0;
        PersistirCliente instance = null;
        instance.buscar(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarInformacoes method, of class PersistirCliente.
     */
    @Test
    public void testValidarInformacoes() throws Exception {
        System.out.println("validarInformacoes");
        PersistirCliente instance = null;
        instance.validarInformacoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarLista method, of class PersistirCliente.
     */
    @Test
    public void testBuscarLista() throws Exception {
        System.out.println("buscarLista");
        ArrayList<Range> rangeCondicao = null;
        PersistirCliente instance = null;
        Iterator expResult = null;
        Iterator result = instance.buscarLista(rangeCondicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorEmail method, of class PersistirCliente.
     */
    @Test
    public void testBuscarPorEmail() throws Exception {
        System.out.println("buscarPorEmail");
        String email = "";
        PersistirCliente instance = null;
        Cliente expResult = null;
        Cliente result = instance.buscarPorEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autenticar method, of class PersistirCliente.
     */
    @Test
    public void testAutenticar() throws Exception {
        System.out.println("autenticar");
        PersistirCliente instance = null;
        instance.autenticar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

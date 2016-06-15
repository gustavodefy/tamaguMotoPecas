/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thayro
 */
public class PVHeaderTest {
    
    public PVHeaderTest() {
    }

    /**
     * Test of getIdPedido method, of class PVHeader.
     */
    @Test
    public void testGetIdPedido() {
        System.out.println("getIdPedido");
        PVHeader instance = new PVHeader();
        int expResult = 0;
        int result = instance.getIdPedido();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setIdPedido method, of class PVHeader.
     */
    @Test
    public void testSetIdPedido() {
        System.out.println("setIdPedido");
        int idPedido = 0;
        PVHeader instance = new PVHeader();
        instance.setIdPedido(idPedido);
        
        
    }

    /**
     * Test of getCliente method, of class PVHeader.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        PVHeader instance = new PVHeader();
        Cliente expResult = null;
        Cliente result = instance.getCliente();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCliente method, of class PVHeader.
     */
    @Test
    public void testSetCliente_Cliente() {
        System.out.println("setCliente");
        Cliente cliente = null;
        PVHeader instance = new PVHeader();
        instance.setCliente(cliente);
        
        
    }

    /**
     * Test of setCliente method, of class PVHeader.
     */
    @Test
    public void testSetCliente_int() throws Exception {
        System.out.println("setCliente");
        int idCliente = 0;
        PVHeader instance = new PVHeader();
        instance.setCliente(idCliente);
        
        
    }

    /**
     * Test of getDtLcto method, of class PVHeader.
     */
    @Test
    public void testGetDtLcto() {
        System.out.println("getDtLcto");
        PVHeader instance = new PVHeader();
        Date expResult = null;
        Date result = instance.getDtLcto();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDtLcto method, of class PVHeader.
     */
    @Test
    public void testSetDtLcto() {
        System.out.println("setDtLcto");
        Date dtLcto = null;
        PVHeader instance = new PVHeader();
        instance.setDtLcto(dtLcto);
        
        
    }

    /**
     * Test of getTotalPedido method, of class PVHeader.
     */
    @Test
    public void testGetTotalPedido() {
        System.out.println("getTotalPedido");
        PVHeader instance = new PVHeader();
        double expResult = 0.0;
        double result = instance.getTotalPedido();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setTotalPedido method, of class PVHeader.
     */
    @Test
    public void testSetTotalPedido() {
        System.out.println("setTotalPedido");
        double totalPedido = 0.0;
        PVHeader instance = new PVHeader();
        instance.setTotalPedido(totalPedido);
        
        
    }

    /**
     * Test of getStatus method, of class PVHeader.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        PVHeader instance = new PVHeader();
        PVHeader.eStatus expResult = null;
        PVHeader.eStatus result = instance.getStatus();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setStatus method, of class PVHeader.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        PVHeader.eStatus status = null;
        PVHeader instance = new PVHeader();
        instance.setStatus(status);
        
        
    }

    /**
     * Test of getFormaPgto method, of class PVHeader.
     */
    @Test
    public void testGetFormaPgto() {
        System.out.println("getFormaPgto");
        PVHeader instance = new PVHeader();
        PVHeader.eForma expResult = null;
        PVHeader.eForma result = instance.getFormaPgto();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setFormaPgto method, of class PVHeader.
     */
    @Test
    public void testSetFormaPgto() {
        System.out.println("setFormaPgto");
        PVHeader.eForma formaPgto = null;
        PVHeader instance = new PVHeader();
        instance.setFormaPgto(formaPgto);
        
        
    }
    
}

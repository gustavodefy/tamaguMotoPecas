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
public class PCHeaderTest {
    
    public PCHeaderTest() {
    }

    /**
     * Test of getIdPedido method, of class PCHeader.
     */
    @Test
    public void testGetIdPedido() {
        System.out.println("getIdPedido");
        PCHeader instance = new PCHeader();
        int expResult = 0;
        int result = instance.getIdPedido();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setIdPedido method, of class PCHeader.
     */
    @Test
    public void testSetIdPedido() {
        System.out.println("setIdPedido");
        int idPedido = 0;
        PCHeader instance = new PCHeader();
        instance.setIdPedido(idPedido);
        
        
    }

    /**
     * Test of getFornecedor method, of class PCHeader.
     */
    @Test
    public void testGetFornecedor() {
        System.out.println("getFornecedor");
        PCHeader instance = new PCHeader();
        Fornecedor expResult = null;
        Fornecedor result = instance.getFornecedor();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setFornecedor method, of class PCHeader.
     */
    @Test
    public void testSetFornecedor_Fornecedor() {
        System.out.println("setFornecedor");
        Fornecedor fornecedor = null;
        PCHeader instance = new PCHeader();
        instance.setFornecedor(fornecedor);
        
        
    }

    /**
     * Test of setFornecedor method, of class PCHeader.
     */
    @Test
    public void testSetFornecedor_int() throws Exception {
        System.out.println("setFornecedor");
        int idFornecedor = 0;
        PCHeader instance = new PCHeader();
        instance.setFornecedor(idFornecedor);
        
        
    }

    /**
     * Test of getDtLcto method, of class PCHeader.
     */
    @Test
    public void testGetDtLcto() {
        System.out.println("getDtLcto");
        PCHeader instance = new PCHeader();
        Date expResult = null;
        Date result = instance.getDtLcto();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDtLcto method, of class PCHeader.
     */
    @Test
    public void testSetDtLcto() {
        System.out.println("setDtLcto");
        Date dtLcto = null;
        PCHeader instance = new PCHeader();
        instance.setDtLcto(dtLcto);
        
        
    }

    /**
     * Test of getTotalPedido method, of class PCHeader.
     */
    @Test
    public void testGetTotalPedido() {
        System.out.println("getTotalPedido");
        PCHeader instance = new PCHeader();
        double expResult = 0.0;
        double result = instance.getTotalPedido();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setTotalPedido method, of class PCHeader.
     */
    @Test
    public void testSetTotalPedido() {
        System.out.println("setTotalPedido");
        double totalPedido = 0.0;
        PCHeader instance = new PCHeader();
        instance.setTotalPedido(totalPedido);
        
        
    }

    /**
     * Test of getStatus method, of class PCHeader.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        PCHeader instance = new PCHeader();
        PCHeader.eStatus expResult = null;
        PCHeader.eStatus result = instance.getStatus();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setStatus method, of class PCHeader.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        PCHeader.eStatus status = null;
        PCHeader instance = new PCHeader();
        instance.setStatus(status);
        
        
    }
    
}

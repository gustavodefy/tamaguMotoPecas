/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thayro
 */
public class PVItemTest {
    
    public PVItemTest() {
    }

    /**
     * Test of getIdPedido method, of class PVItem.
     */
    @Test
    public void testGetIdPedido() {
        System.out.println("getIdPedido");
        PVItem instance = new PVItem();
        int expResult = 0;
        int result = instance.getIdPedido();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setIdPedido method, of class PVItem.
     */
    @Test
    public void testSetIdPedido() {
        System.out.println("setIdPedido");
        int idPedido = 0;
        PVItem instance = new PVItem();
        instance.setIdPedido(idPedido);
        
        
    }

    /**
     * Test of getProduto method, of class PVItem.
     */
    @Test
    public void testGetProduto() {
        System.out.println("getProduto");
        PVItem instance = new PVItem();
        Produto expResult = null;
        Produto result = instance.getProduto();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setProduto method, of class PVItem.
     */
    @Test
    public void testSetProduto_Produto() {
        System.out.println("setProduto");
        Produto produto = null;
        PVItem instance = new PVItem();
        instance.setProduto(produto);
        
        
    }

    /**
     * Test of setProduto method, of class PVItem.
     */
    @Test
    public void testSetProduto_int() throws Exception {
        System.out.println("setProduto");
        int idProduto = 0;
        PVItem instance = new PVItem();
        instance.setProduto(idProduto);
        
        
    }

    /**
     * Test of getQuantidade method, of class PVItem.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        PVItem instance = new PVItem();
        double expResult = 0.0;
        double result = instance.getQuantidade();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setQuantidade method, of class PVItem.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        double quantidade = 0.0;
        PVItem instance = new PVItem();
        instance.setQuantidade(quantidade);
        
        
    }

    /**
     * Test of getVlrUnitario method, of class PVItem.
     */
    @Test
    public void testGetVlrUnitario() {
        System.out.println("getVlrUnitario");
        PVItem instance = new PVItem();
        double expResult = 0.0;
        double result = instance.getVlrUnitario();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setVlrUnitario method, of class PVItem.
     */
    @Test
    public void testSetVlrUnitario() {
        System.out.println("setVlrUnitario");
        double vlrUnitario = 0.0;
        PVItem instance = new PVItem();
        instance.setVlrUnitario(vlrUnitario);
        
        
    }

    /**
     * Test of getVlrTotal method, of class PVItem.
     */
    @Test
    public void testGetVlrTotal() {
        System.out.println("getVlrTotal");
        PVItem instance = new PVItem();
        double expResult = 0.0;
        double result = instance.getVlrTotal();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setVlrTotal method, of class PVItem.
     */
    @Test
    public void testSetVlrTotal() {
        System.out.println("setVlrTotal");
        double vlrTotal = 0.0;
        PVItem instance = new PVItem();
        instance.setVlrTotal(vlrTotal);
        
        
    }
    
}

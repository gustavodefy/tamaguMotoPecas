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
public class PCItemTest {
    
    public PCItemTest() {
    }

    /**
     * Test of getIdPedido method, of class PCItem.
     */
    @Test
    public void testGetIdPedido() {
        System.out.println("getIdPedido");
        PCItem instance = new PCItem();
        int expResult = 0;
        int result = instance.getIdPedido();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setIdPedido method, of class PCItem.
     */
    @Test
    public void testSetIdPedido() {
        System.out.println("setIdPedido");
        int idPedido = 0;
        PCItem instance = new PCItem();
        instance.setIdPedido(idPedido);
        
        
    }

    /**
     * Test of getProduto method, of class PCItem.
     */
    @Test
    public void testGetProduto() {
        System.out.println("getProduto");
        PCItem instance = new PCItem();
        Produto expResult = null;
        Produto result = instance.getProduto();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setProduto method, of class PCItem.
     */
    @Test
    public void testSetProduto_Produto() {
        System.out.println("setProduto");
        Produto produto = null;
        PCItem instance = new PCItem();
        instance.setProduto(produto);
        
        
    }

    /**
     * Test of setProduto method, of class PCItem.
     */
    @Test
    public void testSetProduto_int() throws Exception {
        System.out.println("setProduto");
        int idProduto = 0;
        PCItem instance = new PCItem();
        instance.setProduto(idProduto);
        
        
    }

    /**
     * Test of getQuantidade method, of class PCItem.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        PCItem instance = new PCItem();
        double expResult = 0.0;
        double result = instance.getQuantidade();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setQuantidade method, of class PCItem.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        double quantidade = 0.0;
        PCItem instance = new PCItem();
        instance.setQuantidade(quantidade);
        
        
    }

    /**
     * Test of getVlrUnitario method, of class PCItem.
     */
    @Test
    public void testGetVlrUnitario() {
        System.out.println("getVlrUnitario");
        PCItem instance = new PCItem();
        double expResult = 0.0;
        double result = instance.getVlrUnitario();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setVlrUnitario method, of class PCItem.
     */
    @Test
    public void testSetVlrUnitario() {
        System.out.println("setVlrUnitario");
        double vlrUnitario = 0.0;
        PCItem instance = new PCItem();
        instance.setVlrUnitario(vlrUnitario);
        
        
    }

    /**
     * Test of getVlrTotal method, of class PCItem.
     */
    @Test
    public void testGetVlrTotal() {
        System.out.println("getVlrTotal");
        PCItem instance = new PCItem();
        double expResult = 0.0;
        double result = instance.getVlrTotal();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setVlrTotal method, of class PCItem.
     */
    @Test
    public void testSetVlrTotal() {
        System.out.println("setVlrTotal");
        double vlrTotal = 0.0;
        PCItem instance = new PCItem();
        instance.setVlrTotal(vlrTotal);
        
        
    }
    
}

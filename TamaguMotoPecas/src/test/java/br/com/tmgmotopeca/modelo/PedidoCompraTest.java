/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thayro
 */
public class PedidoCompraTest {
    
    public PedidoCompraTest() {
    }

    /**
     * Test of getPCHeader method, of class PedidoCompra.
     */
    @Test
    public void testGetPCHeader() {
        System.out.println("getPCHeader");
        PedidoCompra instance = new PedidoCompra();
        PCHeader expResult = null;
        PCHeader result = instance.getPCHeader();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setPCHeader method, of class PedidoCompra.
     */
    @Test
    public void testSetPCHeader() {
        System.out.println("setPCHeader");
        PCHeader pcHeader = null;
        PedidoCompra instance = new PedidoCompra();
        instance.setPCHeader(pcHeader);
        
        
    }

    /**
     * Test of getItens method, of class PedidoCompra.
     */
    @Test
    public void testGetItens() {
        System.out.println("getItens");
        PedidoCompra instance = new PedidoCompra();
        Iterator<PCItem> expResult = null;
        Iterator<PCItem> result = instance.getItens();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setItens method, of class PedidoCompra.
     */
    @Test
    public void testSetItens() {
        System.out.println("setItens");
        ArrayList<PCItem> item = null;
        PedidoCompra instance = new PedidoCompra();
        instance.setItens(item);
        
        
    }

    /**
     * Test of addPCItem method, of class PedidoCompra.
     */
    @Test
    public void testAddPCItem() {
        System.out.println("addPCItem");
        PCItem pcItem = null;
        PedidoCompra instance = new PedidoCompra();
        instance.addPCItem(pcItem);
        
        
    }
    
}

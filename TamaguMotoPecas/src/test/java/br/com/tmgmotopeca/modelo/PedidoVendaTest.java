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
public class PedidoVendaTest {
    
    public PedidoVendaTest() {
    }

    /**
     * Test of getHeader method, of class PedidoVenda.
     */
    @Test
    public void testGetHeader() {
        System.out.println("getHeader");
        PedidoVenda instance = new PedidoVenda();
        PVHeader expResult = null;
        PVHeader result = instance.getHeader();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setHeader method, of class PedidoVenda.
     */
    @Test
    public void testSetHeader() {
        System.out.println("setHeader");
        PVHeader header = null;
        PedidoVenda instance = new PedidoVenda();
        instance.setHeader(header);
        
        
    }

    /**
     * Test of getItens method, of class PedidoVenda.
     */
    @Test
    public void testGetItens() {
        System.out.println("getItens");
        PedidoVenda instance = new PedidoVenda();
        Iterator<PVItem> expResult = null;
        Iterator<PVItem> result = instance.getItens();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setItens method, of class PedidoVenda.
     */
    @Test
    public void testSetItens() {
        System.out.println("setItens");
        ArrayList<PVItem> item = null;
        PedidoVenda instance = new PedidoVenda();
        instance.setItens(item);
        
        
    }

    /**
     * Test of addItem method, of class PedidoVenda.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        PVItem item = null;
        PedidoVenda instance = new PedidoVenda();
        instance.addItem(item);
        
        
    }
    
}

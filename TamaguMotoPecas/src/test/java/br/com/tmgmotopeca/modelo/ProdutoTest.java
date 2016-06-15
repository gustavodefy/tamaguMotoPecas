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
public class ProdutoTest {
    
    public ProdutoTest() {
    }

    /**
     * Test of getIdProduto method, of class Produto.
     */
    @Test
    public void testGetIdProduto() {
        System.out.println("getIdProduto");
        Produto instance = new Produto();
        int expResult = 0;
        int result = instance.getIdProduto();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setIdProduto method, of class Produto.
     */
    @Test
    public void testSetIdProduto() {
        System.out.println("setIdProduto");
        int idProduto = 0;
        Produto instance = new Produto();
        instance.setIdProduto(idProduto);
        
        
    }

    /**
     * Test of getDescricao method, of class Produto.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Produto instance = new Produto();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDescricao method, of class Produto.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Produto instance = new Produto();
        instance.setDescricao(descricao);
        
        
    }

    /**
     * Test of getMarca method, of class Produto.
     */
    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        Produto instance = new Produto();
        String expResult = "";
        String result = instance.getMarca();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setMarca method, of class Produto.
     */
    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        String marca = "";
        Produto instance = new Produto();
        instance.setMarca(marca);
        
        
    }

    /**
     * Test of getModelo method, of class Produto.
     */
    @Test
    public void testGetModelo() {
        System.out.println("getModelo");
        Produto instance = new Produto();
        String expResult = "";
        String result = instance.getModelo();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setModelo method, of class Produto.
     */
    @Test
    public void testSetModelo() {
        System.out.println("setModelo");
        String modelo = "";
        Produto instance = new Produto();
        instance.setModelo(modelo);
        
        
    }

    /**
     * Test of getPercentualVenda method, of class Produto.
     */
    @Test
    public void testGetPercentualVenda() {
        System.out.println("getPercentualVenda");
        Produto instance = new Produto();
        double expResult = 0.0;
        double result = instance.getPercentualVenda();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setPercentualVenda method, of class Produto.
     */
    @Test
    public void testSetPercentualVenda() {
        System.out.println("setPercentualVenda");
        double percentualVenda = 0.0;
        Produto instance = new Produto();
        instance.setPercentualVenda(percentualVenda);
        
        
    }

    /**
     * Test of getPrecoCompra method, of class Produto.
     */
    @Test
    public void testGetPrecoCompra() {
        System.out.println("getPrecoCompra");
        Produto instance = new Produto();
        double expResult = 0.0;
        double result = instance.getPrecoCompra();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setPrecoCompra method, of class Produto.
     */
    @Test
    public void testSetPrecoCompra() {
        System.out.println("setPrecoCompra");
        double precoCompra = 0.0;
        Produto instance = new Produto();
        instance.setPrecoCompra(precoCompra);
        
        
    }

    /**
     * Test of getPrecoVenda method, of class Produto.
     */
    @Test
    public void testGetPrecoVenda() {
        System.out.println("getPrecoVenda");
        Produto instance = new Produto();
        double expResult = 0.0;
        double result = instance.getPrecoVenda();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setPrecoVenda method, of class Produto.
     */
    @Test
    public void testSetPrecoVenda() {
        System.out.println("setPrecoVenda");
        double precoVenda = 0.0;
        Produto instance = new Produto();
        instance.setPrecoVenda(precoVenda);
        
        
    }

    /**
     * Test of getEstoque method, of class Produto.
     */
    @Test
    public void testGetEstoque() {
        System.out.println("getEstoque");
        Produto instance = new Produto();
        double expResult = 0.0;
        double result = instance.getEstoque();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setEstoque method, of class Produto.
     */
    @Test
    public void testSetEstoque() {
        System.out.println("setEstoque");
        double estoque = 0.0;
        Produto instance = new Produto();
        instance.setEstoque(estoque);
        
        
    }

    /**
     * Test of consomeEstoque method, of class Produto.
     */
    @Test
    public void testConsomeEstoque() {
        System.out.println("consomeEstoque");
        double quantidade = 0.0;
        Produto instance = new Produto();
        instance.consomeEstoque(quantidade);
        
        
    }

    /**
     * Test of somaEstoque method, of class Produto.
     */
    @Test
    public void testSomaEstoque() {
        System.out.println("somaEstoque");
        double quantidade = 0.0;
        Produto instance = new Produto();
        instance.somaEstoque(quantidade);
        
        
    }
    
}

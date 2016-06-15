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
public class ClienteTest {
    
    public ClienteTest() {
    }

    /**
     * Test of getIdCliente method, of class Cliente.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Cliente instance = new Cliente();
        int expResult = 0;
        int result = instance.getIdCliente();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIdCliente method, of class Cliente.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 0;
        Cliente instance = new Cliente();
        instance.setIdCliente(idCliente);

    }

    /**
     * Test of getNome method, of class Cliente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setNome method, of class Cliente.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Cliente instance = new Cliente();
        instance.setNome(nome);
        
        
    }

    /**
     * Test of getCpf_cnpj method, of class Cliente.
     */
    @Test
    public void testGetCpf_cnpj() {
        System.out.println("getCpf_cnpj");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCpf_cnpj();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCpf_cnpjMask method, of class Cliente.
     */
    @Test
    public void testGetCpf_cnpjMask() {
        System.out.println("getCpf_cnpjMask");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCpf_cnpjMask();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCpf_cnpj method, of class Cliente.
     */
    @Test
    public void testSetCpf_cnpj() {
        System.out.println("setCpf_cnpj");
        String cpf_cnpj = "";
        Cliente instance = new Cliente();
        instance.setCpf_cnpj(cpf_cnpj);
        
        
    }

    /**
     * Test of getLogradouro method, of class Cliente.
     */
    @Test
    public void testGetLogradouro() {
        System.out.println("getLogradouro");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getLogradouro();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setLogradouro method, of class Cliente.
     */
    @Test
    public void testSetLogradouro() {
        System.out.println("setLogradouro");
        String lagradouro = "";
        Cliente instance = new Cliente();
        instance.setLogradouro(lagradouro);
        
        
    }

    /**
     * Test of getNumero method, of class Cliente.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setNumero method, of class Cliente.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "";
        Cliente instance = new Cliente();
        instance.setNumero(numero);
        
        
    }

    /**
     * Test of getComplemento method, of class Cliente.
     */
    @Test
    public void testGetComplemento() {
        System.out.println("getComplemento");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getComplemento();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setComplemento method, of class Cliente.
     */
    @Test
    public void testSetComplemento() {
        System.out.println("setComplemento");
        String complemento = "";
        Cliente instance = new Cliente();
        instance.setComplemento(complemento);
        
        
    }

    /**
     * Test of getCep method, of class Cliente.
     */
    @Test
    public void testGetCep() {
        System.out.println("getCep");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCep();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCep method, of class Cliente.
     */
    @Test
    public void testSetCep() {
        System.out.println("setCep");
        String cep = "";
        Cliente instance = new Cliente();
        instance.setCep(cep);
        
        
    }

    /**
     * Test of getBairro method, of class Cliente.
     */
    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getBairro();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setBairro method, of class Cliente.
     */
    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Cliente instance = new Cliente();
        instance.setBairro(bairro);
        
        
    }

    /**
     * Test of getCidade method, of class Cliente.
     */
    @Test
    public void testGetCidade() {
        System.out.println("getCidade");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCidade();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCidade method, of class Cliente.
     */
    @Test
    public void testSetCidade() {
        System.out.println("setCidade");
        String cidade = "";
        Cliente instance = new Cliente();
        instance.setCidade(cidade);
        
        
    }

    /**
     * Test of getEstado method, of class Cliente.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setEstado method, of class Cliente.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Cliente instance = new Cliente();
        instance.setEstado(estado);
        
        
    }

    /**
     * Test of getTelefone method, of class Cliente.
     */
    @Test
    public void testGetTelefone() {
        System.out.println("getTelefone");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getTelefone();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setTelefone method, of class Cliente.
     */
    @Test
    public void testSetTelefone() {
        System.out.println("setTelefone");
        String telefone = "";
        Cliente instance = new Cliente();
        instance.setTelefone(telefone);
        
        
    }

    /**
     * Test of getEmail method, of class Cliente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setEmail method, of class Cliente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Cliente instance = new Cliente();
        instance.setEmail(email);
        
        
    }

    /**
     * Test of getContato method, of class Cliente.
     */
    @Test
    public void testGetContato() {
        System.out.println("getContato");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getContato();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setContato method, of class Cliente.
     */
    @Test
    public void testSetContato() {
        System.out.println("setContato");
        String contato = "";
        Cliente instance = new Cliente();
        instance.setContato(contato);
        
        
    }

    /**
     * Test of getLimiteCredito method, of class Cliente.
     */
    @Test
    public void testGetLimiteCredito() {
        System.out.println("getLimiteCredito");
        Cliente instance = new Cliente();
        double expResult = 0.0;
        double result = instance.getLimiteCredito();
        assertEquals(expResult, result, 0.0);
        
        
    }

    /**
     * Test of setLimiteCredito method, of class Cliente.
     */
    @Test
    public void testSetLimiteCredito() {
        System.out.println("setLimiteCredito");
        double limiteCredito = 0.0;
        Cliente instance = new Cliente();
        instance.setLimiteCredito(limiteCredito);
        
        
    }

    /**
     * Test of getSenha method, of class Cliente.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setSenha method, of class Cliente.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "";
        Cliente instance = new Cliente();
        instance.setSenha(senha);
        
        
    }

    /**
     * Test of getPerfil method, of class Cliente.
     */
    @Test
    public void testGetPerfil() {
        System.out.println("getPerfil");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getPerfil();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setPerfil method, of class Cliente.
     */
    @Test
    public void testSetPerfil() {
        System.out.println("setPerfil");
        String perfil = "";
        Cliente instance = new Cliente();
        instance.setPerfil(perfil);
        
        
    }
    
}

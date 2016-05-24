/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.PVHeader;
import br.com.tmgmotopeca.modelo.PVItem;
import br.com.tmgmotopeca.modelo.Produto;
import br.com.tmgmotopeca.persistir.PersistirProduto;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ResVUT42
 */
@WebServlet(name = "ServletCarrinho", urlPatterns = {"/ServletCarrinho"})
public class ServletCarrinho extends HttpServlet {

    private PVHeader pvHeader;
    private PVItem pvItem;
    private Cliente cliente;
    
    private String destino = "";
    private static String PRODUTO = "./subPaginas/cadastroProdutos.jsp";
    private static String CARRINHO = "./subPaginas/carrinho.jsp";
    private static String PRINCIPAL = "./index.jsp";

    private String tabela = "tabProduto";
    private String linha = "linProduto";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Busca a sessão ativa
        HttpSession sessao = request.getSession();
        cliente = (Cliente) sessao.getAttribute("sessaoCliente");

        request.setAttribute("toservlet", "ServletCatalogo");

        if (cliente != null && cliente.getPerfil().equals("C")) {

            String action;
            action = request.getParameter("action");

            if (action.equals("listar")) {

                //Busca os itens na sessão do cliente
                ArrayList listaCarrinho = (ArrayList) sessao.getAttribute("listaCarrinho");
                if (listaCarrinho == null || listaCarrinho.isEmpty()) {

                    request.setAttribute("mensagem", "Nenhum item no carrinho!");
                    destino = PRINCIPAL;                    
                    
                } else {
                    
                    
                    double totalPedido = calculaTotal(listaCarrinho.iterator());
                    request.setAttribute(tabela, listaCarrinho);
                    request.setAttribute("totalPedido", totalPedido);
                    destino = CARRINHO;
                    
                }

            } else if (action.equals("editar")) {

                try {
                    //Busca o codigo do produto na tela
                    int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                    //Busca o registro selecionado no banco
                    Produto produto = new Produto();
                    PersistirProduto persistirProduto = (PersistirProduto) SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PProduto, produto);
                    persistirProduto.buscar(idProduto);
                    produto = (Produto) persistirProduto.getEntidade();

                    //Seta atributo na tela
                    request.setAttribute(linha, produto);

                    //Direciona para alterar o registro
                    request.setAttribute("gravar", "false");
                    request.setAttribute("excluir", "false");
                    destino = PRODUTO;

                } catch (Exception e) {
                    request.setAttribute("mensagem", e.getMessage());
                    destino = PRINCIPAL;
                }

            } else if (action.equals("remover")) {

                //Busca os itens na sessão do cliente
                ArrayList listaCarrinho = (ArrayList) sessao.getAttribute("listaCarrinho");
                if (!listaCarrinho.isEmpty()) {

                    int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                    for (int i = 0; i < listaCarrinho.size(); i++) {

                        PVItem item = (PVItem) listaCarrinho.get(i);

                        if (item.getProduto().getIdProduto() == idProduto) {
                            listaCarrinho.remove(i);
                        }

                    }

                    if (listaCarrinho.isEmpty()) {
                        
                        sessao.setAttribute("listaCarrinho", null);
                        sessao.setAttribute("qtdItCar", 0);
                        request.setAttribute("mensagem", "Nenhum item no carrinho!");
                        destino = PRINCIPAL;
                        
                    } else {
                        
                        double totalPedido = calculaTotal(listaCarrinho.iterator());
                        request.setAttribute("totalPedido", totalPedido);
                        
                        sessao.setAttribute("listaCarrinho", listaCarrinho);
                        sessao.setAttribute("qtdItCar", listaCarrinho.size());
                        request.setAttribute(tabela, listaCarrinho);
                        destino = CARRINHO;
                        
                    }
                    

                } else {
                    request.setAttribute("mensagem", "Nenhum item no carrinho!");
                    destino = PRINCIPAL;
                }
                
            } else if(action.equals("finalizarCompra")){
                
                try {
                    
                    montaPVHeader();
                    
                } catch (Exception e) {
                    request.setAttribute("mensagem", "Nenhum item no carrinho!");
                    destino = PRINCIPAL;                    
                }
                
            }

        } else {
            request.setAttribute("mensagem", "Necessário fazer o login!");
            destino = PRINCIPAL;
        }

        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);
    }
    
    private double calculaTotal(Iterator lista){
        
        double valorTotal=0;
        
        while(lista.hasNext()){
            PVItem item = (PVItem) lista.next();
            valorTotal = valorTotal + item.getVlrTotal();
        }
        return valorTotal;
    }
    
    private void montaPVHeader(){
        pvHeader = new PVHeader();
        pvHeader.setCliente(cliente);
        pvHeader.setDtLcto(new Date());
        pvHeader.setStatus(PVHeader.eStatus.ABERTO);
        pvHeader.setTotalPedido(0);        
    }
    

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

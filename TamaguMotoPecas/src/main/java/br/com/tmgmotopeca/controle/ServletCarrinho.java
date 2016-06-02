/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.PVHeader;
import br.com.tmgmotopeca.modelo.PVHeader.eForma;
import br.com.tmgmotopeca.modelo.PVItem;
import br.com.tmgmotopeca.modelo.PedidoVenda;
import br.com.tmgmotopeca.modelo.Produto;
import br.com.tmgmotopeca.persistir.PersistirProduto;
import br.com.tmgmotopeca.persistir.PersistirVenda;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import br.com.tmgmotopeca.persistir.SelecionaPersistir.ListaPersistir;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
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

    private PedidoVenda pedidoVenda;
    private PVHeader pvHeader;
    private PVItem pvItem;
    private Cliente cliente;

    private String destino = "";
    private static String PRODUTO   = "./subPaginas/cadastroProdutos.jsp";
    private static String CARRINHO  = "./subPaginas/carrinho.jsp";
    private static String PRINCIPAL = "./index.jsp";

    private String tabela = "tabProduto";
    private String linha = "linProduto";

    private HttpServletRequest lRequest;
    private HttpServletResponse lResponse;

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

        lRequest = request;
        lResponse = response;

        //Busca a sessão ativa
        HttpSession sessao = lRequest.getSession();
        cliente = (Cliente) sessao.getAttribute("sessaoCliente");

        lRequest.setAttribute("toservlet", "ServletCatalogo");

        if (cliente != null && cliente.getPerfil().equals("C")) {

            String action;
            action = lRequest.getParameter("action");

            if (action.equals("listar")) {

                //Busca os itens na sessão do cliente
                ArrayList listaCarrinho = (ArrayList) sessao.getAttribute("listaCarrinho");
                if (listaCarrinho == null || listaCarrinho.isEmpty()) {

                    lRequest.setAttribute("mensagem", "Nenhum item no carrinho!");
                    destino = PRINCIPAL;

                } else {

                    double totalPedido = calculaTotal(listaCarrinho.iterator());
                    lRequest.setAttribute(tabela, listaCarrinho);
                    lRequest.setAttribute("totalPedido", totalPedido);
                    destino = CARRINHO;

                }

            } else if (action.equals("editar")) {

                try {
                    //Busca o codigo do produto na tela
                    int idProduto = Integer.parseInt(lRequest.getParameter("idProduto"));

                    //Busca o registro selecionado no banco
                    Produto produto = new Produto();
                    PersistirProduto persistirProduto = (PersistirProduto) SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PProduto, produto);
                    persistirProduto.buscar(idProduto);
                    produto = (Produto) persistirProduto.getEntidade();

                    //Seta atributo na tela
                    lRequest.setAttribute(linha, produto);

                    //Direciona para alterar o registro
                    lRequest.setAttribute("gravar", "false");
                    lRequest.setAttribute("excluir", "false");
                    destino = PRODUTO;

                } catch (Exception e) {
                    lRequest.setAttribute("mensagem", e.getMessage());
                    destino = PRINCIPAL;
                }

            } else if (action.equals("remover")) {

                //Busca os itens na sessão do cliente
                ArrayList listaCarrinho = (ArrayList) sessao.getAttribute("listaCarrinho");
                if (!listaCarrinho.isEmpty()) {

                    int idProduto = Integer.parseInt(lRequest.getParameter("idProduto"));

                    for (int i = 0; i < listaCarrinho.size(); i++) {

                        PVItem item = (PVItem) listaCarrinho.get(i);

                        if (item.getProduto().getIdProduto() == idProduto) {
                            listaCarrinho.remove(i);
                        }

                    }

                    if (listaCarrinho.isEmpty()) {

                        sessao.setAttribute("listaCarrinho", null);
                        sessao.setAttribute("qtdItCar", 0);
                        lRequest.setAttribute("mensagem", "Nenhum item no carrinho!");
                        destino = PRINCIPAL;

                    } else {

                        double totalPedido = calculaTotal(listaCarrinho.iterator());
                        lRequest.setAttribute("totalPedido", totalPedido);

                        sessao.setAttribute("listaCarrinho", listaCarrinho);
                        sessao.setAttribute("qtdItCar", listaCarrinho.size());
                        lRequest.setAttribute(tabela, listaCarrinho);
                        destino = CARRINHO;

                    }

                } else {
                    lRequest.setAttribute("mensagem", "Nenhum item no carrinho!");
                    destino = PRINCIPAL;
                }

            } else if (action.equals("finalizarCompra")) {

                try {

                    pedidoVenda = new PedidoVenda();
                    montaPVHeader();
                    montaPVItem();
                    
                    PersistirVenda persistirVenda = (PersistirVenda) SelecionaPersistir.Selecionar(ListaPersistir.PVenda,pedidoVenda);                    
                    int idpedido = persistirVenda.gravar();      
                    sessao.setAttribute("listaCarrinho", null);
                    sessao.setAttribute("qtdItCar", 0);                    
                    lRequest.setAttribute("mensagem", "Pedido "+ idpedido +" criado com sucesso!");
                    destino = PRINCIPAL;
                    
                } catch (Exception e) {
                    lRequest.setAttribute("mensagem", "Nenhum item no carrinho!");
                    destino = PRINCIPAL;
                }

            }

        } else {
            lRequest.setAttribute("mensagem", "Necessário fazer o login!");
            destino = PRINCIPAL;
        }

        RequestDispatcher view = lRequest.getRequestDispatcher(destino);
        view.forward(lRequest, lResponse);
    }

    private double calculaTotal(Iterator lista) {

        double valorTotal = 0;

        while (lista.hasNext()) {
            PVItem item = (PVItem) lista.next();
            valorTotal = valorTotal + item.getVlrTotal();
        }
        return valorTotal;
    }

    private void montaPVHeader() {
        eForma formapgto = PVHeader.eForma.valueOf(lRequest.getParameter("formaPgto"));
        pvHeader = new PVHeader();
        pvHeader.setCliente(cliente);
        pvHeader.setDtLcto(new Date());
        pvHeader.setStatus(PVHeader.eStatus.ABERTO);
        pvHeader.setTotalPedido(0);
        pvHeader.setFormaPgto(formapgto);
        pedidoVenda.setHeader(pvHeader);
    }

    private void montaPVItem() {

        Set<String> parameterNames = lRequest.getParameterMap().keySet();

        for (Entry<String, String[]> entry : lRequest.getParameterMap().entrySet()) {
            String name = entry.getKey();
            if (name.substring(0, 3).equals("qtd")) {
                int idProduto = Integer.parseInt(name.substring(3));
                try {
                    String sQuantidade = lRequest.getParameter(name);
                    double quantidade = Double.parseDouble(sQuantidade);
                    if (quantidade != 0) {
                        pvItem = new PVItem();
                        pvItem.setIdProduto(idProduto);
                        pvItem.setQuantidade((int)quantidade);
                        pedidoVenda.addItem(pvItem);
                    }
                } catch (Exception e) {
                    lRequest.setAttribute("mensagem", "Erro ao adicionar o produto " + idProduto);
                    destino = PRINCIPAL;
                }
            }
        }

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.biblioteca.Range;
import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.PVHeader;
import br.com.tmgmotopeca.modelo.PVItem;
import br.com.tmgmotopeca.modelo.PedidoVenda;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import br.com.tmgmotopeca.persistir.SelecionaPersistir.ListaPersistir;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ServletMeusPedidos", urlPatterns = {"/ServletMeusPedidos"})
public class ServletMeusPedidos extends HttpServlet {

    private Cliente cliente;
    private PedidoVenda pedidoVenda;
    private PVHeader header;
    private PVItem item;
    private Persistir PersistirVenda;

    private HttpServletRequest lRequest;
    private HttpServletResponse lResponse;

    private String destino = "";
    private static String PEDIDOS = "./subPaginas/meusPedidos.jsp";
    private static String HOME = "./subPaginas/home.jsp";

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

        if (cliente != null && cliente.getPerfil().equals("C")) {

            String action;
            action = lRequest.getParameter("action");

            if (action.equals("listar")) {
                try {
                    pedidoVenda = new PedidoVenda();
                    PersistirVenda = SelecionaPersistir.Selecionar(ListaPersistir.PVenda, pedidoVenda);

                    //seta condição para buscar todos os pedidos do cliente logado
                    ArrayList where = new ArrayList();
                    Range range = new Range();
                    range.setAtributo("idCliente");
                    range.setRelacao(Range.tpRelacao.IGUAL);
                    range.setConteudo(String.valueOf(cliente.getIdCliente()));
                    where.add(range);

                    Iterator pedidos = PersistirVenda.buscarLista(where);

                    //Monta tabHeader para exibir na tela
                    lRequest.setAttribute("tabHeader", pedidos);
                    destino = PEDIDOS;

                } catch (Exception e) {
                    lRequest.setAttribute("mensagem", e.getMessage());
                    destino = PEDIDOS;
                }
                
            } else if (action.equals("itens")) {
                
                try {
                    String pedido = lRequest.getParameter("ipPedido");
                    
                    pedidoVenda = new PedidoVenda();
                    PersistirVenda = SelecionaPersistir.Selecionar(ListaPersistir.PVenda, pedidoVenda);

                    //seta condição para buscar todos os pedidos do cliente logado
                    ArrayList where = new ArrayList();
                    Range range = new Range();
                    range.setAtributo("idPedido");
                    range.setRelacao(Range.tpRelacao.IGUAL);
                    range.setConteudo(pedido);
                    where.add(range);

                    Iterator pedidos = PersistirVenda.buscarLista(where);

                    //Monta tabHeader para exibir na tela
                    pedidoVenda = (PedidoVenda) pedidos.next();
                    lRequest.setAttribute("tabItens", pedidoVenda.getItens());
                    destino = PEDIDOS;                                       
                    
                } catch (Exception e) {
                    lRequest.setAttribute("mensagem", e.getMessage());
                    destino = PEDIDOS;
                }

            }

        } else {
            lRequest.setAttribute("mensagem", "Nenhum cliente logado!");
            destino = HOME;
        }

        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);

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

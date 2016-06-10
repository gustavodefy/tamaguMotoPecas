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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thayro
 */
@WebServlet(name = "ServletTodosPedidos", urlPatterns = {"/ServletTodosPedidos"})
public class ServletTodosPedidos extends HttpServlet {

    private Cliente cliente;
    private PedidoVenda pedidoVenda;
    private PVHeader header;
    private PVItem item;
    private Persistir PersistirVenda;
    private Persistir persistirCliente;

    private String linha = "linProduto";

    private HttpServletRequest lRequest;
    private HttpServletResponse lResponse;

    private String destino = "";
    private static String PEDIDOS = "./subPaginas/todosOsPedidos.jsp";
    private static String ITENS = "./subPaginas/detalhePedidos.jsp";
    private static String HOME = "./subPaginas/home.jsp";
    private static String PRODUTO = "./subPaginas/cadastroProdutos.jsp";

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

        String action;
        action = lRequest.getParameter("action");

        if (action.equals("listar") || action.equals("voltar")) {
            try {
                
                setLista(request);

                //destino = PEDIDOS;

            } catch (Exception e) {
                lRequest.setAttribute("mensagem", e.getMessage());
                destino = PEDIDOS;
            }

        } else if (action.equals("itens")) {

            try {
                String pedido = lRequest.getParameter("idPedido");

                pedidoVenda = new PedidoVenda();
                PersistirVenda = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PVenda, pedidoVenda);

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
                lRequest.setAttribute("idPedido", pedido);
                lRequest.setAttribute("linHeader", pedidoVenda.getHeader());
                lRequest.setAttribute("tabItens", pedidoVenda.getItens());
                lRequest.setAttribute("totalPedido", pedidoVenda.getHeader().getTotalPedido());
                destino = ITENS;

            } catch (Exception e) {
                lRequest.setAttribute("mensagem", e.getMessage());
                destino = PEDIDOS;
            }

        } else if (action.equals("gravar")) {

            try {

                //busca os dados da tela
                getDadosTela(request);

                //gravar os dados no banco
                PersistirVenda.gravar();
                
                setLista(request);

            } catch (Exception e) {
                lRequest.setAttribute("mensagem", e.getMessage());
                destino = PEDIDOS;
            }

        }

        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);
    }

    private void getDadosTela(HttpServletRequest request) throws Exception {
        try {

            pedidoVenda.getHeader().setStatus(PVHeader.eStatus.valueOf(lRequest.getParameter("statusPedido")));

            //PVHeader.eStatus status = PVHeader.eStatus.valueOf(lRequest.getParameter("statusPedido"));
            PersistirVenda.setEntidade(pedidoVenda);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void setLista(HttpServletRequest request) throws Exception {
        try {
            
            pedidoVenda = new PedidoVenda();
            PersistirVenda = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PVenda, pedidoVenda);

            //seta condição para buscar todos os pedidos do cliente logado
            ArrayList where = new ArrayList();

            Iterator pedidos = PersistirVenda.buscarLista(where);

            //Monta tabHeader para exibir na tela
            lRequest.setAttribute("tabHeader", pedidos);
            
            destino = PEDIDOS;
            
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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

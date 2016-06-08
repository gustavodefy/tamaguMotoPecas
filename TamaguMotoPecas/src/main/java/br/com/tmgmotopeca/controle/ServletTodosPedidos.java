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
import br.com.tmgmotopeca.modelo.Produto;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
 * @author Thayro
 */
@WebServlet(name = "ServletTodosPedidos", urlPatterns = {"/ServletTodosPedidos"})
public class ServletTodosPedidos extends HttpServlet {

    private Cliente cliente;
    private PedidoVenda pedidoVenda;
    private PVHeader header;
    private PVItem item;
    private Persistir PersistirVenda;

    private Produto produto;
    private Persistir persistirProduto;
    private String linha = "linProduto";

    private HttpServletRequest lRequest;
    private HttpServletResponse lResponse;

    private String destino = "";
    private static String PEDIDOS = "./subPaginas/todosOsPedidos.jsp";
    private static String ITENS = "./subPaginas/meusPedidosItens.jsp";
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
                pedidoVenda = new PedidoVenda();
                PersistirVenda = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PVenda, pedidoVenda);

                //seta condição para buscar todos os pedidos do cliente logado
                ArrayList where = new ArrayList();
//                    Range range = new Range();
//                    range.setAtributo("idCliente");
//                    range.setRelacao(Range.tpRelacao.IGUAL);
//                    range.setConteudo(String.valueOf(cliente.getIdCliente()));
//                    where.add(range);

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
                lRequest.setAttribute("tabItens", pedidoVenda.getItens());
                lRequest.setAttribute("totalPedido", pedidoVenda.getHeader().getTotalPedido());
                destino = ITENS;

            } catch (Exception e) {
                lRequest.setAttribute("mensagem", e.getMessage());
                destino = PEDIDOS;
            }

        } else if (action.equals("consultar")) {
            try {
                //Busca o codigo do produto na tela
                produto = new Produto();
                persistirProduto = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PProduto, produto);
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                //Busca o registro selecionado no banco
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
                destino = HOME;
            }
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

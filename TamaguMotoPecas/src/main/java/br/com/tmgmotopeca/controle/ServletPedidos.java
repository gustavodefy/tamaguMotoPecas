/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Fornecedor;
import br.com.tmgmotopeca.modelo.PCHeader;
import br.com.tmgmotopeca.modelo.PCItem;
import br.com.tmgmotopeca.modelo.PedidoCompra;
import br.com.tmgmotopeca.modelo.Produto;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Set;
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
@WebServlet(name = "ServletPedidos", urlPatterns = {"/ServletPedidos"})
public class ServletPedidos extends HttpServlet {

    private PedidoCompra pedidoCompra;
    private PCHeader headerCompra;
    private PCItem itensCompra;
    private Persistir pesistirPCompra;
    private Persistir pesistirFornecedor;
    private Persistir pesistirProdutos;
    private Fornecedor fornecedor;
    private Produto produto;

    private String destino = "";
    private static String UNICO = "./subPaginas/pedidoFornecedor.jsp";
    private static String LISTA = "./subPaginas/listaPedidoFornecedores.jsp";
    private static String PRINCIPAL = "./subPaginas/principal.jsp";

    private String tabelaFornecedor = "tabForn";
    private String tabelaProduto = "tabProd";

    private String linha = "linPedidos";

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        lRequest = request;
        lResponse = response;

        fornecedor = new Fornecedor();
        pesistirFornecedor = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PFornecedor, fornecedor);
        produto = new Produto();
        pesistirProdutos = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PProduto, produto);

        String action;

        action = request.getParameter("action");

        if (action.equals("inicio")) {

            try {
                setListaFornecedor(request);
            } catch (Exception e) {
                request.setAttribute("mensagem", "Nenhum Fornecedor encontrado");
            }
            try {
                setListaProduto(request);
            } catch (Exception e) {
                request.setAttribute("mensagem", "Nenhum Produto encontrado");
            }

            destino = UNICO;

        } else if (action.equals("fechar")) {

            Set<String> parameterNames = lRequest.getParameterMap().keySet();
            pedidoCompra = new PedidoCompra();

            try {
                montaHeaderCompra();
            } catch (Exception e) {
                request.setAttribute("mensagem", "Erro ao montar o Header do Pedido");
            }

            try {
                montaItensCompra();
            } catch (Exception e) {
                request.setAttribute("mensagem", "Erro ao montar os Itens do Pedido");
            }

        }

        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);
    }

    private void setListaFornecedor(HttpServletRequest request) throws Exception {
        try {
            //Busca todos os registros de fornecedores
            request.setAttribute(tabelaFornecedor, pesistirFornecedor.buscarLista(null));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void setListaProduto(HttpServletRequest request) throws Exception {
        try {
            //Busca todos os registros de Produtos
            request.setAttribute(tabelaProduto, pesistirProdutos.buscarLista(null));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void montaHeaderCompra() throws Exception {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        headerCompra = new PCHeader();

        String idFornecedor = lRequest.getParameter("fornecedor");
        String strData = lRequest.getParameter("data");
        Date dtLcto = formato.parse(strData);

        headerCompra.setFornecedor(Integer.parseInt(idFornecedor));
        headerCompra.setDtLcto(dtLcto);
        headerCompra.setStatus(PCHeader.eStatus.ABERTO);

        pedidoCompra.setPCHeader(headerCompra);
    }

    private void montaItensCompra() throws Exception {

        for (Entry<String, String[]> entry : lRequest.getParameterMap().entrySet()) {
            String name = entry.getKey();
            if (name.substring(0, 3).equals("row")) {

                String[] valores = lRequest.getParameterValues(name);

                try {
                    itensCompra = new PCItem();
                    
                    itensCompra.setProduto(Integer.parseInt(valores[0]));
                    itensCompra.setQuantidade(Double.parseDouble(valores[2]));
                    itensCompra.setVlrUnitario(Double.parseDouble(valores[3]));
                    itensCompra.setVlrTotal(Double.parseDouble(valores[4]));                    
                    
                    pedidoCompra.addPCItem(itensCompra);
                    
                } catch (Exception e) {
                    lRequest.setAttribute("mensagem", "Erro ao adicionar o produto ");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Produto;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.PersistirProduto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ResVUT42
 */
@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    private Produto produto;
    private Persistir persistirProduto;

    private String destino = "";
    private static String UNICO = "./subPaginas/cadastroProdutos.jsp";
    private static String LISTA = "./subPaginas/listaProdutos.jsp";
    private static String PRINCIPAL = "./subPaginas/principal.jsp";

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

        produto = new Produto();
        persistirProduto = new PersistirProduto(produto);

        String action;

        boolean bGravar = request.getParameter("gravar") != null;
        boolean bExcluir = request.getParameter("excluir") != null;
        boolean bCancelar = request.getParameter("cancelar") != null;

        if (bGravar) {
            action = "gravar";
        } else if (bExcluir) {
            action = "excluir";
        } else if (bCancelar) {
            action = "cancelar";
        } else {
            action = request.getParameter("action");
        }

        if (action.equals("listar")) {
            try {
                //Busca e lista os dados da entidade
                setLista(request);
            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
                destino = PRINCIPAL;
            }

        } else if (action.equals("inserir")) {

            //Direciona para incluir um novo registro
            request.setAttribute("excluir", "false");
            destino = UNICO;

        } else if (action.equals("editar")) {
            try {
                //Busca o codigo do produto na tela
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                //Busca o registro selecionado no banco
                persistirProduto.buscar(idProduto);
                produto = (Produto) persistirProduto.getEntidade();

                //Seta atributo na tela
                request.setAttribute(linha, produto);

                //Direciona para alterar o registro
                request.setAttribute("excluir", "true");
                destino = UNICO;
            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
                destino = PRINCIPAL;
            }

        } else if (action.equals("excluir")) {
            try {
                //busca os dados na tela
                getDadosTela(request);

                //exclui o registro do banco
                persistirProduto.excluir();

                //Lista os registros da entidade
                setLista(request);
            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
                destino = PRINCIPAL;
            }

        } else if (action.equals("gravar")) {
            try {
                //busca os dados da tela
                getDadosTela(request);

                //gravar os dados no banco
                persistirProduto.gravar();

                //Lista os registros da entidade
                setLista(request);
            } catch (Exception e) {

                //Seta atributo na tela
                request.setAttribute("mensagem", e.getMessage());

                //Seta atributo na tela
                request.setAttribute(linha, produto);

                destino = UNICO;
            }

        } else {

            try {
                //Lista os registros da entidade
                setLista(request);
            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
                destino = PRINCIPAL;
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);
    }

    private void setLista(HttpServletRequest request) throws Exception {
        try {
            //Busca todos os registros de produto
            request.setAttribute(tabela, persistirProduto.buscarLista(null));
            //Direciona para pagina de lista
            destino = LISTA;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosTela(HttpServletRequest request) throws Exception {

        try {

            produto = new Produto();

            String idProduto = request.getParameter("idProduto");
            if (idProduto != null && !idProduto.isEmpty()) {
                produto.setIdProduto(Integer.parseInt(idProduto));
            }

            produto.setDescricao(request.getParameter("descricao"));
            produto.setMarca(request.getParameter("marca"));
            produto.setModelo(request.getParameter("modelo"));
            produto.setPercentualVenda(Double.parseDouble(request.getParameter("percentualVenda")));
            produto.setPrecoCompra(Double.parseDouble(request.getParameter("precoCompra")));
            produto.setPrecoVenda(Double.parseDouble(request.getParameter("precoVenda")));
            produto.setEstoque(Double.parseDouble(request.getParameter("estoque")));

            persistirProduto.setEntidade(produto);

        } catch (Exception e) {
            throw new Exception("Preencher todos os campos!!");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.modelo.Produto;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletCatalogo", urlPatterns = {"/ServletCatalogo"})
public class ServletCatalogo extends HttpServlet {

    private Produto produto;
    private Persistir persistirProduto;

    private String destino = "";
    private static String UNICO = "./subPaginas/cadastroProdutos.jsp";
    private static String LISTA = "./subPaginas/catalogoProdutos.jsp";
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

        //Validando Sessão
        HttpSession sessao = request.getSession();
        Cliente cliente = (Cliente) sessao.getAttribute("sessaoCliente");

        if(cliente == null){
            request.setAttribute("funcionario", "false");
            request.setAttribute("cliente", "false");
            request.setAttribute("logado", "false");            
        }else if (cliente.getPerfil().equals("F")) {
            request.setAttribute("funcionario", "true");
            request.setAttribute("cliente", "false");
            request.setAttribute("logado", "true");
        } else if (cliente.getPerfil().equals("C")) {
            request.setAttribute("funcionario", "false");
            request.setAttribute("cliente", "true");
            request.setAttribute("logado", "true");
        } else {
            request.setAttribute("funcionario", "false");
            request.setAttribute("cliente", "false");
            request.setAttribute("logado", "false");
        }

        request.setAttribute("toservlet", "ServletCatalogo");

        produto = new Produto();
        persistirProduto = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PProduto, produto);

        String action;
        boolean bCancelar = request.getParameter("cancelar") != null;

        if (bCancelar) {
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
                request.setAttribute("gravar", "false");
                request.setAttribute("excluir", "false");
                destino = UNICO;

            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
                destino = PRINCIPAL;
            }
        
        } else if (action.equals("addCarrinho")){
            try {
                String idProduto = request.getParameter("idProduto");
                String[] item  =  request.getParameterValues(idProduto);
                
                destino = LISTA;
            } catch (Exception e) {
                
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

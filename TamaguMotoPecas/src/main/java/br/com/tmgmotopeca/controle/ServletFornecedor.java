/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Fornecedor;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.PersistirFornecedor;
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
@WebServlet(name = "ServletFornecedor", urlPatterns = {"/ServletFornecedor"})
public class ServletFornecedor extends HttpServlet {

    private Fornecedor fornecedor;
    private Persistir persistirFornecedor;

    private String destino = "";
    private static String UNICO = "./subPaginas/cadastroFornecedores.jsp";
    private static String LISTA = "./subPaginas/listaFornecedores.jsp";

    private String tabela = "tabFornecedor";
    private String linha = "linFornecedor";

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

        fornecedor = new Fornecedor();
        persistirFornecedor = new PersistirFornecedor(fornecedor);

        try {
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

                //Busca e lista os dados da entidade
                setLista(request);

            } else if (action.equals("inserir")) {

                //Direciona para incluir um novo registro
                request.setAttribute("excluir", "false");
                destino = UNICO;

            } else if (action.equals("editar")) {

                //Busca o codigo do fornecedor na tela
                int idFornecedor = Integer.parseInt(request.getParameter("idFornecedor"));

                //Busca o registro selecionado no banco
                persistirFornecedor.buscar(idFornecedor);
                fornecedor = (Fornecedor) persistirFornecedor.getEntidade();

                //Seta atributo na tela
                request.setAttribute(linha, fornecedor);

                //Direciona para alterar o registro
                request.setAttribute("excluir", "true");
                destino = UNICO;

            } else if (action.equals("excluir")) {

                //busca os dados na tela
                getDadosTela(request);

                //exclui o registro do banco
                persistirFornecedor.excluir();

                //Lista os registros da entidade
                setLista(request);

            } else if (action.equals("gravar")) {

                //busca os dados da tela
                getDadosTela(request);

                //gravar os dados no banco
                persistirFornecedor.gravar();

                //Lista os registros da entidade
                setLista(request);

            } else {
                //Lista os registros da entidade
                setLista(request);
            }

        } catch (Exception e) {
            try {
                setLista(request);
                request.setAttribute("mensagem", e.getMessage());
            } catch (Exception j) {
                request.setAttribute("mensagem", j.getMessage());
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);

    }

    private void setLista(HttpServletRequest request) throws Exception {
        try {
            //Busca todos os registros de fornecedor
            request.setAttribute(tabela, persistirFornecedor.buscarLista(null));
            //Direciona para pagina de lista
            destino = LISTA;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosTela(HttpServletRequest request) throws Exception {
        try {

            fornecedor = new Fornecedor();

            String idFornecedor = request.getParameter("idFornecedor");
            if (idFornecedor != null && !idFornecedor.isEmpty()) {
                fornecedor.setIdFornecedor(Integer.parseInt(idFornecedor));
            }
            fornecedor.setNome(request.getParameter("nome"));
            fornecedor.setCpf_cnpj(request.getParameter("cpf_cnpj"));
            fornecedor.setLogradouro(request.getParameter("logradouro"));
            fornecedor.setNumero(request.getParameter("numero"));
            fornecedor.setComplemento(request.getParameter("complemento"));
            fornecedor.setCep(request.getParameter("cep"));
            fornecedor.setBairro(request.getParameter("bairro"));
            fornecedor.setCidade(request.getParameter("cidade"));
            fornecedor.setEstado(request.getParameter("estado"));
            fornecedor.setTelefone(request.getParameter("telefone"));
            fornecedor.setEmail(request.getParameter("email"));
            fornecedor.setContato(request.getParameter("contato"));

            persistirFornecedor.setEntidade(fornecedor);

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

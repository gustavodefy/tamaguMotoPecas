/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.PersistirCliente;
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
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet {

    private Cliente cliente;
    private Persistir persistirCliente;

    private String destino = "";
    private static String UNICO = "./subPaginas/cadastroClientes.jsp";
    private static String LISTA = "./subPaginas/listaClientes.jsp";

    private String tabela = "tabCliente";
    private String linha = "linCliente";

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
            
        cliente = new Cliente();
        persistirCliente = new PersistirCliente(cliente);
            
        try {
            String action;
            
            boolean bGravar   = request.getParameter("gravar")   != null;
            boolean bExcluir  = request.getParameter("excluir")  != null;
            boolean bCancelar = request.getParameter("cancelar") != null;
            
            if(bGravar){
                action = "gravar";
            }else if (bExcluir){
                action = "excluir";
            }else if (bCancelar){
                action = "cancelar";
            }else{
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

                //Busca o codigo do cliente na tela
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));

                //Busca o registro selecionado no banco
                persistirCliente.buscar(idCliente);
                cliente = (Cliente) persistirCliente.getEntidade();

                //Seta atributo na tela
                request.setAttribute(linha, cliente);

                //Direciona para alterar o registro
                request.setAttribute("excluir", "true");
                destino = UNICO;

            } else if (action.equals("excluir")) {

                //busca os dados na tela
                getDadosTela(request);                
                
                //exclui o registro do banco
                persistirCliente.excluir();
                
                //Lista os registros da entidade
                setLista(request);

            } else if (action.equals("gravar")) {

                //busca os dados da tela
                getDadosTela(request);
                
                //gravar os dados no banco
                persistirCliente.gravar();
                
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
            //Busca todos os registros de cliente
            request.setAttribute(tabela, persistirCliente.buscarLista(null));
            //Direciona para pagina de lista
            destino = LISTA;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void getDadosTela(HttpServletRequest request) throws Exception {

        try {

            //Busca os dados da tela, e atualiza classe Cliente
            cliente = new Cliente();

            String idCliente = request.getParameter("idCliente");
            if (idCliente != null && !idCliente.isEmpty()) {
                cliente.setIdCliente(Integer.parseInt(idCliente));
            }
            cliente.setNome(request.getParameter("nome"));
            cliente.setCpf_cnpj(request.getParameter("cpf_cnpj"));
            cliente.setLogradouro(request.getParameter("logradouro"));
            cliente.setNumero(request.getParameter("numero"));
            cliente.setComplemento(request.getParameter("complemento"));
            cliente.setCep(request.getParameter("cep"));
            cliente.setBairro(request.getParameter("bairro"));
            cliente.setCidade(request.getParameter("cidade"));
            //cliente.setEstado(request.getParameter("estado"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setContato(request.getParameter("contato"));
            cliente.setLimiteCredito(Double.parseDouble(request.getParameter("limitecredito")));

            persistirCliente.setEntidade(cliente);

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

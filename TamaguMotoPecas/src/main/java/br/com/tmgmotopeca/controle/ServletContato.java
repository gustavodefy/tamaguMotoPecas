/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Contato;
import br.com.tmgmotopeca.persistir.Persistir;
import br.com.tmgmotopeca.persistir.PersistirProduto;
import br.com.tmgmotopeca.persistir.SelecionaPersistir;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "ServletContato", urlPatterns = {"/ServletContato"})
public class ServletContato extends HttpServlet {

    private Contato contato;
    private Persistir persistirContato;

     String action;
    private String linha = "linCliente";
    private String destino = "";
    private static String UNICO = "./subPaginas/contato.jsp";

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

        contato = new Contato();
        persistirContato = SelecionaPersistir.Selecionar(SelecionaPersistir.ListaPersistir.PContato, contato);


            action = request.getParameter("action");
        if (action.equals("gravar")){
            try {
                //busca os dados da tela
                getDadosTela(request);
                //gravar os dados no banco
                persistirContato.gravar();
                //Lista os registros da entidade
                request.setAttribute("mensagem", "Mensagem enviada com sucesso");
                destino = UNICO;
                } catch (Exception e) {
                request.setAttribute("mensagem", "Falha ao enviar Mensagem" + e);
                destino = UNICO;   
                //Seta atributo na tela
                request.setAttribute(linha, contato);
            }
        }else if (action.equals("inicio")){
            destino = UNICO;
        }
        RequestDispatcher view = request.getRequestDispatcher(destino);
        view.forward(request, response);
    }
    
     private void getDadosTela(HttpServletRequest request) throws Exception {
        try {
            //Busca os dados da tela, e atualiza classe Cliente
            contato = new Contato();
            String idContato = request.getParameter("idContato");
            if (idContato != null && !idContato.isEmpty()) {
                contato.setIdContato(Integer.parseInt(idContato));
            }
            contato.setNome(request.getParameter("nome"));
            contato.setEmail(request.getParameter("email"));
            contato.setAssunto(request.getParameter("assunto"));
            contato.setTelefone(request.getParameter("telefone"));
            contato.setMensagem(request.getParameter("observacao"));
            persistirContato.setEntidade(contato);
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

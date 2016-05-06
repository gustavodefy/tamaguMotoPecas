/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import br.com.tmgmotopeca.modelo.Cliente;
import br.com.tmgmotopeca.persistir.PersistirCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Thayro
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    private String destino = "";
    private static String LOGIN = "./subPaginas/login.jsp";
    private static String PRINCIPAL = "./subPaginas/principal.jsp";

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
        String action;
        // Validando se o usuário é igual a "admin" e a senha é igual a "senha"

        action = request.getParameter("action");

        if (action.equals("inicio")) {

            HttpSession sessao = request.getSession();
            sessao.invalidate();
            request.setAttribute("funcionario", "false");
            request.setAttribute("cliente", "false");
            request.setAttribute("logado", "false");
            destino = PRINCIPAL;

        } else if (action.equals("logout")) {

            HttpSession sessao = request.getSession();
            sessao.invalidate();
            request.setAttribute("funcionario", "false");
            request.setAttribute("cliente", "false");
            request.setAttribute("logado", "false");
            destino = PRINCIPAL;

        } else {

            try {

                Cliente cliente = new Cliente();

                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                cliente.setEmail(email);
                cliente.setSenha(senha);

                PersistirCliente clientePer = new PersistirCliente(cliente);

                clientePer.autenticar();
                cliente = (Cliente) clientePer.getEntidade();

                if (cliente != null) {

                    //Validando Sessão
                    HttpSession sessao = request.getSession();
                    // setando um atributo da sessao
                    //sessao.setAttribute("login", cliente.getIdCliente());
                    sessao.setAttribute("login", cliente.getNome());
                    //sessao.setAttribute("login", request.getParameter("login"));

                    //Validando Login
                    destino = PRINCIPAL;

                    if (cliente.getPerfil().equals("F")) {
                        request.setAttribute("funcionario", "true");
                        request.setAttribute("cliente", "false");
                        request.setAttribute("logado", "true");
                    } else {
                        request.setAttribute("funcionario", "false");
                        request.setAttribute("cliente", "true");
                        request.setAttribute("logado", "true");
                    }

                } else {

                    destino = PRINCIPAL;
                    request.setAttribute("funcionario", "false");
                    request.setAttribute("cliente", "false");
                    request.setAttribute("logado", "false");

                }

            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
                destino = PRINCIPAL;
                request.setAttribute("funcionario", "false");
                request.setAttribute("cliente", "false");
                request.setAttribute("logado", "false");
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

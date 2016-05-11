/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.controle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thayro
 */
@WebServlet(name = "ServltImg", urlPatterns = {"/ServltImg"})
public class ServltImg extends HttpServlet {
    
    private static final long serialVersionUID = 201011231103L;
 
    public ServltImg() {
        super();
    }

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
        // A imagem é um png - Poderia ser qualquer outro tipo
        response.setContentType("image/png");

        // Recupera o parâmetro
        String text = request.getParameter("texto");

        // Cria uma imagem de tamanho 500x50
        BufferedImage image = new BufferedImage(500, 50,
                BufferedImage.TYPE_INT_ARGB);

        // Cria o canvas pra desenho
        Graphics2D canvas = image.createGraphics();
        canvas.setColor(Color.BLUE);
        // Desenha um círculo azul
        canvas.fillOval(10, 10, 10, 10);
        canvas.setColor(Color.RED);
        canvas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        // Desenha o texto em vermelho
        canvas.drawString(text != null ? text : "Nenhum texto informado!", 25,
                20);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            // Escreve a imagem no outputstream da response no formato png
            ImageIO.write(image, "PNG", out);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

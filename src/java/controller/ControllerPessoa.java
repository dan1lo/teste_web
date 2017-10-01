/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author danilomonteiro
 */
public class ControllerPessoa extends HttpServlet {
    Pessoa p1 = new Pessoa();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerPessoa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>oi ßServlet ControllerPessoa at " + request.getContextPath() + "</h1>");
            out.println(p1.getNome());
            out.println(p1.getNivel());
            out.println(p1.getSenha());
            out.println("</body>");
            out.println("</html>");
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
        
        String op = request.getParameter("action");
        System.out.println(op);
          
        if(op.equalsIgnoreCase("cadastrar")){
            //request.getRequestDispatcher("/teste/cadastrar.jsp").forward(request, response);
            response.sendRedirect("/teste/cadastrar.jsp");
        
        }else if( op.contentEquals("visualizar")){
            PessoaDAO dao = new PessoaDAO();
            //forward = "/teste/visualizarPessoa.jsp";
            request.setAttribute("pessoas", dao.listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("visualizarPessoa.jsp");
            dispatcher.forward(request, response);
        }else if(op.contentEquals("deletar")){
            PessoaDAO dao = new PessoaDAO();
            request.setAttribute("pessoas", dao.listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("deletarPessoa.jsp");
            dispatcher.forward(request, response);
            
            
        }else if(op.contentEquals("atualizar")){
            PessoaDAO dao = new PessoaDAO();
            request.setAttribute("pessoas", dao.listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarPessoa.jsp");
            dispatcher.forward(request, response);
                       
        }
        
         
        
        
        //processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
             {
              
        String op = request.getParameter("action");
        System.out.println(op);
        PessoaDAO daopessoa = new PessoaDAO();
        
        if(op.equalsIgnoreCase("cadastrarPessoa")){
            p1.setNome(request.getParameter("nome"));
            p1.setNivel (request.getParameter("nivel"));
            p1.setSenha(request.getParameter("senha"));
            daopessoa.cadastrar(p1);
            processRequest(request, response);
        
        }else if(op.equalsIgnoreCase("deletar")){
            int id = Integer.parseInt(request.getParameter("id"));
            daopessoa.deletar(id);
            request.setAttribute("pessoas", daopessoa.listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("visualizarPessoa.jsp");
            dispatcher.forward(request, response);
        }else if(op.equalsIgnoreCase("atualizar")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("oi danilo");
            p1.setNome(request.getParameter("nome"));
            p1.setNivel (request.getParameter("nivel"));
            p1.setSenha(request.getParameter("senha"));
            p1.setId(id);
            daopessoa.atualizar(p1);
            request.setAttribute("pessoas", daopessoa.listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("visualizarPessoa.jsp");
            dispatcher.forward(request, response);
        }
        
        
        
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RegisterService;

/**
 *
 * @author juanj
 */
public class RegisterServlet extends HttpServlet {

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

        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/plantillas/register.jsp");
        rd.forward(request, response);
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

        ServletContext context = getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        RegisterService loginService = new RegisterService(em);

        String user = request.getParameter("user").toLowerCase();
        String password = request.getParameter("pass");
        String password2 = request.getParameter("pass2");
        String email = request.getParameter("email");

        if (!password.equals(password2)) {
            request.setAttribute("errorMessage", "La contraseña no coincide.");
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/plantillas/register.jsp");
            rd.forward(request, response);
        } else if ("".equals(user) || "".equals(password) || "".equals(password2) || "".equals(email)) {
            request.setAttribute("errorMessage", "Hay uno o varios campos vacíos.");
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/plantillas/register.jsp");
            rd.forward(request, response);
        } else if (loginService.validaUser(user, email)) {
            request.setAttribute("errorMessage", "El usuario o el correo ya existe.");
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/plantillas/register.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Creado Correctamente.");
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/plantillas/register.jsp");
            rd.forward(request, response);
            String passwordSHA1 = loginService.cifrado(password);
            loginService.crearUser(user, email, passwordSHA1);
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

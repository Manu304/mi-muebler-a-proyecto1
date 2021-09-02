/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.session;

import com.mrojas.pruebas.mi_muebleria.models.users.UserRole;
import com.mrojas.pruebas.mi_muebleria.models.users.Usuario;
import com.mrojas.pruebas.mi_muebleria.services.LoginServiceSession;
import com.mrojas.pruebas.mi_muebleria.services.user.UserService;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Manu
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        LoginServiceSession auth = new LoginServiceSession();
        Optional<String> usernameOptional = auth.getUsername(request);
        Optional<UserRole> userRole = auth.getUserRole(request);
        boolean userIsActivo = auth.getEstado(request);
        
        System.out.println("estoy en el get service");

        if (usernameOptional.isPresent() && userIsActivo && userRole.isPresent()) {
            System.out.println("He pasado el if del get service");
            switch (userRole.get()) {
                case ADMIN:
                    response.sendRedirect(request.getContextPath() + "/user/admin/index.jsp");
                    break;
                case FABRICANTE:
                    response.sendRedirect(request.getContextPath() + "/user/fabricante/index.jsp");
                    break;
                case VENDEDOR:
                    response.sendRedirect(request.getContextPath() + "/user/vendedor/index.jsp");
                    break;
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        Optional<Usuario> usuarioOptional = service.login(username, password);
        String error = "";

        if (usuarioOptional.isPresent()) {
            if (usuarioOptional.get().isActivo()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userRole", usuarioOptional.get().getRol());
                session.setAttribute("userState", usuarioOptional.get().isActivo());
                doGet(request, response);
            }else{
                error = "Tu usuario ha sido cancelado. No puedes iniciar sesión";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            error = "No se pudo iniciar sesión. Revisa tus credenciales";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}

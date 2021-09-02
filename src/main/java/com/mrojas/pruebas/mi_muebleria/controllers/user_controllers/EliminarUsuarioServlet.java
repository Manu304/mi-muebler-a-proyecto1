/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.user_controllers;

import com.mrojas.pruebas.mi_muebleria.services.LoginServiceSession;
import com.mrojas.pruebas.mi_muebleria.services.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manu
 */
@WebServlet(name = "EliminarUsuarioServlet", urlPatterns = { "/user/admin/delete" })
public class EliminarUsuarioServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();
        LoginServiceSession loginService = new LoginServiceSession();
        String username = request.getParameter("user");

        if (service.porIdentificador(username).isPresent() && !loginService.isUserSession(request, username)) {
            service.eliminar(username);
        }
        response.sendRedirect(request.getContextPath() + "/user/admin/control");

    }

}

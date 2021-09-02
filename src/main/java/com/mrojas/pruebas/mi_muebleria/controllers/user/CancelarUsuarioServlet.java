/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.user;

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

/**
 *
 * @author Manu
 */
@WebServlet(name = "CancelarUsuarioServlet", urlPatterns = {"/user/admin/cancelar"})
public class CancelarUsuarioServlet extends HttpServlet {

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
        UserService service = new UserService();
        String username = request.getParameter("user");
        LoginServiceSession loginService = new LoginServiceSession();
        Optional<Usuario> usuarioCancelar = service.porIdentificador(username);
        if (usuarioCancelar.isPresent() && !loginService.isUserSession(request, username)) {
            Usuario userCancel = usuarioCancelar.get();
            userCancel.setActivo(!userCancel.isActivo());
            service.guardar(userCancel);
        }
        response.sendRedirect(request.getContextPath() + "/user/admin/control");
    }
}

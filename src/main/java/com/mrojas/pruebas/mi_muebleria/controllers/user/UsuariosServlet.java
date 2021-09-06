/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.user;

import com.mrojas.pruebas.mi_muebleria.models.users.UserRole;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrojas.pruebas.mi_muebleria.models.users.Usuario;
import com.mrojas.pruebas.mi_muebleria.services.LoginServiceSession;
import com.mrojas.pruebas.mi_muebleria.services.user.UserService;

/**
 *
 * @author Manu
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/user/admin/control"})
public class UsuariosServlet extends HttpServlet {

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
        LoginServiceSession sessionService = new LoginServiceSession();
        if (sessionService.isRole(request, UserRole.ADMIN)) {
            UserService service = new UserService();
            List<Usuario> usuarios = service.listar();
            request.setAttribute("usuarios", usuarios);
            getServletContext().getRequestDispatcher("/user/admin/control-usuarios.jsp").forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }
}

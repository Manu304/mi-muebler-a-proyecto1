
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.pieza;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrojas.pruebas.mi_muebleria.models.Pieza;
import com.mrojas.pruebas.mi_muebleria.models.users.UserRole;
import com.mrojas.pruebas.mi_muebleria.services.LoginServiceSession;
import com.mrojas.pruebas.mi_muebleria.services.pieza.PiezaService;
import com.mrojas.pruebas.mi_muebleria.util.DataValidator;

/**
 *
 * @author Manu
 */
@WebServlet(name = "EliminarPieza", urlPatterns = { "/user/fabricante/eliminar-pieza" })
public class EliminarPieza extends HttpServlet {

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
        PiezaService service = new PiezaService();
        String id = request.getParameter("id");
        LoginServiceSession loginService = new LoginServiceSession();
        Optional<Pieza> optionalPieza = DataValidator.isEntero(id) ? service.porIdentificador(Integer.parseInt(id))
                : null;

        if (optionalPieza.isPresent() && loginService.isRole(request, UserRole.FABRICANTE)) {
            service.eliminar(Integer.parseInt(id));
            response.sendRedirect(request.getContextPath() + "/user/fabricante/inventario-piezas");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/fabricante/inventario-piezas");
        }

    }

}

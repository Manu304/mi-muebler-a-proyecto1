/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.pieza;

import com.mrojas.pruebas.mi_muebleria.models.Pieza;
import com.mrojas.pruebas.mi_muebleria.models.users.UserRole;
import com.mrojas.pruebas.mi_muebleria.services.LoginServiceSession;
import com.mrojas.pruebas.mi_muebleria.services.pieza.PiezaService;
import com.mrojas.pruebas.mi_muebleria.util.DataValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "PiezasServlet", urlPatterns = { "/user/fabricante/inventario-piezas" })
public class PiezasServlet extends HttpServlet {

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
        LoginServiceSession sessionService = new LoginServiceSession();
        String col = request.getParameter("col");
        String asc = request.getParameter("asc");
        String search = request.getParameter("search");
        if (sessionService.isRole(request, UserRole.FABRICANTE)) {
            PiezaService service = new PiezaService();
            List<Pieza> piezas= new ArrayList<>();
            if (DataValidator.isEntero(col)) {
                piezas = service.orderBy(Integer.parseInt(col)-1, Boolean.parseBoolean(asc));
            } else if(DataValidator.isValidString(search)){
                Optional<Pieza> piezaBuscada = service.porIdentificador(search);
                if (piezaBuscada.isPresent()) {
                    piezas.add(piezaBuscada.get());
                }
            }else{
                piezas = service.listar();
            }
            request.setAttribute("search", search);
            request.setAttribute("piezas", piezas);
            getServletContext().getRequestDispatcher("/user/fabricante/inventario-piezas.jsp").forward(request,
                    response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

}

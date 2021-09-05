/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.pieza;

import java.io.IOException;
import java.util.*;

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
@WebServlet(name = "CrearPiezaServlet", urlPatterns = { "/user/fabricante/new-pieza" })
public class CrearPiezaServlet extends HttpServlet {

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
                String id = request.getParameter("id");
                String esEdit = request.getParameter("edit");
                LoginServiceSession loginService = new LoginServiceSession();
                PiezaService service = new PiezaService();
                Optional<Pieza> optionalPieza = DataValidator.isEntero(id)
                                ? service.porIdentificador(Integer.parseInt(id))
                                : null;

                if (Boolean.parseBoolean(esEdit) && loginService.isRole(request, UserRole.FABRICANTE)
                                && optionalPieza.isPresent()) {
                        Pieza editable = optionalPieza.get();
                        System.out.println("si encontre el opcional de pieza");
                        request.setAttribute("tipo_pieza", editable.getTipo());
                        request.setAttribute("costo", editable.getCosto());
                        request.setAttribute("cantidad", editable.getCantidad());
                        request.setAttribute("edit", esEdit);
                        getServletContext().getRequestDispatcher("/user/fabricante/crear-pieza.jsp").forward(request,
                                        response);

                } else {
                        response.sendRedirect(request.getContextPath() + "/user/fabricante/inventario-piezas");
                }
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request  servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException      if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                String tipoPieza = request.getParameter("tipo_pieza");
                String costo = request.getParameter("costo");
                String cantidad = request.getParameter("cantidad");
                String isEdit = request.getParameter("edit");
                PiezaService service = new PiezaService();

                Map<String, String> errores = new HashMap<>();
                // VALIDANDO TIPO PIEZA
                if (!DataValidator.isValidString(tipoPieza)) {
                        errores.put("tipo", "Debes escribir el nombre del tipo de pieza");
                } else if (!DataValidator.isAlfanumerico(tipoPieza.trim())) {
                        errores.put("tipo", "No se permiten tildes, ni caracteres extraños (ñ ' , . * / ] } ? !)");
                }
                // VALIDANDO COSTO
                if (!DataValidator.isValidString(costo)) {
                        errores.put("costo", "Debes ingresar el costo de la pieza");
                } else if (!DataValidator.isDouble(costo)) {
                        errores.put("costo", "Debes ingresar una cantidad válida mayor a cero");
                }
                // VALIDANDO CANTIDAD
                if (!DataValidator.isValidString(cantidad)) {
                        errores.put("cantidad", "Debes ingresar una cantidad");
                } else if (!DataValidator.isEntero(cantidad)) {
                        errores.put("cantidad", "Debes ingresar un valor entero mayor que cero");
                }

                // CREANDO PIEZA VALIDADA
                if (errores.isEmpty()) {
                        double costoPieza = DataValidator.redondearNumero(Double.parseDouble(costo), 2);
                        Pieza pieza = new Pieza();
                        pieza.setTipo(tipoPieza);
                        pieza.setCosto(costoPieza);
                        pieza.setCantidad(Integer.parseInt(cantidad));
                        service.guardar(pieza);

                        if (Boolean.parseBoolean(isEdit)) {
                                response.sendRedirect(request.getContextPath() + "/user/fabricante/inventario-piezas");
                        } else {
                                response.sendRedirect(request.getContextPath() + "/user/fabricante/crear-pieza.jsp");
                        }

                } else {
                        request.setAttribute("tipo_pieza", tipoPieza);
                        request.setAttribute("costo", costo);
                        request.setAttribute("cantidad", cantidad);
                        request.setAttribute("edit", isEdit);
                        request.setAttribute("errores", errores);
                        getServletContext().getRequestDispatcher("/user/fabricante/crear-pieza.jsp").forward(request,
                                        response);
                }

        }
}

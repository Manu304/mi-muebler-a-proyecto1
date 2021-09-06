/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.cliente;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrojas.pruebas.mi_muebleria.models.Cliente;
import com.mrojas.pruebas.mi_muebleria.services.cliente.ClienteService;
import com.mrojas.pruebas.mi_muebleria.util.DataValidator;

/**
 *
 * @author Manu
 */
@WebServlet(name = "CrearCliente", urlPatterns = { "/user/vendedor/new-cliente" })
public class CrearCliente extends HttpServlet {

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
                String nombre = request.getParameter("c_nombre");
                String nit = request.getParameter("nit");
                String direccion = request.getParameter("direccion");
                String municipio = request.getParameter("municipio");

                ClienteService service = new ClienteService();

                Map<String, String> errores = new HashMap<>();

                // VALIDANDO NOMBRE
                if (!DataValidator.isValidString(nombre)) {
                        errores.put("c_nombre", "Ingrese el nombre del cliente");
                } else if (!DataValidator.isAlfanumerico(nombre)) {
                        errores.put("c_nombre", "No se permiten tildes, ni caracteres extraños (ñ ' , . * / ] } ? !)");
                } else if (nombre.trim().length() > 45) {
                        errores.put("c_nombre", "El usuario no puede tener más de 45 caracteres");
                        request.setAttribute("c_nombre", "");
                }
                //VALIDANDO NIT
                if (!DataValidator.isValidString(nit)) {
                        errores.put("nit", "Ingrese el nit del cliente");
                }else if (!DataValidator.isAlfanumerico(nit)) {
                        errores.put("nit", "No se permiten tildes, ni caracteres extraños (ñ ' , . * / ] } ? !)");
                }
                //VALIDANDO DIRECCION
                if (!DataValidator.isValidString(direccion)) {
                        errores.put("direccion", "Ingrese la direccion del cliente");
                }

        }

}

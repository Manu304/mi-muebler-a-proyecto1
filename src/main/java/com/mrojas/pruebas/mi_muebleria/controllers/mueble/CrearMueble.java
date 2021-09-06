/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.controllers.mueble;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrojas.pruebas.mi_muebleria.models.Mueble;
import com.mrojas.pruebas.mi_muebleria.util.DataValidator;

/**
 *
 * @author Manu
 */
@WebServlet(name = "CrearMueble", urlPatterns = { "/user/admin/new-mueble" })
public class CrearMueble extends HttpServlet {

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
        String nombre = request.getParameter("m_nombre");
        String precio = request.getParameter("precio");
        String isEdit = request.getParameter("edit");

        Map<String, String> errores = new HashMap<>();
        // VALIDANDO NOMBRE DEL MUEBLE
        if (!DataValidator.isValidString(nombre)) {
            errores.put("m_nombre", "Debes de escribir el nombre del mueble");
        } else if (!DataValidator.isAlfanumerico(nombre)) {
            errores.put("m_nombre", "No se permiten tildes, ni caracteres extraños (ñ ' , . * / ] } ? !)");
        }
        // VALIDANDO PRECIO
        if (!DataValidator.isValidString(precio)) {
            errores.put("precio", "Debes ingresar el precio que tendrá el mueble");
        } else if (!DataValidator.isDouble(precio)) {
            errores.put("precio", "Debes ingresar una cantidad válida mayor a cero");
        }

        //CREANDO MUEBLE VALIDADO
        if (errores.isEmpty()) {
            double precioMueble = DataValidator.redondearNumero(Double.parseDouble(precio), 2);
            Mueble mueble = new Mueble();
            mueble.setNombre(nombre.trim());
            mueble.setPrecio(precioMueble);

            //VALIDAR REDIRECCIONAMIENTO CUANDO SEA UN EDIT
        }else{
            request.setAttribute("m_nombre", nombre);
            request.setAttribute("precio", precio);
            request.setAttribute("edit", isEdit);
            request.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/user/admin/crear-mueble.jsp").forward(request,
            response);
        }
    }

}

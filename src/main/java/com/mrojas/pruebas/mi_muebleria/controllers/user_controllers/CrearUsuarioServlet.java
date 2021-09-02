package com.mrojas.pruebas.mi_muebleria.controllers.user_controllers;

import com.mrojas.pruebas.mi_muebleria.models.users.Usuario;
import com.mrojas.pruebas.mi_muebleria.services.LoginServiceSession;
import com.mrojas.pruebas.mi_muebleria.services.UserService;
import com.mrojas.pruebas.mi_muebleria.util.DataValidator;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manu
 */
@WebServlet(name = "CrearUsuarioServlet", urlPatterns = { "/user/admin/new-user" })
public class CrearUsuarioServlet extends HttpServlet {

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
        String tipo = request.getParameter("tipo");
        String esEdit = request.getParameter("edit");
        String username = request.getParameter("username");
        LoginServiceSession loginService = new LoginServiceSession();

        if (DataValidator.isValidString(username) && Boolean.parseBoolean(esEdit) && DataValidator.isEntero(tipo)
                && !loginService.isUserSession(request, username)) {
            request.setAttribute("edit", esEdit);
            request.setAttribute("username", username);
            request.setAttribute("tipo", tipo);
            getServletContext().getRequestDispatcher("/user/admin/crear-usuario.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/user/admin/control");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passworConfirm = request.getParameter("passwordConfirm");
        String userRole = request.getParameter("role");
        String esEdit = request.getParameter("edit");

        System.out.println("nombre en edit: " + username);

        System.out.println("Edit post : " + esEdit);

        UserService service = new UserService();
        Optional<Usuario> usuarioEdit = service.porIdentificador(username);
        Map<String, String> errores = new HashMap<>();

        // VALIDANDO USERNAME
        if (!DataValidator.isValidString(username)) {
            errores.put("username", "Debes escribir un nombre de usuario");
        } else {
            username = username.trim();
        }
        if (usuarioEdit.isPresent() && !Boolean.parseBoolean(esEdit)) {
            errores.put("username", "Ese nombre de usuario ya ha sido registrado");
        }
        if (usuarioEdit.isEmpty() && Boolean.parseBoolean(esEdit)) {
            errores.put("username", "No puede cambiar el nombre al usuario");
        }
        // VALIDANDO CONTRASEÑAS
        if (!DataValidator.isValidString(password) || !DataValidator.isValidString(passworConfirm)) {
            errores.put("password", "Debes escribir una contraseña");
        }
        if (!password.equals(passworConfirm)) {
            errores.put("cpassword", "Las contraseñas no coinciden");
        }

        if (!DataValidator.isEntero(userRole)) {
            errores.put("role", "Debe seleccionar el área del usuario");
        }

        // CREANDO USUARIO YA VALIDADO
        if (errores.isEmpty()) {
            Usuario newUser = new Usuario();
            newUser.setActivo(true);
            newUser.setNombre(username);
            newUser.setPassword(password);
            newUser.setTipo(Integer.parseInt(userRole));
            service.guardar(newUser);
            if (Boolean.parseBoolean(esEdit)) {
                response.sendRedirect(request.getContextPath() + "/user/admin/control");
            } else {
                response.sendRedirect(request.getContextPath() + "/user/admin/crear-usuario.jsp");
            }

        } else {
            if (Boolean.parseBoolean(esEdit)) {
                request.setAttribute("username", username);
                request.setAttribute("tipo", userRole);
            }
            request.setAttribute("edit", esEdit);
            request.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/user/admin/crear-usuario.jsp").forward(request, response);
        }

    }

}
